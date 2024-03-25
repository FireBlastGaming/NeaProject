import db.MyJDBC;
import guis.LoginFormGUI;

import javax.swing.*;

public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // instantiate a LoginForGUI object and make it visible
                //new LoginFormGUI().setVisible(true);

                // check user test
                //System.out.println(MyJDBC.checkUser("FireBlastG"));

                //check table test
                //System.out.println(MyJDBC.checkTable("STAFF"));
                //System.out.println(MyJDBC.checkTable("CLIENT_COMPANIES"));
                //System.out.println(MyJDBC.checkTable("CUSTOMERS"));
                //System.out.println(MyJDBC.checkTable("STOCK"));
            }
        });
    }
}
