import DBConnect.dbConnect;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class login {
    private JPanel Login;
    private JTextField userField;
    private JPasswordField pwField;
    private JButton exitButton;
    private JButton loginButton;

    public static JFrame LoginJF = new JFrame("Login Box");

    public login() {
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String PW = String.valueOf(pwField.getPassword());
               JOptionPane.showMessageDialog(null,username+" System not reply yet");
            }
        });
    }

    public static void main(String[] args){
        LoginJF.setContentPane(new login().Login);
        LoginJF.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LoginJF.pack();
        LoginJF.setVisible(true);

    }
    private void loginCheck(String frUserName, String frPW){
        String inUsername = null;
        String inPW = null;
        dbConnect dbcon = new dbConnect();
        Statement stml = null;
        try{
            String query = "Select * from userDetails where Username='"+frUserName+"'";
            stml = dbcon.Conn2DB();
            ResultSet RS = stml.executeQuery(query);
            RS.first();
            inUsername = frUserName;
            inPW = RS.getString("Password");
        }
        catch(SQLException e){
            e.printStackTrace();
        }



        if(frUserName.equals(inUsername)&&frPW.equals(inPW))
            JOptionPane.showMessageDialog(null,"Username and Password correct");
        else
            JOptionPane.showMessageDialog(null,"incorrect");
    }
}
