import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class TotalSell
{
    JFrame f = new JFrame("Total Sell");
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JButton a = new JButton("RETURN");
    JLabel A1= new JLabel();
    JButton b = new JButton("SHOW");
    Font fh = new Font("Trebuchet MS", Font.BOLD, 30);
    public TotalSell()
    {
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\1.jpg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,580);

        a.setBounds(780, 510, 100, 40);
        b.setBounds(650, 510, 100, 40);
        A1.setBounds(300, 250, 390, 40);
        A1.setForeground(Color.BLACK);
        A1.setFont(fh);


        a.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new AdminInterface();
                f.setVisible(false);
            }
        });

        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    File FI2 = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Booking.txt");
                    Scanner A = new Scanner(FI2);
                    int sum=0;
                    while (A.hasNext())
                    {
                        String USER = A.next();
                        String FROM = A.next();
                        String TO = A.next();
                        String BUS = A.next();
                        String SEAT = A.next();
                        String PRICE=A.next();
                        int P1= Integer.parseInt(PRICE);
                        sum+=P1;
                    }
                    A1.setText("Total Ticket Sell: "+sum+" TK");
                    A1.setOpaque(true);
                    A1.setBackground(Color.white);
                    A.close();
                }
                catch (FileNotFoundException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });
        a.setCursor(cr);
        b.setCursor(cr);
        f.add(a);
        f.add(b);
        f.add(A1);
        f.add(bg);
        f.setSize(1000, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}