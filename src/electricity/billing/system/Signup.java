package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Signup extends JFrame implements ActionListener {
    Choice loginSCho;
    TextField meterText, employerText, userNameText,nameText, passwordText;
    JButton create,back;
    Signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(168,203,255));

        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,50,125,20);
        add(createAs);

        loginSCho = new Choice();
        loginSCho.add("Admin");
        loginSCho.add("Customer");
        loginSCho.setBounds(170,50,120,20);
        add(loginSCho);

        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,100,125,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170,100,125,20);
        meterText.setVisible(false);
        add(meterText);

        JLabel employer = new JLabel("Employer ID");
        employer.setBounds(30,100,125,20);
        employer.setVisible(true);
        add(employer);

        employerText = new TextField();
        employerText.setBounds(170,100,125,20);
        employerText.setVisible(true);
        add(employerText);

        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,140,125,20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(170,140,125,20);
        add(userNameText);

        JLabel name = new JLabel("Name");
        name.setBounds(30,180,125,20);
        add(name);

        nameText = new TextField();
        nameText.setBounds(170,180,125,20);
        add(nameText);

        JLabel password = new JLabel("password");
        password.setBounds(30,220,125,20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(170,220,125,20);
        add(passwordText);

        loginSCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
              String user = loginSCho.getSelectedItem();
              if (user.equals("Customer")){
                  employer.setVisible(false);
                  employerText.setVisible(false);
                  meterNo.setVisible(true);
                  meterText.setVisible(true);
              }else {
                  employer.setVisible(true);
                  employerText.setVisible(true);
                  meterNo.setVisible(false);
                  meterText.setVisible(false);
              }
            }
        });

        create= new JButton("Create");
        create.setBackground(new Color(66,127,219));
        create.setForeground(Color.black);
        create.setBounds(50,285,100,25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(66,127,219));
        back.setForeground(Color.black);
        back.setBounds(180,285,108,25);
        back.addActionListener(this);
        add(back);

        ImageIcon boyIcon = new ImageIcon(ClassLoader.getSystemResource("icon/boy.jpg"));
        Image boyImg = boyIcon.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
        ImageIcon boyIcon2 = new ImageIcon(boyImg);
        JLabel boyLabel = new JLabel(boyIcon2);
        boyLabel.setBounds(320,30,250,250);
        add(boyLabel);

        setSize(600,380);
        setLocation(500,200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == create){
            String sloginAs = loginSCho.getSelectedItem();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spasswoed = passwordText.getText();
            String smeter = meterText.getText();
            try{
                database c = new database();
                String query = null;
                query = "insert into Signup value('"+smeter+"', '"+susername+"', '"+sname+"', '"+spasswoed+"', '"+sloginAs+"')";

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null,"Account Created");
                setVisible(false);
                new Login();

            }catch (Exception E){
                E.getStackTrace();
            }
        }else  if (e.getSource() == back){
            setVisible(false);
            new Login();
        }

    }
    public static void main(String[] args) {
        new Signup();
    }
}
