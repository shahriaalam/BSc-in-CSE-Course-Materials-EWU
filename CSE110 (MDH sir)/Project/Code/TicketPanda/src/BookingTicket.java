import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class BookingTicket
{
    JFrame f = new JFrame("Booking Ticket");
    JTextField txt1 = new JTextField();
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JLabel lbl3 = new JLabel();
    JLabel lbl4 = new JLabel();
    JLabel lbl5 = new JLabel();
    final JLabel label = new JLabel();

    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    Font fs = new Font("Trebuchet MS", Font.BOLD, 20);
    Font fa = new Font("Trebuchet MS", Font.BOLD, 17);
    JButton a = new JButton("RETURN");
    JButton b = new JButton("CONFIRM");

    JButton c = new JButton("PRINT");
    JTextArea TP= new JTextArea();
    JComboBox JC=new JComboBox();
    JComboBox JC1=new JComboBox();
    JComboBox JB=new JComboBox();
    JComboBox JS=new JComboBox();
    public BookingTicket()
    {
        JLabel bg;
        ImageIcon img= new ImageIcon("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\File Storage\\AII.jpeg");
        bg=new JLabel("",img,JLabel.CENTER);
        bg.setBounds(0,0,1000,580);

        a.setBounds(780, 510, 100, 40);
        b.setBounds(650, 510, 100, 40);
        c.setBounds(520, 510, 100, 40);
        a.setCursor(cr);
        b.setCursor(cr);
        c.setCursor(cr);

        a.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new UserInterface();
                f.setVisible(false);
            }
        });


        b.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int result = JOptionPane.showConfirmDialog(f,"Sure? You want to Conform?", "Conformation",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION)
                {
                    label.setText("You selected: Yes");
                    try
                    {
                        String user, from, to, bus, seat;
                        user = txt1.getText();
                        from=JC.getSelectedItem().toString();
                        to=JC1.getSelectedItem().toString();
                        bus=JB.getSelectedItem().toString();
                        seat = JS.getSelectedItem().toString();

                        String From, To;
                        From = JC.getSelectedItem().toString();
                        To = JC1.getSelectedItem().toString();;
                        File FI2 = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Price.txt");
                        Scanner A = new Scanner(FI2);

                        if(user.equals(""))
                        {
                            JOptionPane.showMessageDialog(null,"Plese Enter Your Name","Wrong Input",JOptionPane.ERROR_MESSAGE);
                            new BookingTicket();
                        }
                        if(from.equals(to))
                        {
                            JOptionPane.showMessageDialog(null,"Destination Selection wrong","Wrong Input",JOptionPane.ERROR_MESSAGE);
                            new BookingTicket();
                        }
                        while (A.hasNextLine())
                        {
                            String FROM = A.next();
                            String TO = A.next();
                            String PRICE=A.next();
                            if (From.equals(FROM) && To.equals(TO))
                            {
                                String p = PRICE;
                                int P1= Integer.parseInt(p);
                                int P2= Integer.parseInt(seat);
                                int res=P1*P2;
                                String resul= String.valueOf(res);
                                File FI = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Booking.txt");
                                BufferedWriter BF = new BufferedWriter(new FileWriter(FI, true));
                                BF.write(user + " "+from+ " "+to+" "+ bus+" "+ seat + " "+resul+"\n");
                                BF.close();
                                new BookingTicket();
                                f.setVisible(true);
                                break;
                            }
                        }
                    }
                    catch (Exception ev)
                    {
                        System.out.println(ev.getMessage());
                    }
                }
                else if (result == JOptionPane.NO_OPTION)
                {
                    label.setText("You selected: No");
                    new BookingTicket();
                    f.setVisible(false);
                }
                else
                {
                    new BookingTicket();
                    label.setText("None selected");
                }
                f.setVisible(false);
            }
        });

        c.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    String user, from, to, bus, seat;
                    user = txt1.getText();
                    from=JC.getSelectedItem().toString();
                    to=JC1.getSelectedItem().toString();
                    bus=JB.getSelectedItem().toString();
                    seat = JS.getSelectedItem().toString();
                    String From, To;
                    From = JC.getSelectedItem().toString();
                    To = JC1.getSelectedItem().toString();;
                    File FI2 = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Price.txt");
                    Scanner A = new Scanner(FI2);

                    while (A.hasNextLine())
                    {
                        String FROM = A.next();
                        String TO = A.next();
                        String PRICE=A.next();
                        if (From.equals(FROM) && To.equals(TO))
                        {
                            String p = PRICE;
                            int P1= Integer.parseInt(p);
                            int P2= Integer.parseInt(seat);
                            int res=P1*P2;
                            String resul= String.valueOf(res);
                            String column[] = {"USER ","FROM", "TO", "BUS NAME","SEAT","Per Ticket Price","PRICE"};
                            String d1[][]={{user,from,to,bus,seat,p,resul}};
                            JTable T1 = new JTable(d1, column);
                            JScrollPane JP1 = new JScrollPane(T1);
                            JP1.setBounds(0, 0, 950, 500);
                            f.add(JP1);
                            break;
                        }
                    }
                    A.close();
                }
                catch (Exception ev)
                {
                    System.out.println(ev.getMessage());
                }
            }
        });

        txt1.setBounds(192, 90, 160, 30);
        txt1.setFont(fs);
        txt1.setForeground(Color.BLACK);

        lbl1.setBounds(100, 90, 110, 25);
        lbl1.setText("NAME:");
        lbl1.setForeground(Color.BLACK);
        lbl1.setFont(fs);

        lbl2.setBounds(100, 127, 110, 25);
        lbl2.setText("FROM:");
        lbl2.setForeground(Color.BLACK);
        lbl2.setBackground(Color.WHITE);
        lbl2.setFont(fs);

        lbl3.setBounds(100, 167, 110, 25);
        lbl3.setText("TO:");
        lbl3.setForeground(Color.BLACK);
        lbl3.setBackground(Color.WHITE);
        lbl3.setFont(fs);

        lbl4.setBounds(100, 204, 110, 25);
        lbl4.setText("BUS:");
        lbl4.setForeground(Color.BLACK);
        lbl4.setBackground(Color.WHITE);
        lbl4.setFont(fs);

        lbl5.setBounds(75, 241, 110, 25);
        lbl5.setText("TOTAL SEAT:");
        lbl5.setForeground(Color.BLACK);
        lbl5.setBackground(Color.WHITE);
        lbl5.setFont(fa);

        String filePath = "F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\From.txt";
        File file = new File(filePath);
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();
            for(int i = 0; i < lines.length; i++)
            {
                String line = lines[i].toString();
                JC.addItem(line);
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }


        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file));
            Object[] lines = br.lines().toArray();

            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                JC1.addItem(line);
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }

        String filePath3 = "F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Bus.txt";
        File file3 = new File(filePath3);
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file3));
            Object[] lines = br.lines().toArray();
            for(int i = 0; i < lines.length; i++)
            {
                String line = lines[i].toString();
                JB.addItem(line);
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }

        String filePath2 = "F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\Seat.txt";
        File file2 = new File(filePath2);
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(file2));
            Object[] lines = br.lines().toArray();

            for(int i = 0; i < lines.length; i++){
                String line = lines[i].toString();
                JS.addItem(line);
            }

        }
        catch (FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }

        JC.setBounds(192, 127, 160, 30);
        JC1.setBounds(192, 167, 160, 30);
        JB.setBounds(192, 204, 160, 30);
        JS.setBounds(192, 241, 160, 30);
        f.add(a);
        f.add(b);
        f.add(c);
        f.add(JC);
        f.add(JC1);
        f.add(JB);
        f.add(JS);
        f.add(TP);
        f.add(txt1);
        f.add(lbl1);
        f.add(lbl2);
        f.add(lbl3);
        f.add(lbl4);
        f.add(lbl5);
        f.add(bg);
        f.setSize(1000, 600);
        f.setLayout(null);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}