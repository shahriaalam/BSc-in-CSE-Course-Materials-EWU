import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class UserInterface
{
    JFrame f = new JFrame("User Interface");
    Font fh=new Font("Trebuchet MS",Font.BOLD,20);
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JLabel bg =new JLabel();
    JButton a = new JButton("Booking Ticket");
    JButton b = new JButton("Cancel Ticket");
    JButton c = new JButton("Ticket Price");
    JButton d = new JButton("Logout");
    public UserInterface()
    {

        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\2.jpg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,600);

        a.setBounds(120, 150, 180, 40);
        b.setBounds(700, 150, 180, 40);
        c.setBounds(400, 150, 180, 40);
        d.setBounds(780, 515, 100, 40);
        a.setFont(fh);
        b.setFont(fh);
        c.setFont(fh);
        d.setFont(fh);

        a.setCursor(cr);
        b.setCursor(cr);
        c.setCursor(cr);
        d.setCursor(cr);
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
                new BookingTicket();
                f.setVisible(false);
            }
        });

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new CancelTicket();
                f.setVisible(false);
            }
        });

        c.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new UserTotalBooking();
                f.setVisible(false);
            }
        });

        d.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Welcome();
                f.setVisible(false);
            }
        });

        f.setSize(1000, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}