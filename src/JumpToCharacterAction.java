import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;

import java.util.Arrays;
import java.util.List;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public abstract class JumpToCharacterAction extends AnAction
{
    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        e.getPresentation().setEnabled(e.getData(DataKeys.EDITOR) != null);
    }

    @Override
    public void actionPerformed(AnActionEvent event)
    {
        Editor editor = (Editor)event.getData(DataKeys.EDITOR);

        if (editor == null)
            return;

        // TODO: make this list to go from the settings of the plugin
        List<Character> chars = (List<Character>) Arrays.asList(',', '(');

        doJump(event.getProject(), editor, chars);
    }

    protected abstract void doJump(Project project, Editor editor, List<Character> chars);
}