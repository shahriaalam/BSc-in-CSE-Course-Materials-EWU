import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;

public class AdminTotalBooking
{
    JFrame f = new JFrame("Admin Total Booking");
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JButton a = new JButton("RETURN");
    JTable JP=new JTable();
    JButton b = new JButton("SHOW");
    public AdminTotalBooking()
    {
        f.setVisible(true);
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\5.jpg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,580);

        a.setBounds(780, 510, 100, 40);
        b.setBounds(650, 510, 100, 40);
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
                    Scanner input = new Scanner(new FileReader(FI2));
                    int row = 0;
                    int col = 0;
                    while (input.hasNextLine())
                    {
                        String line = input.nextLine();
                        row++;
                        col = line.split(" ").length;
                    }
                    input.close();
                    String[][] d = new String[row][col];
                    input = new Scanner(new FileReader(FI2));

                    for (int i = 0; i < row; i++)
                    {
                        for (int j = 0; j < col; j++)
                        {
                            d[i][j] = input.next();
                        }
                        String column[] = {"USER ","FROM", "TO", "BUS NAME","SEAT","PRICE"};
                        JTable T = new JTable(d, column);
                        JScrollPane JP = new JScrollPane(T);
                        JP.setBounds(0, 0, 950, 500);
                        f.add(JP);
                    }
                    input.close();
                }
                catch (FileNotFoundException ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });

        a.setCursor(cr);
        b.setCursor(cr);
        f.add(JP);
        f.add(a);
        f.add(b);
        f.add(bg);
        f.setSize(1000, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}