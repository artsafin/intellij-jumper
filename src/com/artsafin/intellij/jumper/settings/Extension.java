package com.artsafin.intellij.jumper.settings;

import com.artsafin.intellij.jumper.JumpToCharacterAction;
import com.intellij.ide.DataManager;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.Nls;

import javax.swing.*;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class Extension implements Configurable {
    private JPanel panel1;
    private JTextField textField1;
    private TextFieldListener listener;

    private void createUIComponents() {
    }

    /**
     * Returns the user-visible name of the settings component.
     *
     * @return the visible name of the component.
     */
    @Nls
    @Override
    public String getDisplayName() {
        return "Jumper Settings";
    }

    /**
     * Returns the icon representing the settings component. Components
     * shown in the IDEA settings dialog have 32x32 icons.
     *
     * @return the icon for the component.
     */
    @Override
    public Icon getIcon() {
        return null;
    }

    /**
     * Returns the topic in the help file which is shown when help for the configurable
     * is requested.
     *
     * @return the help topic, or null if no help is available.
     */
    @Override
    public String getHelpTopic() {
        return null;
    }

    /**
     * Returns the user interface component for editing the configuration.
     *
     * @return the component instance.
     */
    @Override
    public JComponent createComponent() {

        DataContext dataContext = DataManager.getInstance().getDataContext();
        Project project = PlatformDataKeys.PROJECT.getData(dataContext);

        PropertiesComponent props = PropertiesComponent.getInstance(project);
        textField1.setText(props.getOrInit("jumper_chars", JumpToCharacterAction.defaultJumpChars));

        listener = new TextFieldListener();
        listener.setInitialValue(textField1.getText());
        textField1.addKeyListener(listener);

        return panel1;
    }

    /**
     * Checks if the settings in the user interface component were modified by the user and
     * need to be saved.
     *
     * @return true if the settings were modified, false otherwise.
     */
    @Override
    public boolean isModified() {
        return listener.isModified();
    }

    /**
     * Store the settings from configurable to other components.
     */
    @Override
    public void apply() throws ConfigurationException {

        DataContext dataContext = DataManager.getInstance().getDataContext();
        Project project = PlatformDataKeys.PROJECT.getData(dataContext);

        PropertiesComponent props = PropertiesComponent.getInstance(project);
        props.setValue("jumper_chars", textField1.getText());

        listener.setInitialValue(textField1.getText());
    }

    /**
     * Load settings from other components to configurable.
     */
    @Override
    public void reset() {
    }

    /**
     * Disposes the Swing components used for displaying the configuration.
     */
    @Override
    public void disposeUIResources() {
    }
}
