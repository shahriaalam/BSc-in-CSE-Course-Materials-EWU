import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.awt.event.*;

class Welcome
{
    JFrame f = new JFrame("Ticket Panda");
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JLabel l =new JLabel("Welcome to Ticket Panda");
    Font fh=new Font("Trebuchet MS",Font.BOLD,20);
    JButton a = new JButton("USER");
    JButton b = new JButton("ADMIN");
    Color clr1=new Color(3, 3, 3);
    Color clr2=new Color(253, 253, 253);
    public Welcome()
    {
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\6.jpg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,800,500);

        a.setBounds(420, 310, 105, 43);
        b.setBounds(250, 310, 105, 43);
        l.setBounds(262, 110, 250, 43);

        a.setCursor(cr);
        b.setCursor(cr);
        l.setFont(fh);
        l.setForeground(clr1);
        l.setOpaque(true);
       l.setBackground(clr2);
        f.add(l);
        f.add(a);
        f.add(b);
        f.add(bg);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        a.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new UserLogin();
                f.setVisible(false);
            }
        });

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new AdminLogin ();
                f.setVisible(false);
            }
        });
        f.setSize(800, 500);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}