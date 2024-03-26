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

                //check register test
                //System.out.println(MyJDBC.register("FireBlastGaming", "sisnem2016", "Zulfiqar", "Abdulali", "Male", "Tanzanian", 19751124L,
                // "3y53t,2426424,y5t5t g3,t5f3g3,ring", 555976652, 558831521, "Staff", 20231123L, 20251124L, true, 20241124L, 20261125L, "5626246462446fgg",
                // "426264262464627", "564fghhhhh2"));


                // check validate login test
                //System.out.println(MyJDBC.validateLogin("FireBlastGaming", "sisnem2016"));
            }
        });
    }
}
