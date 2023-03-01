package Main;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.text.MaskFormatter;

import java.util.Arrays;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Random;

import Jswing.JButtonCustomSolid;
import Jswing.JButtonCustomTransparent;
import Jswing.JPanelCustom;
import Jswing.JTextFieldCustom;
import Session.User;

import java.awt.*;

public class HomeFrame extends JFrame {

    LoginFrame loginFrame;
    IssuanceFrame issuef;
    ResultFrame res;

    // Prerequisite components //

    // Date today
    Random random = new Random();
    Date date = new Date();  
    SimpleDateFormat formatDate = new SimpleDateFormat("dd MMMM yyyy");
    String dateToday = formatDate.format(date);
    int iconSize = 150;
    int idNumber = random.nextInt(1000000, 2000000);

    // Images
    ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Images/NULogo.png"));
    ImageIcon imgBg = new ImageIcon(getClass().getResource("/Images/NUGradientBG.png"));
    ImageIcon imgBanner = new ImageIcon(getClass().getResource("/Images/NUBanner.png"));

    // User images
    ImageIcon user1 = new ImageIcon(getClass().getResource("/Images/user1.png"));
    ImageIcon user2 = new ImageIcon(getClass().getResource("/Images/user2.png"));
    ImageIcon user3 = new ImageIcon(getClass().getResource("/Images/user3.png"));
    ImageIcon user4 = new ImageIcon(getClass().getResource("/Images/user4.png"));
    ImageIcon user5 = new ImageIcon(getClass().getResource("/Images/user5.png"));
    ImageIcon user = new ImageIcon(getClass().getResource("/Images/user.jpg"));

    // Panels
    private JPanelCustom panelLeft = new JPanelCustom();
    private JPanelCustom panelRight = new JPanelCustom();
    private JPanel bg = new JPanel();

    // Labels Left Panel
    private JLabel labelBanner = new JLabel();
    private JLabel labelName = new JLabel();
    private JLabel labelYearLevel = new JLabel();
    private JLabel labelProgram = new JLabel();
    private JLabel labelAddress = new JLabel();
    private JLabel labelPhoneNo = new JLabel();
    private JLabel labelGuardian = new JLabel();
    private JLabel labelIssuedDate = new JLabel();

    // Textfield left panel
    private JTextFieldCustom txtName = new JTextFieldCustom();
    private JTextFieldCustom txtYearLevel = new JTextFieldCustom();
    private JTextFieldCustom txtProgram = new JTextFieldCustom();
    private JTextFieldCustom txtAddress = new JTextFieldCustom();
    private JTextFieldCustom txtPhoneNo = new JTextFieldCustom();
    private JTextFieldCustom txtGuardian = new JTextFieldCustom();
    private JTextFieldCustom txtIssuedDate = new JTextFieldCustom();

    private JTextFieldCustom[] txtFeilds = {txtName, txtYearLevel, txtProgram, txtAddress, txtPhoneNo, txtGuardian, txtIssuedDate};

    // Labels Right Panel
    private JLabel labelRTitle = new JLabel();
    private JLabel labelRSchoolLogo = new JLabel();
    private JLabel labelRUserPicture = new JLabel();
    private JLabel labelSurname = new JLabel();
    private JLabel labelFirstAndMiddleInitial = new JLabel();
    private JLabel labelRProgram = new JLabel();
    private JLabel labelRID = new JLabel();
    private JLabel labelRIssuedDate = new JLabel();
    private JLabel labelRSignature = new JLabel();

    private JSeparator sepRSignature = new JSeparator();

    // Buttons 
    private JButtonCustomSolid btnGenerate = new JButtonCustomSolid();
    private JButtonCustomSolid btnNewData = new JButtonCustomSolid();
    private JButtonCustomTransparent btnClear = new JButtonCustomTransparent();
    private JButtonCustomTransparent btnLogout = new JButtonCustomTransparent();
    private JButtonCustomSolid btnIssuance = new JButtonCustomSolid();
    // ---------- //

    // Methods needed // 

    // Random image
    public ImageIcon randomUserIcon() {
        Random random = new Random();
        ImageIcon[] usersIcon = {user, user1, user2, user3, user4, user5};
        int rd = random.nextInt(1,6);
        System.out.println(rd);
        ImageIcon selectedIcon = usersIcon[rd];
        return selectedIcon;
        
    }

    // Method to resize the image
    public ImageIcon imageResize(ImageIcon img, int width, int heigth) {
        Image imgToResize = img.getImage();
        Image imgResizing = imgToResize.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
        ImageIcon imgResized = new ImageIcon(imgResizing);
        return imgResized;
    }

    // Method to separate first name, middle, and surname
    public String[] fullName(String fullName) {

        String[] completeName = new String[3];
        String[] splitName = fullName.split(" ");

        if (splitName.length == 5) { 
            completeName[0] = splitName[0] + " " + splitName[1] + " " + splitName[2];
            completeName[1] = splitName[3];
            completeName[2] = splitName[4];
        } else if (splitName.length == 4) {
            completeName[0] = splitName[0] + " " + splitName[1];
            completeName[1] = splitName[2];
            completeName[2] = splitName[3];
        } else if (splitName.length == 3) {
            completeName[0] = splitName[0];
            completeName[1] = splitName[1];
            completeName[2] = splitName[2];
        }

        return completeName;
    }

    // Method to clear all the text boxes
    public void clearAll() {
        txtName.setText("");
        txtYearLevel.setText("");
        txtProgram.setText("");
        txtAddress.setText("");
        txtPhoneNo.setText("");
        txtGuardian.setText("");
    }

    // Method to disable all the text boxes
    public void disableAll() {
        txtName.setEnabled(false);
        txtYearLevel.setEnabled(false);
        txtProgram.setEnabled(false);
        txtAddress.setEnabled(false);
        txtPhoneNo.setEnabled(false);
        txtGuardian.setEnabled(false);
        txtIssuedDate.setEnabled(false);
    }

    // Method to enable all the text boxes
    public void enableAll() {
        txtName.setEnabled(true);
        txtYearLevel.setEnabled(true);
        txtProgram.setEnabled(true);
        txtAddress.setEnabled(true);
        txtPhoneNo.setEnabled(true);
        txtGuardian.setEnabled(true);
        txtIssuedDate.setEnabled(true);
    }
    // ---------- //
    
    public HomeFrame(LoginFrame loginFrame, IssuanceFrame issuef, ResultFrame res) {
        this.loginFrame = loginFrame;
        this.issuef = issuef;
        this.res = res;
        // Home frame configuration
        setTitle("Home");
        setUndecorated(true);
        setSize(1500, 750);
        getContentPane().setBackground(new Color(0xffffff));
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(imgLogo.getImage());

        // Left Panel Components
        panelLeft.setLayout(null);
        panelLeft.setBackground(new Color(0xffd320));
        panelLeft.setBounds(60, 30, 670, 690);
        panelLeft.setRoundBorders(100, 0, 100, 0);

        labelBanner.setIcon(imageResize(imgBanner, 400, 156));
        labelBanner.setBounds(30, 20, 400, 156);

        labelName.setText("<html>Student Name:<font color='#FF0000'>*</font></html>");
        labelName.setForeground(Color.black);
        labelName.setFont(new Font("Verdana", Font.BOLD, 14));
        labelName.setBounds(40, 186, 150, 30);

        txtName.setHint("Ex: John Gregg V. Felicisimo");
        txtName.setBounds(220, 186, 410, 30);

        labelYearLevel.setText("<html>Year Level:<font color='#FF0000'>*</font></html>");
        labelYearLevel.setForeground(Color.black);
        labelYearLevel.setFont(new Font("Verdana", Font.BOLD, 14));
        labelYearLevel.setBounds(40, 236, 150, 30);

        txtYearLevel.setHint("Ex: 1");
        txtYearLevel.setBounds(220, 236, 410, 30);

        labelProgram.setText("<html>Course/Program:<font color='#FF0000'>*</font></html>");
        labelProgram.setForeground(Color.black);
        labelProgram.setFont(new Font("Verdana", Font.BOLD, 14));
        labelProgram.setBounds(40, 286, 200, 30);

        txtProgram.setHint("Ex: BSIT");
        txtProgram.setBounds(220, 286, 410, 30);

        labelAddress.setText("<html>Address:<font color='#FF0000'>*</font></html>");
        labelAddress.setForeground(Color.black);
        labelAddress.setFont(new Font("Verdana", Font.BOLD, 14));
        labelAddress.setBounds(40, 336, 150, 30);

        txtAddress.setHint("Ex: 1234, Jeju St, Pasay");
        txtAddress.setBounds(220, 336, 410, 30);

        labelPhoneNo.setText("<html>Phone Number:<font color='#FF0000'>*</font></html>");
        labelPhoneNo.setForeground(Color.black);
        labelPhoneNo.setFont(new Font("Verdana", Font.BOLD, 14));
        labelPhoneNo.setBounds(40, 386, 150, 30);

        txtPhoneNo.setHint("Ex: 09876543210");
        txtPhoneNo.setBounds(220, 386, 410, 30);

        labelGuardian.setText("<html>Guardian:<font color='#FF0000'>*</font></html>");
        labelGuardian.setForeground(Color.black);
        labelGuardian.setFont(new Font("Verdana", Font.BOLD, 14));
        labelGuardian.setBounds(40, 436, 150, 30);

        txtGuardian.setHint("Ex: John Smith");
        txtGuardian.setBounds(220, 436, 410, 30);

        labelIssuedDate.setText("<html>Issued Date:<font color='#FF0000'>*</font></html>");
        labelIssuedDate.setForeground(Color.black);
        labelIssuedDate.setFont(new Font("Verdana", Font.BOLD, 14));
        labelIssuedDate.setBounds(40, 486, 150, 30);

        txtIssuedDate.setText(dateToday);
        txtIssuedDate.setBounds(220, 486, 410, 30);

        btnGenerate.setText("Generate Card");
        btnGenerate.setForeground(Color.white);
        btnGenerate.setBackground(new Color(0x34418e));
        btnGenerate.setFocusable(false);
        btnGenerate.setBounds(60, 536, 110, 40);
        btnGenerate.addActionListener(e -> {

            String[] programs = {"BSIT","BSBA","DENTECH","PSYCHOLOGY"};
            String chosenProg = txtProgram.getText().toUpperCase();
            
            int emptyFields = 0;

            for (int i = 0; i < txtFeilds.length; i++) {
                if (txtFeilds[i].getText().isEmpty()) {
                    txtFeilds[i].setBorder(BorderFactory.createLineBorder(Color.red, 1));
                    emptyFields++;
                } else {
                    txtFeilds[i].setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                }
            }

            if (emptyFields > 1) {
                JOptionPane.showMessageDialog(null, "Some fields are empty", "Empty Fields", JOptionPane.ERROR_MESSAGE);
                System.out.println(emptyFields);
            } else {
                if (txtName.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Student Name field is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (txtYearLevel.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Year Level field is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (txtProgram.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Course/Program field is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (txtAddress.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Address field is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (txtPhoneNo.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Phone Number field is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (txtGuardian.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Guardian field is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (txtIssuedDate.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Issued Date is empty", "Empty Field", JOptionPane.ERROR_MESSAGE);
                } else if (!Arrays.stream(programs).anyMatch(chosenProg::equals)) {
                    JOptionPane.showMessageDialog(null, "Invalid course program", "Generate Failed", JOptionPane.ERROR_MESSAGE);
                    txtProgram.setBorder(BorderFactory.createLineBorder(Color.red, 1));
                } else {
                    txtProgram.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
                    btnIssuance.setEnabled(true);
                    btnGenerate.setEnabled(false);
                    btnNewData.setEnabled(true);
                    btnClear.setEnabled(false);
    
                    String firstName = fullName(txtName.getText())[0];
                    String middileInitial = fullName(txtName.getText())[1];
                    String lastName = fullName(txtName.getText())[2]; 
                    
                    if (firstName == null) {
                        firstName = "No First Name";
                    }
                    if (middileInitial == null) {
                        middileInitial = "No Middle Initial";
                    }
                    if (lastName == null) {
                        lastName = "No Lastname";
                    }
    
                    labelRUserPicture.setIcon(imageResize(randomUserIcon(), iconSize, iconSize));
    
                    String what = null;
                    MaskFormatter mf;
                    try {
                        mf = new MaskFormatter("**-***-**");
                        mf.setValueContainsLiteralCharacters(false);
                        what = mf.valueToString(String.valueOf(idNumber));
                    } catch (ParseException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
    
                    labelRProgram.setText(txtProgram.getText());
                    labelRID.setText(what);
                    labelSurname.setText(lastName);
                    labelFirstAndMiddleInitial.setText(firstName + " " + middileInitial);
                    labelRSignature.setText(txtName.getText());
                    labelRSignature.setFont(new Font("Kunstler Script", Font.PLAIN, 20));
                    labelRIssuedDate.setText("Date Issued: " + dateToday);

                    User.idNumber = what;
                    User.name = txtName.getText();
                    User.yearLevel = txtYearLevel.getText();
                    User.program = txtProgram.getText();
                    User.address = txtAddress.getText();
                    User.phoneNumber = txtPhoneNo.getText();
                    User.guardian = txtGuardian.getText();
                    User.issuedDate = dateToday;

                    clearAll();
                    disableAll();
                }
            }
            
        });

        btnNewData.setText("New Data");
        btnNewData.setEnabled(false);
        btnNewData.setForeground(Color.white);
        btnNewData.setBackground(new Color(0x34418e));
        btnNewData.setFocusable(false);
        btnNewData.setBounds(190, 536, 110, 40);
        btnNewData.addActionListener(e -> {
            clearAll();
            enableAll();
            btnIssuance.setEnabled(false);
            btnNewData.setEnabled(false);
            btnGenerate.setEnabled(true);
            btnClear.setEnabled(true);

            labelRProgram.setText("Program");
            labelRUserPicture.setIcon(null);
            labelRID.setText("ID Number");
            labelSurname.setText("Lastname");
            labelFirstAndMiddleInitial.setText("First Name, Middle Initital");
            labelRSignature.setText("Signature");
            labelRSignature.setFont(new Font("Verdana", Font.BOLD, 20));
            labelRIssuedDate.setText("Date Issued: --");

        });

        btnClear.setText("Clear");
        btnClear.setFocusable(false);
        btnClear.setBounds(350, 536, 110, 40);
        btnClear.addActionListener(e -> {
            clearAll();
        });

        btnLogout.setText("Logout");
        btnLogout.setFocusable(false);
        btnLogout.setBounds(480, 536, 110, 40);
        btnLogout.addActionListener(e -> {
            this.dispose();
            loginFrame.setVisible(true);
        });

        btnIssuance.setText("Proceed");
        btnIssuance.setFocusable(false);
        btnIssuance.setEnabled(false);
        btnIssuance.setForeground(Color.white);
        btnIssuance.setBackground(new Color(0x34418e));
        btnIssuance.setBounds(520, 606, 110, 40);
        btnIssuance.addActionListener(e -> {
            int answer = JOptionPane.showConfirmDialog(null, "Do you want to proceed to Issuance Of Book?", "Are you sure?", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                new IssuanceFrame(res).setVisible(true);
            } 
        });

        panelLeft.add(labelBanner);

        panelLeft.add(labelName);
        panelLeft.add(txtName);

        panelLeft.add(labelYearLevel);
        panelLeft.add(txtYearLevel);

        panelLeft.add(labelProgram);
        panelLeft.add(txtProgram);

        panelLeft.add(labelAddress);
        panelLeft.add(txtAddress);
        
        panelLeft.add(labelPhoneNo);
        panelLeft.add(txtPhoneNo);

        panelLeft.add(labelGuardian);
        panelLeft.add(txtGuardian);

        panelLeft.add(labelIssuedDate);
        panelLeft.add(txtIssuedDate);
        
        panelLeft.add(btnGenerate);
        panelLeft.add(btnNewData);
        panelLeft.add(btnClear);
        panelLeft.add(btnLogout);
        panelLeft.add(btnIssuance);
        // ----------

        // Left Panel Components
        panelRight.setLayout(null);
        panelRight.setBackground(new Color(249, 246, 238));
        panelRight.setBounds(770, 30, 670, 690);
        panelRight.setRoundBorders(0, 100, 0, 100);

        labelRTitle.setText("National University Library Card");
        labelRTitle.setForeground(Color.black);
        labelRTitle.setHorizontalAlignment(JLabel.CENTER);
        labelRTitle.setFont(new Font("Verdana", Font.BOLD, 24));
        labelRTitle.setBounds(0, 0, 670, 80);

        labelRSchoolLogo.setText("NU MOA");
        labelRSchoolLogo.setFont(new Font("Verdana", Font.BOLD, 50));
        labelRSchoolLogo.setHorizontalAlignment(JLabel.CENTER);
        labelRSchoolLogo.setIcon(imageResize(imgLogo, 90, 90));
        labelRSchoolLogo.setBounds(0, 70, 670, 128);

        labelRUserPicture.setBorder(BorderFactory.createLineBorder(Color.black, 3));
        labelRUserPicture.setBounds(670 / 2 - (iconSize / 2), 190, iconSize, iconSize);
        
        labelRID.setText("ID Number");
        labelRID.setFont(new Font("Verdana", Font.BOLD, 18));
        labelRID.setBounds(0, 340, 670, 40);
        labelRID.setHorizontalAlignment(JLabel.CENTER);

        labelSurname.setText("Lastname");
        labelSurname.setFont(new Font("Verdana", Font.BOLD, 25));
        labelSurname.setBounds(0, 390, 670, 50);
        labelSurname.setHorizontalAlignment(JLabel.CENTER);
        
        labelFirstAndMiddleInitial.setText("First Name, Middle Initial");
        labelFirstAndMiddleInitial.setFont(new Font("Verdana", Font.BOLD, 25));
        labelFirstAndMiddleInitial.setBounds(0, 430, 670, 50);
        labelFirstAndMiddleInitial.setHorizontalAlignment(JLabel.CENTER);

        labelRProgram.setText("Program");
        labelRProgram.setFont(new Font("Verdana", Font.BOLD, 25));
        labelRProgram.setBounds(0, 480, 670, 50);
        labelRProgram.setHorizontalAlignment(JLabel.CENTER);

        labelRSignature.setText("Signature");
        labelRSignature.setFont(new Font("Verdana", Font.BOLD, 20));
        labelRSignature.setBounds(0, 536, 670, 50);
        labelRSignature.setHorizontalAlignment(JLabel.CENTER);

        sepRSignature.setForeground(Color.black);
        sepRSignature.setBounds(670 / 2 - (250 / 2), 580, 250, 30);

        labelRIssuedDate.setText("Issued Date: --");
        labelRIssuedDate.setFont(new Font("Verdana", Font.BOLD, 12));
        labelRIssuedDate.setBounds(20, 600, 300, 30);
        labelRIssuedDate.setHorizontalAlignment(JLabel.CENTER);

        panelRight.add(labelRTitle);
        panelRight.add(labelRSchoolLogo);
        panelRight.add(labelRUserPicture);

        panelRight.add(labelSurname);
        panelRight.add(labelFirstAndMiddleInitial);
        panelRight.add(labelRProgram);
        panelRight.add(labelRID);
        panelRight.add(labelRSignature);
        panelRight.add(sepRSignature);
        panelRight.add(labelRIssuedDate);

        // Background Panel
        bg.setBackground(new Color(24,29,64,255));
        bg.setBounds(0,0, 1500, 750);

        // adding the components
        add(panelRight);
        add(panelLeft);
        add(bg);
    }
}
