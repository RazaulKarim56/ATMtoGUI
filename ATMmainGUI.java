import javax.swing.*;
import java.awt.*;

public class ATMmachineGUI {

    private static ATMUser user = new ATMUser("1878862488", "018106", 15000.00);
    private static int attempts = 0;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Java ATM");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel pinLabel = new JLabel("Enter PIN:");
        JPasswordField pinField = new JPasswordField(10);
        JButton loginButton = new JButton("Login");

        JPanel panel = new JPanel();
        panel.add(pinLabel);
        panel.add(pinField);
        panel.add(loginButton);
        frame.add(panel);

        loginButton.addActionListener(e -> {
            String enteredPin = new String(pinField.getPassword());

            if (user.authenticate(enteredPin)) {
                showMenu();
                frame.dispose();
            } else {
                attempts++;
                JOptionPane.showMessageDialog(frame, "Incorrect PIN. Attempts: " + attempts);
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void showMenu() {
        JFrame menuFrame = new JFrame("ATM Menu");
        menuFrame.setSize(350, 250);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton balanceBtn = new JButton("Check Balance");
        JButton depositBtn = new JButton("Deposit");
        JButton withdrawBtn = new JButton("Withdraw");
        JButton exitBtn = new JButton("Exit");

        balanceBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Balance: " + user.getBalance());
        });

        depositBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(menuFrame, "Enter amount to deposit:");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    user.deposit(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(menuFrame, "Invalid amount.");
                }
            }
        });

        withdrawBtn.addActionListener(e -> {
            String input = JOptionPane.showInputDialog(menuFrame, "Enter amount to withdraw:");
            if (input != null) {
                try {
                    double amount = Double.parseDouble(input);
                    user.withdraw(amount);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(menuFrame, "Invalid amount.");
                }
            }
        });

        exitBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(menuFrame, "Thank you for using Java ATM!");
            menuFrame.dispose();
        });

        JPanel menuPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        menuPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));
        menuPanel.add(balanceBtn);
        menuPanel.add(depositBtn);
        menuPanel.add(withdrawBtn);
        menuPanel.add(exitBtn);

        menuFrame.add(menuPanel);
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
    }
}
