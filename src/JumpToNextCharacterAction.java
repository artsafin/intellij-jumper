import com.intellij.openapi.editor.Editor;

import java.util.List;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class JumpToNextCharacterAction extends JumpToCharacterAction
{
    protected int getNextEditorPosition(Editor editor, List<Character> chars)
    {
        JumperSearch search = new JumperSearch();

        return search.nextChar(
                editor.getCaretModel().getOffset(),
                editor.getDocument().getCharsSequence(),
                chars
        );
    }

}
