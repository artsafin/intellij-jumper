package com.artsafin.intellij.jumper;

import com.intellij.codeInsight.hint.HintManager;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.ScrollType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.WindowManager;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public abstract class JumpToCharacterAction extends AnAction
{
    public static final String defaultJumpChars = ",({";

    @Override
    public void update(AnActionEvent e) {
        super.update(e);
        e.getPresentation().setEnabled(e.getData(PlatformDataKeys.EDITOR) != null);
    }

    @Override
    public void actionPerformed(AnActionEvent event)
    {
        Editor editor = event.getData(PlatformDataKeys.EDITOR);

        if (editor == null)
            return;

        Project project = event.getProject();

        PropertiesComponent props = PropertiesComponent.getInstance(project);
        String strChars = props.getOrInit("jumper_chars", JumpToCharacterAction.defaultJumpChars);


        List<Character> chars = new ArrayList<Character>();
        for (char c: strChars.toCharArray())
            chars.add(c);

        int nextCharPos = getNextEditorPosition(editor, chars);

        final WindowManager windowManager = WindowManager.getInstance();
        final StatusBar statusBar = windowManager.getStatusBar(project);

        assert statusBar != null;

        if (nextCharPos > 0)
        {
            statusBar.setInfo(String.format("Move to position %s.", String.valueOf(nextCharPos + 1)));
            editor.getCaretModel().moveToOffset(nextCharPos + 1);
            editor.getScrollingModel().scrollToCaret(ScrollType.MAKE_VISIBLE);
        }
        else
        {
            statusBar.setInfo("Move to position: no position found");
            HintManager hm = HintManager.getInstance();
            hm.showInformationHint(editor, "Not found");
        }
    }

    protected abstract int getNextEditorPosition(Editor editor, List<Character> chars);
}
