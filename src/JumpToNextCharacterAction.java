import com.intellij.execution.filters.TextConsoleBuilderFactory;
import com.intellij.execution.ui.ConsoleView;
import com.intellij.execution.ui.ConsoleViewContentType;
import com.intellij.openapi.actionSystem.*;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;
import com.intellij.openapi.ui.popup.JBPopupFactory;
import com.intellij.openapi.wm.StatusBar;

import java.util.Arrays;
import java.util.List;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class JumpToNextCharacterAction extends JumpToCharacterAction
{
    protected void doJump(Project project, Editor editor, List<Character> chars)
    {
        JumperSearch search = new JumperSearch();

        int nextCharPos = search.nextChar(
                editor.getCaretModel().getOffset(),
                editor.getDocument().getCharsSequence(),
                chars
        );

        ConsoleView con = TextConsoleBuilderFactory.getInstance().createBuilder(project).getConsole();

        if (nextCharPos > 0)
        {
            con.print("Move to position " + String.valueOf(nextCharPos + 1) + ".", ConsoleViewContentType.NORMAL_OUTPUT);
            editor.getCaretModel().moveToOffset(nextCharPos + 1);
        }
        else
        {
            con.print("Move to position: no position found", ConsoleViewContentType.NORMAL_OUTPUT);
        }
    }

}
