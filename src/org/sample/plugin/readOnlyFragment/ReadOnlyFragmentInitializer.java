package org.sample.plugin.readOnlyFragment;

import com.intellij.openapi.components.ProjectComponent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.EditorFactory;
import com.intellij.openapi.editor.RangeMarker;
import com.intellij.openapi.editor.ReadOnlyFragmentModificationException;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorActionManager;
import com.intellij.openapi.editor.actionSystem.ReadonlyFragmentModificationHandler;
import com.intellij.openapi.editor.event.DocumentAdapter;
import com.intellij.openapi.editor.event.DocumentEvent;
import com.intellij.psi.PsiDocumentManager;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;

/**
 * @author nik
 */
public class ReadOnlyFragmentInitializer implements ProjectComponent {
  private PsiDocumentManager myDocumentManager;
  private EditorFactory myEditorFactory;

  public ReadOnlyFragmentInitializer(PsiDocumentManager documentManager, EditorFactory editorFactory) {
    myDocumentManager = documentManager;
    myEditorFactory = editorFactory;
    EditorActionManager.getInstance().setReadonlyFragmentModificationHandler(new ReadonlyFragmentModificationHandler() {
      @Override
      public void handle(ReadOnlyFragmentModificationException e) {

      }
    });
  }

  @Override
  public void projectOpened() {

  }

  @Override
  public void projectClosed() {

  }

  @Override
  public void initComponent() {
    myDocumentManager.addListener(new PsiDocumentManager.Listener() {
      @Override
      public void documentCreated(@NotNull Document document, PsiFile psiFile) {
        createGuardBlock(document);
      }

      @Override
      public void fileCreated(@NotNull PsiFile file, @NotNull Document document) {
      }
    });
    myEditorFactory.getEventMulticaster().addDocumentListener(new DocumentAdapter() {
      @Override
      public void documentChanged(DocumentEvent e) {
        createGuardBlock(e.getDocument());
      }
    });
  }

  private void createGuardBlock(Document document) {
    String text = document.getText();
    int start = text.indexOf("//do-not-modify");
    if (start == -1) return;
    String endMarker = "//end";
    int end = text.indexOf(endMarker, start);
    if (end == -1) return;
    document.createGuardedBlock(start, end + endMarker.length());
  }

  @Override
  public void disposeComponent() {

  }

  @NotNull
  @Override
  public String getComponentName() {
    return "ReadOnlyFragmentInitializer";
  }
}
