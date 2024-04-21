package guis;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;

public final class HomePage extends Form{
    public HomePage() {
        super("Home");
        setSize(920, 880);
        setLocationRelativeTo(null);
        addGuiComponents();
    }

    private void addGuiComponents(){

        // create login label
        JLabel loginLabel = new JLabel("Home");

        // configure component's x, y position and width/height values relative to the GUI
        loginLabel.setBounds(0, 25, 920, 100);

        //change the font colour
        loginLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // change the font size
        loginLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // centre text
        loginLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add component to GUI
        add(loginLabel);
    }
}

