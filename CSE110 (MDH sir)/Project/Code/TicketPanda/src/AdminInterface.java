import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminInterface {

    JFrame f = new JFrame("Admin Interface");
    Font fh=new Font("Trebuchet MS",Font.BOLD,20);
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JLabel l =new JLabel();
    JButton a = new JButton("Total Booking");
    JButton b = new JButton("Bus List");
    JButton c = new JButton("Logout");
    JButton d = new JButton("Total Sell");
    public AdminInterface()
    {
        f.setVisible(true);
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\AII.jpeg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,580);

        a.setBounds(170, 150, 170, 40);
        b.setBounds(680, 150, 140, 40);
        c.setBounds(730, 510, 100, 40);
        d.setBounds(410, 150, 200, 40);
        a.setFont(fh);
        b.setFont(fh);
        c.setFont(fh);
        d.setFont(fh);
        a.setCursor(cr);
        b.setCursor(cr);
        c.setCursor(cr);
        d.setCursor(cr);

        f.add(l);
        f.add(a);
        f.add(b);
        f.add(c);
        f.add(d);
        f.add(bg);
        f.setLocationRelativeTo(null);

        a.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new AdminTotalBooking();
                f.setVisible(false);
            }
        });

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new BusList();
                f.setVisible(false);
            }
        });

        c.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Welcome();
                f.setVisible(false);
            }
        });

        d.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new TotalSell();
                f.setVisible(false);
            }
        });

        f.setSize(1000, 600);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}