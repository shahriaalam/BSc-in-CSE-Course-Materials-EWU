import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

public class UserLogin implements ActionListener
{
    JFrame f = new JFrame("User Login Panel");
    Color clr1 = new Color(252, 251, 251);
    Color clr2 = new Color(192, 192, 192);
    JTextField txt1 = new JTextField();
    JPasswordField pass = new JPasswordField();
    JLabel lbl = new JLabel();
    JLabel lbl1 = new JLabel();
    JLabel lbl2 = new JLabel();
    JButton btn = new JButton();
    JButton bt = new JButton();
    Cursor cr = new Cursor(Cursor.HAND_CURSOR);
    Font fh = new Font("Trebuchet MS", Font.BOLD, 30);
    Font fs = new Font("Trebuchet MS", Font.BOLD, 13);
    Container c = f.getContentPane();

    public UserLogin() {
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setBounds(430, 120, 425, 375);
        f.setTitle(" User Login Panel");
        f.setResizable(false);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.setBackground(clr1);
        c.setLayout(null);

        txt1.setBounds(192, 127, 160, 30);
        txt1.setFont(fs);
        txt1.setForeground(Color.BLACK);

        pass.setBounds(192, 188, 160, 30);
        pass.setFont(fs);
        pass.setEchoChar('*');
        pass.setForeground(Color.BLACK);

        lbl.setBounds(30, 32, 350, 50);
        lbl.setText("User Login");
        lbl.setFont(fh);
        lbl.setForeground(Color.BLACK);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);

        lbl1.setBounds(43, 130, 110, 25);
        lbl1.setText("Username:");
        lbl1.setForeground(Color.BLACK);
        lbl1.setFont(fs);
        lbl1.setHorizontalAlignment(SwingConstants.RIGHT);

        lbl2.setBounds(43, 192, 110, 25);
        lbl2.setText("Password:");
        lbl2.setForeground(Color.BLACK);
        lbl2.setFont(fs);
        lbl2.setHorizontalAlignment(SwingConstants.RIGHT);

        btn.setBounds(230, 270, 100, 28);
        btn.setText("Log In");
        btn.setBackground(clr2);
        btn.setForeground(Color.BLACK);
        btn.setCursor(cr);
        btn.addActionListener(this);

        bt.setBounds(80, 270, 100, 28);
        bt.setText("Signup");
        bt.setBackground(clr2);
        bt.setForeground(Color.BLACK);
        bt.setCursor(cr);
        bt.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new SignUp ();
                f.setVisible(false);
            }
        });

        c.add(lbl);
        c.add(lbl1);
        c.add(lbl2);
        c.add(btn);
        c.add(bt);
        c.add(txt1);
        c.add(pass);
    }

    public void actionPerformed(ActionEvent evt)
    {
        try {
            String user, password;
            user = txt1.getText();
            password = pass.getText();
            File FI = new File("F:\\EWU\\Course matarial\\CSE110 (MDH sir)\\Project\\Text\\User.txt");
            Scanner A = new Scanner(FI);
            while (A.hasNextLine())
            {
                String US = A.next();
                String PASS = A.next();
                if (user.equals(US) && password.equals(PASS))
                {

                    JOptionPane.showMessageDialog(null, "Welcome");
                    new UserInterface();
                    f.setVisible(false);
                    break;
                }
            }
            A.close();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Wrong Input\nTry again", "Wrong Input", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());
        }
    }
}