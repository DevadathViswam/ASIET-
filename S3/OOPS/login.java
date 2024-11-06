import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Login implements ActionListener {
    JLabel l1, l2, welcomeLabel; 
    JTextField t1; 
    JPasswordField t2; 
    JButton b1, b2;

    Login() {
        JFrame f = new JFrame("Login");

        l1 = new JLabel("Username: ");
        t1 = new JTextField(20);
        l2 = new JLabel("Password: ");
        t2 = new JPasswordField(20);
        b1 = new RoundedButton("Submit");
        b2 = new RoundedButton("Clear");
        welcomeLabel = new JLabel("");

        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 2, 10, 10));
        p.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        p.add(l1);
        p.add(t1);
        p.add(l2);
        p.add(t2);
        p.add(b1);
        p.add(b2);
        p.add(welcomeLabel);

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.add(p);
        f.setSize(350, 250);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        if (s.equals("Submit")) {
            String username = t1.getText();
            char[] password = t2.getPassword();

            if (username.equals("admin") && new String(password).equals("password123")) {
                welcomeLabel.setText("Welcome, " + username + "!");
                welcomeLabel.setForeground(new Color(0, 128, 0));  // Green for success
            } else {
                welcomeLabel.setText("Invalid username or password.");
                welcomeLabel.setForeground(Color.RED);  // Red for error
            }

            t1.setText("");
            t2.setText("");
        } else if (s.equals("Clear")) {
            t1.setText("");
            t2.setText("");
            welcomeLabel.setText("");
        }
    }

    public static void main(String[] args) {
        new Login(); 
    }
}

class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorder(BorderFactory.createLineBorder(new Color(0, 128, 0), 2));  // Border color
        setBackground(new Color(222, 184, 135));  // Background color
        setForeground(Color.WHITE);  // Text color
        setFont(new Font("Arial", Font.BOLD, 14));  // Font style
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(getBackground().darker());  // Darken when pressed
        } else {
            g.setColor(getBackground());
        }
        
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);  // Draw the rounded rectangle
        super.paintComponent(g);  // Paint the text and icon on top
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());  // Set border color
        g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 30, 30);  // Draw rounded border
    }
}


