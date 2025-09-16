import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class CancelTicket
{

    JFrame f = new JFrame("Cancel Ticket");
    JTextField txt1 = new JTextField();
    Font fs=new Font("Trebuchet MS",Font.BOLD,20);
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    JButton a = new JButton("RETURN");
    JButton c = new JButton("DELETE");
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel lbl3 = new JLabel();
    final JLabel label = new JLabel();
    JComboBox JC=new JComboBox();
    JComboBox JC1=new JComboBox();
    public CancelTicket()
    {
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\3.jpg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,580);


        a.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new UserInterface();
                f.setVisible(false);
            }
        });


        c.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                int result = JOptionPane.showConfirmDialog(f,"Sure? You want to Conform?", "Conformation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION)
                {
                    label.setText("You selected: Yes");
                    try {
                        String user, From, To;
                        user = txt1.getText();
                        From = JC.getSelectedItem().toString();
                        To = JC1.getSelectedItem().toString();

                        File FI2 = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Booking.txt");
                        File F = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Temp.txt");
                        Scanner A = new Scanner(FI2);
                        while (A.hasNext())
                        {
                            String USER = A.next();
                            String FROM = A.next();
                            String TO = A.next();
                            String BUS = A.next();
                            String SEAT = A.next();
                            String PRICE = A.next();

                            if (USER.equals(user) && From.equals(FROM) && To.equals(TO)) {
                                continue;
                            } else {
                                BufferedWriter BW = new BufferedWriter(new FileWriter(F, true));
                                BW.write(USER + " " + FROM + " " + TO + " " + BUS + " " + SEAT + " " + PRICE + "\n");
                                BW.close();
                            }
                        }
                        A.close();
                        FI2.delete();
                        F.renameTo(FI2);
                    } catch (Exception e1) {
                        System.out.println(e1.getMessage());
                    }
                }
                else if (result == JOptionPane.NO_OPTION)
                {
                    label.setText("You selected: No");
                    new CancelTicket();
                    f.setVisible(false);
                }
                else
                {
                    new CancelTicket();
                    label.setText("None selected");
                }
            }
        });


        String filePath = "F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\From.txt";
        File file = new File(filePath);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();

            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                JC.addItem(line);
            }

        } catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();

            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                JC1.addItem(line);
            }

        } catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }


        a.setBounds(780, 510, 100, 40);
        c.setBounds(650, 510, 100, 40);
        JC.setBounds(192, 475, 160, 30);
        JC1.setBounds(192, 511, 160, 30);
        txt1.setBounds(192, 440, 160, 30);
        txt1.setFont(fs);
        txt1.setForeground(Color.BLACK);

        lbl1.setBounds(100, 445, 110, 25);
        lbl1.setText("NAME:");
        lbl1.setForeground(Color.WHITE);
        lbl1.setFont(fs);

        lbl2.setBounds(100, 480, 110, 25);
        lbl2.setText("FROM:");
        lbl2.setForeground(Color.WHITE);
        lbl2.setBackground(Color.WHITE);
        lbl2.setFont(fs);

        lbl3.setBounds(100, 515, 110, 25);
        lbl3.setText("TO:");
        lbl3.setForeground(Color.WHITE);
        lbl3.setBackground(Color.WHITE);
        lbl3.setFont(fs);

        f.add(a);
        f.add(c);
        f.add(JC);
        f.add(JC1);
        f.add(txt1);
        f.add(lbl1);
        f.add(lbl2);
        f.add(lbl3);
        f.add(bg);
        f.setSize(1000, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}