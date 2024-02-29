package ATM_sys;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ATM extends JFrame {
    private user_acc account;

    private JTextField amountField;
    private JTextArea outputArea;

    public ATM(user_acc account) {
        this.account = account;

        setTitle("ATM Machine");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        topPanel.add(amountLabel);
        topPanel.add(amountField);
        add(topPanel, BorderLayout.NORTH);

        JPanel middlePanel = new JPanel();
        outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        middlePanel.add(scrollPane);
        add(middlePanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        JButton withdrawButton = new JButton("Withdraw");
        JButton depositButton = new JButton("Deposit");
        JButton checkBalanceButton = new JButton("Check Balance");

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                String message = account.withdraw(amount);
                outputArea.append(message + "\n");
            }
        });

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double amount = Double.parseDouble(amountField.getText());
                String message = account.deposit(amount);
                outputArea.append(message + "\n");
            }
        });

        checkBalanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append("Current balance: $" + account.getBalance() + "\n");
            }
        });

        bottomPanel.add(withdrawButton);
        bottomPanel.add(depositButton);
        bottomPanel.add(checkBalanceButton);
        add(bottomPanel, BorderLayout.SOUTH);
    }
}

public class Atm_machine {
    public static void main(String[] args) {
        user_acc account = new user_acc(1000);
        ATM atm = new ATM(account);
        atm.setVisible(true);
    }
}

