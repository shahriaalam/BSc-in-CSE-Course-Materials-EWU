import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BusList
{
    JFrame f = new JFrame("Bus List");
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JButton a = new JButton("OK");
    JButton b = new JButton("SHOW");
    JTable A= new JTable();

    public BusList()
    {
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\3.jpg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,580);
        b.setBounds(650, 510, 100, 40);
        a.setBounds(780, 510, 100, 40);
        a.setCursor(cr);
        b.setCursor(cr);

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
                    File FI2 = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\BusList.txt");
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
                        String column[] = {"USER ","FROM", "TO", "BUS"};
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

        f.add(new JScrollPane(A));
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