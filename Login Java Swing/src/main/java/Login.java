import javax.swing.*;
import com.formdev.flatlaf.FlatDarculaLaf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JPanel panelPrincipal;
    private JLabel textLogin;
    private JTextField textFieldUser;
    private JButton buttonEnviar;
    private JLabel labelUser;
    private JLabel labelPassword;
    private JPanel JPanelTextLogin;
    private JPasswordField passwordField1;


    public Login() {
        inicializarLogin();
        buttonEnviar.addActionListener(e -> validar()); {

        };
    }

    private void inicializarLogin(){
        setContentPane(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,400);
        setLocationRelativeTo(null);//centra la ventana
    }

    private void validar(){
        String usuario = textFieldUser.getText();
        String password = passwordField1.getText();
        if(usuario.equals("admin") && password.equals("admin")){
            JOptionPane.showMessageDialog(this, "Bienvenido");
        } else if (!usuario.equals("admin") && !password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Usuario y Contraseña incorrectos");
        } else if (usuario.equals("admin") && !password.equals("admin")){
            JOptionPane.showMessageDialog(this, "Contraseña incorrecta");
        } else if (!usuario.equals("admin") && password.equals("admin")) {
            JOptionPane.showMessageDialog(this, "Usuario incorrecta");
        }
    }

    public static void main(String[] args) {
        FlatDarculaLaf.setup(); // Cambia el Look and feel (fondo de la ventana).
        Login forma = new Login();
        forma.setVisible(true);
    }

}