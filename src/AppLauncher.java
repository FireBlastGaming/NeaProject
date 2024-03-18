import guis.LoginFormGUI;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate a LoginForGUI object and make it visible
                new LoginFormGUI().setVisible(true);
            }
        });
    }
}
