package Main;

import java.awt.Color;
import java.awt.Font;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Jswing.JButtonCustomSolid;
import Jswing.JPanelCustom;
import Session.User;

public class ResultFrame extends JFrame {

    IssuanceFrame issuanceFrame;
    
    ImageIcon imgLogo = new ImageIcon(getClass().getResource("/Images/NULogo.png"));

    private JPanelCustom panelProSub = new JPanelCustom();
    private JPanelCustom panelGenSub = new JPanelCustom();
    private JPanelCustom panelInfo = new JPanelCustom();

    private JLabel labelName = new JLabel();
    private JLabel labelProgram = new JLabel();
    private JLabel labelYearJLabel = new JLabel();
    private JLabel labelBooks = new JLabel();
    private JLabel labelPro = new JLabel();
    private JLabel labelGen = new JLabel();
    private JLabel labelProSubs = new JLabel();
    private JLabel labelGenSubs = new JLabel();

    private JButtonCustomSolid btnOk = new JButtonCustomSolid();
    
    public ResultFrame(IssuanceFrame issuanceFrame) {
        this.issuanceFrame = issuanceFrame;
        setUndecorated(true);
        setSize(600, 500);
        getContentPane().setBackground(new Color(24,29,64,255));
        setTitle("Result");
        setLayout(null);
        setResizable(false);
        setLocationRelativeTo(null);
        setIconImage(imgLogo.getImage());

        panelInfo.setRoundBorders(10, 10, 0, 0);
        panelInfo.setLayout(null);
        panelInfo.setBounds(600 / 2 - (300 / 2), 30, 300, 150);

        panelProSub.setRoundBorders(10, 0, 10, 0);
        panelProSub.setLayout(null);
        panelProSub.setBounds(30, 200, 255, 200);

        panelGenSub.setRoundBorders(0, 10, 0, 10);
        panelGenSub.setLayout(null);
        panelGenSub.setBounds(315, 200, 255, 200);

        labelName.setText(User.name);
        labelName.setHorizontalAlignment(JLabel.CENTER);
        labelName.setFont(new Font("Verdana", Font.BOLD, 15));
        labelName.setBounds(0, 20, 300, 20);

        labelProgram.setText("Program: " + User.program);
        labelProgram.setHorizontalAlignment(JLabel.CENTER);
        labelProgram.setFont(new Font("Verdana", Font.BOLD, 15));
        labelProgram.setBounds(0, 60, 300, 20);
        
        labelYearJLabel.setText("Year: " + User.yearLevel);
        labelYearJLabel.setHorizontalAlignment(JLabel.CENTER);
        labelYearJLabel.setFont(new Font("Verdana", Font.BOLD, 15));
        labelYearJLabel.setBounds(0, 80, 300, 20);

        labelBooks.setText("Number of books: " + String.valueOf(User.books));
        labelBooks.setHorizontalAlignment(JLabel.CENTER);
        labelBooks.setFont(new Font("Verdana", Font.BOLD, 15));
        labelBooks.setBounds(0, 100, 300, 20);

        btnOk.setBounds(600 / 2 - (100 / 2), 430, 100, 40);
        btnOk.setFocusable(false);
        btnOk.setText("OK");
        btnOk.setBackground(new Color(0xffd320));
        btnOk.addActionListener(e -> {
            this.dispose();
            issuanceFrame.btnIssue.setEnabled(false);
            issuanceFrame.btnDelete.setEnabled(false);
            issuanceFrame.btnCancel.setEnabled(true);
            for (int i = 0; i < issuanceFrame.arrCheckBoxes.length; i++) {
                issuanceFrame.arrCheckBoxes[i].setEnabled(false);
            }
        });
        
        labelPro.setText("Professional Subjects");
        labelPro.setHorizontalAlignment(JLabel.CENTER);
        labelPro.setFont(new Font("Verdana", Font.BOLD, 15));
        labelPro.setBounds(0, 20, 255, 20);

        String proSubjects = "<html>";
        String genSubjects = "<html>";

        for (int i = 0; i < User.proSubjects.size(); i++) {
            proSubjects = proSubjects + User.proSubjects.get(i) + "<br><br>";
        } 
        
        for (int i = 0; i < User.genSubjects.size(); i++) {
            genSubjects = genSubjects + User.genSubjects.get(i) + "<br><br>";
        }

        labelProSubs.setText(proSubjects);
        labelProSubs.setHorizontalAlignment(JLabel.CENTER);
        labelProSubs.setFont(new Font("Verdana", Font.BOLD, 10));
        labelProSubs.setBounds(10, 45, 235, 150);

        labelGen.setText("General Subjects");
        labelGen.setHorizontalAlignment(JLabel.CENTER);
        labelGen.setFont(new Font("Verdana", Font.BOLD, 15));
        labelGen.setBounds(0, 20, 255, 20);

        labelGenSubs.setText(genSubjects);
        labelGenSubs.setHorizontalAlignment(JLabel.CENTER);
        labelGenSubs.setFont(new Font("Verdana", Font.BOLD, 10));
        labelGenSubs.setBounds(10, 45, 235, 150);

        panelInfo.add(labelName);
        panelInfo.add(labelProgram);
        panelInfo.add(labelYearJLabel);
        panelInfo.add(labelBooks);

        panelProSub.add(labelPro);
        panelProSub.add(labelProSubs);

        panelGenSub.add(labelGen);
        panelGenSub.add(labelGenSubs);

        add(btnOk);
        add(panelInfo);
        add(panelProSub);
        add(panelGenSub);
    }
}
