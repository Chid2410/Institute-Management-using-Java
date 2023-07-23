import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class LoginForm extends JFrame implements ActionListener {
    JButton submitButton;
    JTextField usernameField;
    JPasswordField passwordField;

    LoginForm() {
        JLabel headingLabel = new JLabel("Institute Management");
        headingLabel.setFont(new Font("Arial", Font.BOLD, 24));
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        submitButton = new JButton("Login");

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(headingLabel);
        panel.add(new JLabel()); 
        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);

        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panel, BorderLayout.CENTER);
        container.add(buttonPanel, BorderLayout.SOUTH);

        submitButton.addActionListener(this);

        setTitle("Institute Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); 
        setLocationRelativeTo(null); 
    }

    public void actionPerformed(ActionEvent ae) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        
        if (username.equals("admin") && password.equals("password")) {

              
            InstituteManagement page = new InstituteManagement();  
              
             
            page.setVisible(true);  
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginForm form = new LoginForm();
            form.setVisible(true);
        });
    }
}
