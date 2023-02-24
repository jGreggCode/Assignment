package Main;

import java.awt.*;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;

import Jswing.JButtonCusomCircle;
import Jswing.JCheckBoxCustom;
import Jswing.JRadioButtonCustom;
import Jswing.JTextFieldCustomTwo;

public class IssuanceFrame extends JFrame implements ActionListener, MouseListener {
    
    // Prerequisite Components
    ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Images/NULogo.png"));
    ImageIcon imgIssue = new ImageIcon(getClass().getResource("/Images/plus.png"));
    ImageIcon imgCancel = new ImageIcon(getClass().getResource("/Images/cancel.png"));
    ImageIcon imgLogout = new ImageIcon(getClass().getResource("/Images/logout.png"));
    ImageIcon imgDelete = new ImageIcon(getClass().getResource("/Images/delete.png"));
    ImageIcon imgBack = new ImageIcon(getClass().getResource("/Images/back.png"));

    // Panels
    private JPanel panelLeft = new JPanel();
    private JPanel panelRight = new JPanel();
    private JPanel panelBottom = new JPanel();

    // Left panel labels
    private JLabel labelLTitle = new JLabel();
    private JLabel labelLStudentID = new JLabel();
    private JLabel labelLStudentName = new JLabel();
    private JLabel labelLIssueDate = new JLabel();
    private JLabel labelLYearLevel = new JLabel();
    private JLabel labelEducation = new JLabel();

    // Left panel textfields
    private JTextFieldCustomTwo txtStudentID = new JTextFieldCustomTwo();
    private JTextFieldCustomTwo txtStudentName = new JTextFieldCustomTwo();
    private JTextFieldCustomTwo txtIssueDate = new JTextFieldCustomTwo();
    private JTextFieldCustomTwo txtYearLevel = new JTextFieldCustomTwo();

    // Right Panel Components

    private JLabel labelCourseAndProgram = new JLabel();
    private JLabel labelProfessionalSubjects = new JLabel();
    private JLabel labelGeneralSubjects = new JLabel();

    // Radio Buttons
    private JRadioButtonCustom rbBSIT = new JRadioButtonCustom();
    private JRadioButtonCustom rbBSBA = new JRadioButtonCustom();
    private JRadioButtonCustom rbDenTech = new JRadioButtonCustom();
    private JRadioButtonCustom rbPsych = new JRadioButtonCustom();
    private ButtonGroup programGroup = new ButtonGroup();

    // Professional Subjects Checkboxes 
    private JCheckBoxCustom chkSub1 = new JCheckBoxCustom();
    private JCheckBoxCustom chkSub2 = new JCheckBoxCustom();
    private JCheckBoxCustom chkSub3 = new JCheckBoxCustom();
    private JCheckBoxCustom chkSub4 = new JCheckBoxCustom();
    private JCheckBoxCustom chkSub5 = new JCheckBoxCustom();

    // General Subjects Checkboxes
    private JCheckBoxCustom chkGSub1 = new JCheckBoxCustom();
    private JCheckBoxCustom chkGSub2 = new JCheckBoxCustom();
    private JCheckBoxCustom chkGSub3 = new JCheckBoxCustom();
    private JCheckBoxCustom chkGSub4 = new JCheckBoxCustom();
    private JCheckBoxCustom chkGSub5 = new JCheckBoxCustom();

    // Bottom panel Buttons
    private JButtonCusomCircle btnIssue = new JButtonCusomCircle();
    private JButtonCusomCircle btnCancel = new JButtonCusomCircle();
    private JButtonCusomCircle btnLogout = new JButtonCusomCircle();
    private JButtonCusomCircle btnDelete = new JButtonCusomCircle();
    private JButtonCusomCircle btnBack = new JButtonCusomCircle();

    private JCheckBoxCustom[] arrCheckBoxes = 
    {
        chkSub1, 
        chkSub2, 
        chkSub3, 
        chkSub4, 
        chkSub5, 
        chkGSub1, 
        chkGSub2, 
        chkGSub3, 
        chkGSub4, 
        chkGSub5
    };

    // Method needed

    // Resizing the icons
    public ImageIcon imageResize(ImageIcon img, int width, int heigth) {
        Image imgToResize = img.getImage();
        Image imgResizing = imgToResize.getScaledInstance(width, heigth, Image.SCALE_SMOOTH);
        ImageIcon imgResized = new ImageIcon(imgResizing);
        return imgResized;
    }

    // Set selected to all checkboxes to false
    public void clearCheckBox() {
        for (int i = 0; i < arrCheckBoxes.length; i++) {
            arrCheckBoxes[i].setSelected(false);
        }
    }
    
    public IssuanceFrame() {
        setUndecorated(true);
        setSize(1300, 750);
        getContentPane().setBackground(new Color(24,29,64,255));
        setTitle("Issueance Of Book");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(imgLogo.getImage());

        programGroup.add(rbBSBA);
        programGroup.add(rbBSIT);
        programGroup.add(rbDenTech);
        programGroup.add(rbPsych);

        panelLeft.setBounds(40, 30, 590, 550);
        panelLeft.setBackground(new Color(249, 246, 238));
        panelLeft.setLayout(null);

        labelLTitle.setText("ISSUANCE OF BOOK");
        labelLTitle.setForeground(Color.black);
        labelLTitle.setFont(new Font("Verdana", Font.BOLD, 20));
        labelLTitle.setBounds(40, 20, 300, 50);

        labelLStudentID.setText("<html>Student ID:<font color='#FF0000'>*</font></html>");
        labelLStudentID.setBounds(40, 80, 350, 35);
        labelLStudentID.setForeground(Color.black);
        labelLStudentID.setFont(new Font("Verdana", Font.BOLD, 15));

        txtStudentID.setHint("Ex: 12-342-32");
        txtStudentID.setBounds(40, 120, 350, 35);

        labelLStudentName.setText("<html>Student Name:<font color='#FF0000'>*</font></html>");
        labelLStudentName.setBounds(40, 170, 350, 35);
        labelLStudentName.setForeground(Color.black);
        labelLStudentName.setFont(new Font("Verdana", Font.BOLD, 15));

        txtStudentName.setHint("Ex: John Gregg V. Felicisimo");
        txtStudentName.setBounds(40, 210, 350, 35);
        
        labelLIssueDate.setText("<html>Issue Date:<font color='#FF0000'>*</font></html>");
        labelLIssueDate.setBounds(40, 260, 350, 35);
        labelLIssueDate.setForeground(Color.black);
        labelLIssueDate.setFont(new Font("Verdana", Font.BOLD, 15));

        txtIssueDate.setHint("Ex: Jun 13 2023");
        txtIssueDate.setBounds(40, 300, 350, 35);

        labelLYearLevel.setText("<html>Year Level:<font color='#FF0000'>*</font></html>");
        labelLYearLevel.setBounds(40, 350, 350, 35);
        labelLYearLevel.setForeground(Color.black);
        labelLYearLevel.setFont(new Font("Verdana", Font.BOLD, 15));

        txtYearLevel.setHint("Ex: 1");
        txtYearLevel.setBounds(40, 390, 350, 35);

        labelEducation.setText("EDUCATION THAT WORKS");
        labelEducation.setBounds(40, 460, 350, 35);
        labelEducation.setForeground(new Color(24,29,64,255));
        labelEducation.setFont(new Font("Verdana", Font.BOLD, 20));
        labelEducation.setIcon(imageResize(imgLogo, 35,35));

        panelLeft.add(labelLTitle);

        panelLeft.add(labelLStudentID);
        panelLeft.add(txtStudentID);

        panelLeft.add(labelLStudentName);
        panelLeft.add(txtStudentName);

        panelLeft.add(labelLIssueDate);
        panelLeft.add(txtIssueDate);

        panelLeft.add(labelLYearLevel);
        panelLeft.add(txtYearLevel);

        panelLeft.add(labelEducation);

        panelRight.setBounds(670, 30, 590, 550);
        panelRight.setBackground(new Color(249, 246, 238));
        panelRight.setLayout(null);

        labelCourseAndProgram.setText("Course/Program");
        labelCourseAndProgram.setBounds(40, 20, 350, 35);
        labelCourseAndProgram.setForeground(Color.black);
        labelCourseAndProgram.setFont(new Font("Verdana", Font.BOLD, 18));

        rbBSIT.setText("BSIT");
        rbBSIT.setForeground(Color.black);
        rbBSIT.setFont(new Font("Verdana", Font.BOLD, 13));
        rbBSIT.setBounds(60, 60, 100, 30);
        rbBSIT.addActionListener(this);
        
        rbBSBA.setText("BSBA");
        rbBSBA.setForeground(Color.black);
        rbBSBA.setFont(new Font("Verdana", Font.BOLD, 13));
        rbBSBA.setBounds(160, 60, 100, 30);
        rbBSBA.addActionListener(this);

        rbDenTech.setText("DENTECH");
        rbDenTech.setForeground(Color.black);
        rbDenTech.setFont(new Font("Verdana", Font.BOLD, 13));
        rbDenTech.setBounds(260, 60, 100, 30);
        rbDenTech.addActionListener(this);
        
        rbPsych.setText("PSYCHOLOGY");
        rbPsych.setForeground(Color.black);
        rbPsych.setFont(new Font("Verdana", Font.BOLD, 13));
        rbPsych.setBounds(360, 60, 150, 30);
        rbPsych.addActionListener(this);

        labelProfessionalSubjects.setText("Professional Subjects");
        labelProfessionalSubjects.setForeground(Color.black);
        labelProfessionalSubjects.setFont(new Font("Verdana", Font.BOLD, 18));
        labelProfessionalSubjects.setBounds(40, 120, 350, 30);

        chkSub1.setText("Pro Sub 1");
        chkSub1.setForeground(Color.black);
        chkSub1.setFont(new Font("Verdana", Font.BOLD, 13));
        chkSub1.setBounds(60, 160, 350, 30);

        chkSub2.setText("Pro Sub 2");
        chkSub2.setForeground(Color.black);
        chkSub2.setFont(new Font("Verdana", Font.BOLD, 13));
        chkSub2.setBounds(60, 180, 350, 30);

        chkSub3.setText("Pro Sub 3");
        chkSub3.setForeground(Color.black);
        chkSub3.setFont(new Font("Verdana", Font.BOLD, 13));
        chkSub3.setBounds(60, 200, 350, 30);
        
        chkSub4.setText("Pro Sub 4");
        chkSub4.setForeground(Color.black);
        chkSub4.setFont(new Font("Verdana", Font.BOLD, 13));
        chkSub4.setBounds(60, 220, 350, 30);
        
        chkSub5.setText("Pro Sub 5");
        chkSub5.setForeground(Color.black);
        chkSub5.setFont(new Font("Verdana", Font.BOLD, 13));
        chkSub5.setBounds(60, 240, 350, 30);
        
        labelGeneralSubjects.setText("General Education Subjects");
        labelGeneralSubjects.setForeground(Color.black);
        labelGeneralSubjects.setFont(new Font("Verdana", Font.BOLD, 18));
        labelGeneralSubjects.setBounds(40, 300, 500, 30);

        chkGSub1.setText("General Education Sub 1");
        chkGSub1.setForeground(Color.black);
        chkGSub1.setFont(new Font("Verdana", Font.BOLD, 13));
        chkGSub1.setBounds(60, 340, 350, 30);
        
        chkGSub2.setText("General Education Sub 2");
        chkGSub2.setForeground(Color.black);
        chkGSub2.setFont(new Font("Verdana", Font.BOLD, 13));
        chkGSub2.setBounds(60, 360, 340, 30);
        
        chkGSub3.setText("General Education Sub 3");
        chkGSub3.setForeground(Color.black);
        chkGSub3.setFont(new Font("Verdana", Font.BOLD, 13));
        chkGSub3.setBounds(60, 380, 340, 30);

        chkGSub4.setText("General Education Sub 4");
        chkGSub4.setForeground(Color.black);
        chkGSub4.setFont(new Font("Verdana", Font.BOLD, 13));
        chkGSub4.setBounds(60, 400, 340, 30);
        
        chkGSub5.setText("General Education Sub 5");
        chkGSub5.setForeground(Color.black);
        chkGSub5.setFont(new Font("Verdana", Font.BOLD, 13));
        chkGSub5.setBounds(60, 420, 340, 30);

        panelRight.add(labelCourseAndProgram);
        panelRight.add(rbBSIT);
        panelRight.add(rbBSBA);
        panelRight.add(rbDenTech);
        panelRight.add(rbPsych);

        panelRight.add(labelProfessionalSubjects);
        panelRight.add(chkSub1);
        panelRight.add(chkSub2);
        panelRight.add(chkSub3);
        panelRight.add(chkSub4);
        panelRight.add(chkSub5);

        panelRight.add(labelGeneralSubjects);
        panelRight.add(chkGSub1);
        panelRight.add(chkGSub2);
        panelRight.add(chkGSub3);
        panelRight.add(chkGSub4);
        panelRight.add(chkGSub5);

        panelBottom.setBounds(40, 610, 1220, 120);
        panelBottom.setBackground(new Color(249, 246, 238));
        panelBottom.setLayout(null);

        btnIssue.setIcon(imageResize(imgIssue, 50, 50));
        btnIssue.setBounds(1220 / 2 - (70 / 2), 110 / 2 - (70 / 2), 70, 70);
        btnIssue.setBackground(new Color(0x34418e));
        btnIssue.addMouseListener(this);

        btnCancel.setIcon(imageResize(imgCancel, 30, 30));
        btnCancel.setBounds(1220 / 2 - (70 / 2) + 80, 110 / 2 - (50 / 2), 50, 50);
        btnCancel.setBackground(new Color(0x34418e));
        btnCancel.addMouseListener(this);
        
        btnLogout.setIcon(imageResize(imgLogout, 30, 30));
        btnLogout.setBounds(1220 / 2 - (70 / 2) + 90 + 50, 110 / 2 - (50 / 2), 50, 50);
        btnLogout.setBackground(new Color(0x34418e));
        btnLogout.addMouseListener(this);

        btnDelete.setIcon(imageResize(imgDelete, 30, 30));
        btnDelete.setBounds(1220 / 2 - (70 / 2) - 60, 110 / 2 - (50 / 2), 50, 50);
        btnDelete.setBackground(new Color(0x34418e));
        btnDelete.addMouseListener(this);
        
        btnBack.setIcon(imageResize(imgBack, 30, 30));
        btnBack.setBounds(1220 / 2 - (70 / 2) - 60 - 60, 110 / 2 - (50 / 2), 50, 50);
        btnBack.setBackground(new Color(0x34418e));
        btnBack.addMouseListener(this);

        panelBottom.add(btnIssue);
        panelBottom.add(btnCancel);
        panelBottom.add(btnLogout);
        panelBottom.add(btnDelete);
        panelBottom.add(btnBack);

        add(panelLeft);
        add(panelRight);
        add(panelBottom);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        clearCheckBox();

        if (e.getSource() == rbBSIT) {
            chkSub1.setText("IT1");
            chkSub2.setText("IT2");
            chkSub3.setText("IT3");
            chkSub4.setText("IT4");
            chkSub5.setText("IT5");

            chkGSub1.setText("IT6");
            chkGSub2.setText("IT7");
            chkGSub3.setText("IT8");
            chkGSub4.setText("IT9");
            chkGSub5.setText("IT10");
        }

        if (e.getSource() == rbBSBA) {
            chkSub1.setText("BA1");
            chkSub2.setText("BA2");
            chkSub3.setText("BA3");
            chkSub4.setText("BA4");
            chkSub5.setText("BA5");

            chkGSub1.setText("BA6");
            chkGSub2.setText("BA7");
            chkGSub3.setText("BA8");
            chkGSub4.setText("BA9");
            chkGSub5.setText("BA10");
        }

        if (e.getSource() == rbDenTech) {
            chkSub1.setText("TEC1");
            chkSub2.setText("TEC2");
            chkSub3.setText("TEC3");
            chkSub4.setText("TEC4");
            chkSub5.setText("TEC5");

            chkGSub1.setText("TEC6");
            chkGSub2.setText("TEC7");
            chkGSub3.setText("TEC8");
            chkGSub4.setText("TEC9");
            chkGSub5.setText("TEC10");
        }

        if (e.getSource() == rbPsych) {
            chkSub1.setText("PY1");
            chkSub2.setText("PY2");
            chkSub3.setText("PY3");
            chkSub4.setText("PY4");
            chkSub5.setText("PY5");

            chkGSub1.setText("PY6");
            chkGSub2.setText("PY7");
            chkGSub3.setText("PY8");
            chkGSub4.setText("PY9");
            chkGSub5.setText("PY10");
        }

    }

    // Mouse Events
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == btnBack) {
            this.dispose();
        }
        
        if (e.getSource() == btnLogout) {
            System.exit(0);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getSource() == btnIssue) {
            btnIssue.setBackground(new Color(0xffd320));
        }
        
        if (e.getSource() == btnCancel) {
            btnCancel.setBackground(new Color(0xffd320));
        }

        if (e.getSource() == btnLogout) {
            btnLogout.setBackground(new Color(0xffd320));
        }
        
        if (e.getSource() == btnDelete) {
            btnDelete.setBackground(new Color(0xffd320));
        }
        
        if (e.getSource() == btnBack) {
            btnBack.setBackground(new Color(0xffd320));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getSource() == btnIssue) {
            btnIssue.setBackground(new Color(0x34418e));
        }
        
        if (e.getSource() == btnCancel) {
            btnCancel.setBackground(new Color(0x34418e));
        }

        if (e.getSource() == btnLogout) {
            btnLogout.setBackground(new Color(0x34418e));
        }
        
        if (e.getSource() == btnDelete) {
            btnDelete.setBackground(new Color(0x34418e));
        }
        
        if (e.getSource() == btnBack) {
            btnBack.setBackground(new Color(0x34418e));
        }
    }
}
