package Main;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import java.awt.event.*;    
import Jswing.JCheckBoxCustom;

import javax.swing.JPanel;

public class LoginFrame extends JFrame {

    // Prerequisite Components/Variables
    IssuanceFrame issueFrame = new IssuanceFrame();
    HomeFrame homeFrame = new HomeFrame(this, issueFrame);

    LoginPanel loginPanel = new LoginPanel(this, homeFrame);

    private JLabel background = new JLabel();

    // Images
    ImageIcon img = new ImageIcon(getClass().getResource("/Images/NUBackground.png"));
    ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Images/NULogo.png"));
    
    public LoginFrame() {
        // Configure Login frame
        setTitle("NU Library System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1880, 901);
        setLayout(null);
        setResizable(false);
        setIconImage(imgLogo.getImage());
        setLocationRelativeTo(null);

        background.setIcon(img);
        background.setBounds(0, 0, 1880, 901);
        background.setOpaque(false);

        add(background, -1);
        add(loginPanel, 0);
    }

    public class LoginPanel extends JPanel implements ActionListener {

        // Login error count
        int count = 0;
        
        // Prerequisite Components/Variables
        LoginFrame lf;
        HomeFrame hf;

        // Default Account
        String email = "felicisimo@edu.ph";
        String pass = "166509";

        // Bottom Panel
        private JPanel panelBottom = new JPanel();

        // Login Panel Labels, textfields, separators, checkbox, and buttons
        private JLabel labelFooter = new JLabel();
        private JLabel logo = new JLabel();
        private JLabel labelLogin = new JLabel();
        private JLabel labelForgotPass = new JLabel();
        private JLabel labelUseApp = new JLabel();
        private CustomTextField username = new CustomTextField();
        private CustomPasswordField password = new CustomPasswordField();
        private JSeparator usersep = new JSeparator();
        private JSeparator passsep = new JSeparator();
        private JButton btnLogin = new JButton();
        private JButton btnClear = new JButton();
        private JCheckBoxCustom chkShowPassword = new JCheckBoxCustom();

        // Images
        ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Images/NUBanner.png"));
        Image image = imgLogo.getImage();
        Image resizedImg = image.getScaledInstance(100, 39, Image.SCALE_SMOOTH);
        ImageIcon newLogo = new ImageIcon(resizedImg);

        public LoginPanel(LoginFrame lf, HomeFrame hf) {
            this.lf = lf;
            this.hf = hf;
            setLayout(null);
            setBackground(Color.white);
            setBounds(1880 / 2 - (400 / 2),901 / 2 - (550 / 2), 400, 550);

            panelBottom.setBackground(new Color(232,232,232));
            panelBottom.setLayout(null);
            panelBottom.setBounds(0, 400, 400, 550);

            logo.setIcon(newLogo);
            logo.setBounds(20, 30, 100, 39);
            add(logo);

            labelLogin.setText("Enter your account");
            labelLogin.setFont(new Font("Monoscape", Font.BOLD, 18));
            labelLogin.setBounds(50, 90, 400, 20);
            add(labelLogin);

            username.setHint("Username");
            username.setBorder(BorderFactory.createEmptyBorder());
            username.setFont(new Font("Monoscape", Font.PLAIN, 15));
            username.setBounds(400 / 2 - (300 / 2), 120, 300, 50);
            add(username);

            usersep.setBounds(400 / 2 - (300 / 2), 170, 300, 50);
            usersep.setForeground(Color.blue);
            add(usersep);

            password.setHint("Password");
            password.setBorder(BorderFactory.createEmptyBorder());
            password.setFont(new Font("Monoscape", Font.PLAIN, 15));
            password.setBounds(400 / 2 - (300 / 2), 190, 300, 50);
            add(password);

            passsep.setBounds(400 / 2 - (300 / 2), 240, 300, 50);
            passsep.setForeground(Color.blue);
            add(passsep);

            labelForgotPass.setText("Forgot my password");
            labelForgotPass.setForeground(new Color(0x34418e));
            labelForgotPass.setFont(new Font("Monoscape", Font.PLAIN, 11));
            labelForgotPass.setCursor(new Cursor(Cursor.HAND_CURSOR));
            labelForgotPass.setBounds(50, 250, 150, 25);
            add(labelForgotPass);

            chkShowPassword.setText("Show password");
            chkShowPassword.setForeground(Color.black);
            chkShowPassword.setFont(new Font("Monoscape", Font.PLAIN, 11));
            chkShowPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
            chkShowPassword.setBounds(245, 250, 150, 25);
            chkShowPassword.addActionListener(this);
            add(chkShowPassword);
            
            labelUseApp.setText("Use an app instead");
            labelUseApp.setForeground(new Color(0x34418e));
            labelUseApp.setFont(new Font("Monoscape", Font.PLAIN, 11));
            labelUseApp.setCursor(new Cursor(Cursor.HAND_CURSOR));
            labelUseApp.setBounds(50, 270, 150, 25);
            add(labelUseApp);

            btnLogin.setText("LOGIN");
            btnLogin.setFocusable(false);
            btnLogin.setForeground(Color.white);
            btnLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnLogin.setBackground(new Color(0x34418e));
            btnLogin.setBorder(BorderFactory.createEmptyBorder());
            btnLogin.setBounds(400 / 2 - (75 / 2) - 50, 310, 75, 35);
            btnLogin.addActionListener(this);
            add(btnLogin);

            btnClear.setText("CLEAR");
            btnClear.setFocusable(false);
            btnClear.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnClear.setBackground(Color.white);
            btnClear.setBorder(BorderFactory.createLineBorder(Color.black, 1));
            btnClear.setBounds(400 / 2 - (75 / 2) + 50, 310, 75, 35);
            btnClear.addActionListener(this);
            add(btnClear);
            
            String stringFooter = "This program is made for assignment purposes only and is for the exclusive use of NU Employees, Students, and Partners. Visit www.national-u.edu.ph for details. Visit the IT Resource Office of your School branch or email itro@national-u.edu.ph";
            labelFooter.setText("<html>"+ stringFooter +"</html>");
            labelFooter.setBounds(20, 0, 370, 150);
            labelFooter.setFont(new Font("Monoscape", Font.PLAIN, 15));
            labelFooter.setForeground(new Color(96,96,96));
            
            add(panelBottom);
            panelBottom.add(labelFooter);

            lf.getRootPane().setDefaultButton(btnLogin);
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == chkShowPassword) {
                if (chkShowPassword.isSelected()) {
                    password.setEchoChar((char)0); 
                 } else {
                    password.setEchoChar('*');
                 }
            }

            String userPassword = String.valueOf(password.getPassword());

            if (e.getSource() == btnClear) {
                    username.setText("");
                    password.setText("");
            }

            if (e.getSource() == btnLogin) {

                if(count <= 4) {

                    if (username.getText().equalsIgnoreCase(email) && userPassword.equals(pass)) {
                        int answer = JOptionPane.showConfirmDialog(null, "Do you want to proceed to the main page?", "Login successfully", JOptionPane.YES_NO_OPTION);
                        if (answer == 0) {
                            username.setText("");
                            password.setText("");
                            lf.dispose();
                            hf.setVisible(true);
                        } else if (answer == 1) {
                            username.setText("");
                            password.setText("");
                            count = 0;
                        } 
                    } else if (username.getText().equalsIgnoreCase(email) && !userPassword.equals(pass)) {
                        count++;
                        JOptionPane.showMessageDialog(null, "Password is incorrect", "Login failed", JOptionPane.ERROR_MESSAGE);
                        password.setText("");
                    } else if (!username.getText().equalsIgnoreCase(email) && userPassword.equals(pass)) {
                        count++;
                        JOptionPane.showMessageDialog(null, "Username is incorrect", "Login failed", JOptionPane.ERROR_MESSAGE);
                        username.setText("");
                    } else {
                        count++;
                        username.setText("");
                        password.setText("");
                        JOptionPane.showMessageDialog(null, "Username and password are incorrect", "Login failed", JOptionPane.ERROR_MESSAGE);
                    }

                }

                if (count == 4) {
                    username.setText("");
                    password.setText("");
                    username.setEnabled(false);
                    password.setEnabled(false);
                    btnLogin.setEnabled(false);
                    btnClear.setEnabled(false);
                }

            }

            if (e.getSource() == btnClear) {

            }
                
            }
    }

    public class CustomTextField extends JTextField {

        private String hint = "";

        public String getHint() {
            return hint;
        }
    
        public void setHint(String hint) {
            this.hint = hint;
        }


        public CustomTextField() {
            setBackground(Color.white);
            setOpaque(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (getText().length() == 0) {
                int h = getHeight();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                Insets ins = getInsets();
                FontMetrics fm = g.getFontMetrics();
                g.setColor(new Color(200, 200, 200));
                g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
            }
        }
    }

    public class CustomPasswordField extends JPasswordField {

        
        private String hint = "";

        public String getHint() {
            return hint;
        }
    
        public void setHint(String hint) {
            this.hint = hint;
        }

        public CustomPasswordField() {
            setBackground(Color.white);
            setOpaque(true);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (getPassword().length == 0) {
                int h = getHeight();
                ((Graphics2D) g).setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                Insets ins = getInsets();
                FontMetrics fm = g.getFontMetrics();
                g.setColor(new Color(200, 200, 200));
                g.drawString(hint, ins.left, h / 2 + fm.getAscent() / 2 - 2);
            }
        }
    }

}
