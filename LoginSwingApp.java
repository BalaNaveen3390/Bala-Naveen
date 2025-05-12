package mouseevents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class LoginSwingApp extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel messageLabel;

    public LoginSwingApp() {
        // Set up the frame
        setTitle("Login Page Model");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null); // Center the window
        setLayout(new GridLayout(4, 2, 10, 10));

        // Initialize components
        JLabel usernameLabel = new JLabel("Username:");
        usernameField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(20);

        JButton loginButton = new JButton("Login");
        messageLabel = new JLabel("");

        // Add components to the frame
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(new JLabel("")); // Empty label for spacing
        add(loginButton);
        add(new JLabel("")); // Empty label for spacing
        add(messageLabel);

        // Add action listener to the login button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Simple validation (for demo purposes)
                if (username.isEmpty() || password.isEmpty()) {
                    messageLabel.setText("Please fill in all fields");
                } else if (username.equals("Bala Naveen") && password.equals("naveen123")) {
                    messageLabel.setText("Login successful!");
                    // Open a web page in the default browser
                    try {
                        URI uri = new URI("https://www.example.com"); // Replace with desired URL
                        Desktop.getDesktop().browse(uri);
                    } catch (Exception ex) {
                        messageLabel.setText("Error opening web page: " + ex.getMessage());
                    }
                } else {
                    messageLabel.setText("Invalid username or password");
                }
            }
        });
    }

    public static void main(String[] args) {
        // Run the application.ConcurrentModificationException
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LoginSwingApp().setVisible(true);
            }
        });
    }
}