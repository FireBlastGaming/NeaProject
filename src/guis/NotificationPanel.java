package guis;

import constants.CommonConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class NotificationPanel extends Form implements WindowListener {
    public NotificationPanel(String notific) {
        super("Notification Panel");
        setSize(920, 880);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        this.addWindowListener(this);
        enqueue(notific);
        addGuiComponents();
    }
    public static int head = -1;
    public static int tail = -1;
    private static final int maxSize = 5;
    static String[] queue = new String[maxSize];
    private void addGuiComponents(){
        // create notif label
        JLabel notifLabel = new JLabel("Notification Panel");

        // configure component's x, y position and width/height values relative to the GUI
        notifLabel.setBounds(0, 25, 920, 100);

        //change the font colour
        notifLabel.setForeground(CommonConstants.TEXT_COLOUR);

        // change the font size
        notifLabel.setFont(new Font("Dialog", Font.BOLD, 40));

        // centre text
        notifLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // add component to GUI
        add(notifLabel);

        JLabel queue1 = new JLabel(queue[4]);
        queue1.setBounds(0, 200, 920, 55);
        queue1.setForeground(CommonConstants.TEXT_COLOUR);
        queue1.setFont(new Font("Dialog", Font.PLAIN, 30));
        queue1.setHorizontalAlignment(SwingConstants.CENTER);
        add(queue1);

        JLabel queue2 = new JLabel(queue[3]);
        queue2.setBounds(0, 250, 920, 55);
        queue2.setForeground(CommonConstants.TEXT_COLOUR);
        queue2.setFont(new Font("Dialog", Font.PLAIN, 30));
        queue2.setHorizontalAlignment(SwingConstants.CENTER);
        add(queue2);

        JLabel queue3 = new JLabel(queue[2]);
        queue3.setBounds(0, 300, 920, 55);
        queue3.setForeground(CommonConstants.TEXT_COLOUR);
        queue3.setFont(new Font("Dialog", Font.PLAIN, 30));
        queue3.setHorizontalAlignment(SwingConstants.CENTER);
        add(queue3);

        JLabel queue4 = new JLabel(queue[1]);
        queue4.setBounds(0, 350, 920, 55);
        queue4.setForeground(CommonConstants.TEXT_COLOUR);
        queue4.setFont(new Font("Dialog", Font.PLAIN, 30));
        queue4.setHorizontalAlignment(SwingConstants.CENTER);
        add(queue4);

        JLabel queue5 = new JLabel(peek());
        queue5.setBounds(0, 400, 920, 55);
        queue5.setForeground(CommonConstants.TEXT_COLOUR);
        queue5.setFont(new Font("Dialog", Font.PLAIN, 30));
        queue5.setHorizontalAlignment(SwingConstants.CENTER);
        add(queue5);
    }
    public void enqueue(String notif)
    {
        if (tail == maxSize - 1){
            System.out.println("Full!");

        } else {
            if (!Objects.equals(notif, "")) {
                JOptionPane.showMessageDialog(this, "Ordered");
                tail++;
                queue[tail] = notif;
                if (head == -1) {
                    head = 0;
                }
            }
        }
    }
    private String peek(){
        if (head == -1 || head > tail) {
            JOptionPane.showMessageDialog(this, "Notification Panel is empty!");
        } else {
            return queue[head];
        }
        return null;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        BufferedReader fr;
        try {
            fr = new BufferedReader(new InputStreamReader(new FileInputStream("src/resources/orderList.txt")));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
        String line;
        int i = -1;
        while(true) {
            try {
                if ((line = fr.readLine()) == null) break;
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            i += 1;
            queue[i] = line;
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {
        PrintWriter orderList = null;
        try {
            orderList = new PrintWriter("src/resources/orderList.txt", StandardCharsets.UTF_8);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        orderList.println(queue[4]);
        orderList.println(queue[3]);
        orderList.println(queue[2]);
        orderList.println(queue[1]);
        orderList.println(peek());
        orderList.close();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
