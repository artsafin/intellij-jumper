package com.artsafin.intellij.jumper.settings;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.fileEditor.impl.EditorTabColorProvider;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.options.ShowSettingsUtil;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class Action extends AnAction {
    public void actionPerformed(AnActionEvent e)
    {
        ShowSettingsUtil.getInstance().editConfigurable(e.getProject(), new Extension());
    }
}
