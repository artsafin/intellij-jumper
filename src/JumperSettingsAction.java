import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

import javax.swing.*;

/**
 * @author Artur.Safin <treilor@gmail.com>
 * @licence MIT
 */
public class JumperSettingsAction extends AnAction {
    public void actionPerformed(AnActionEvent e)
    {
        JDialog dlg = new JDialog();
        JumperSettings settings = new JumperSettings();
    }
}
