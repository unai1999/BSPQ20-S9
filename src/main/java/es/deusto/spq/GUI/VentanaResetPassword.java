package es.deusto.spq.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import es.deusto.spq.client.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaResetPassword extends JFrame implements ActionListener {

    JPanel panel;
    JLabel passwprd_label1, password_label2, message;
   
    JPasswordField password1_text, password2_text;
    JButton submit, cancel;

    enum Resp {
        MISSMATCH,
        LENGTH,
        VALID
    }

    VentanaResetPassword() {
        
        // User Label
        passwprd_label1 = new JLabel();
        passwprd_label1.setText("New password :");
        password1_text = new JPasswordField();
        
        // Password

        password_label2 = new JLabel();
        password_label2.setText("Repeat password :");
        password2_text = new JPasswordField();

        // Submit

        submit = new JButton("SUBMIT");

        panel = new JPanel(new GridLayout(3, 1));

        panel.add(passwprd_label1);
        panel.add(password1_text);
        panel.add(password_label2);
        panel.add(password2_text);

        message = new JLabel();
        panel.add(message);
        panel.add(submit);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Adding the listeners to components..
        submit.addActionListener(this);
        add(panel, BorderLayout.CENTER);
        setTitle("Password reset!");
        setSize(400, 150);
        setVisible(true);

    }

    public static void main(String[] args) {
        new VentanaResetPassword();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String password1 = new String(password1_text.getPassword());
        String password2 = new String(password2_text.getPassword());
        Resp r = validate(password1, password2);
        message.setOpaque(true);
        switch(r) {
            case MISSMATCH:
            message.setText("Password don't match");
            message.setForeground(Color.RED);
           
              break;
            case LENGTH:
            message.setText("Password must be at least 4 characters");
            message.setForeground(Color.RED);
              break;
            case VALID:
            message.setText("Password reset :)");
            message.setForeground(Color.GREEN);
            Response response = Controller.getInstance().resetPassword("user", password1);
            this.dispose();
            if(response.getStatus() == Status.OK.getStatusCode()){
                JOptionPane.showMessageDialog(null, "Password Reset", "Congratulations!", JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Error reseting password", "oops", JOptionPane.ERROR_MESSAGE);
            }
              break;
          }
        
        
    }

    public Resp validate(String p1, String p2){

        Resp r = Resp.VALID;
        if (p1.equals(p2)) {
            if(p1.length() < 4){
                r = Resp.LENGTH;
                return r;
            }else{
                return r;
            }           
        } else {
            r = Resp.MISSMATCH;
            return r;
        }
    }

}