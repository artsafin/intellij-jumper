import com.intellij.openapi.editor.Editor;

import java.util.List;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class JumpToPrevCharacterAction extends JumpToCharacterAction
{
    protected int getNextEditorPosition(Editor editor, List<Character> chars)
    {
        final JumperSearch search = new JumperSearch();

        return search.prevChar(
                editor.getCaretModel().getOffset() - 1,
                editor.getDocument().getCharsSequence(),
                chars
        );
    }
}
