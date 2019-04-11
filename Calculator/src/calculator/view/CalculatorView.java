package calculator.view;

import calculator.controller.CalculatorController;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculatorView extends JFrame {

    private JTextField screen;
    private JPanel panel;
    private JButton plusButton;
    private JButton minusButton;
    private JButton multiplyButton;
    private JButton divisionButton;
    private JButton equalsButton;
    private JButton clearButton;
    private JButton[] numberButtons;
    

    private CalculatorController calculatorController;

    public CalculatorView(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
        initialize();

        ActionListener plusAction = p -> {
            calculatorController.handlePlusButtonClick(Integer.valueOf(screen.getText()));
        };
        plusButton.addActionListener(plusAction);

        ActionListener minusAction = m -> {
            calculatorController.handleMinusButtonClick(Integer.valueOf(screen.getText()));
        };
        minusButton.addActionListener(minusAction);

        ActionListener multiplyAction = m -> {
            calculatorController.handleMultiplyButtonClick(Integer.valueOf(screen.getText()));
        };
        multiplyButton.addActionListener(multiplyAction);

        ActionListener divisionAction = d -> {
            calculatorController.handleDivideButtonClick(Integer.valueOf(screen.getText()));
        };
        divisionButton.addActionListener(divisionAction);

        ActionListener numberAction = n -> {
            calculatorController.handleNumberButtonClick(((JButton) (n.getSource())).getText());
        };
        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i].addActionListener(numberAction);
        }

        ActionListener equalsAction = e -> {
            calculatorController.handleEqualsButtonClick(Integer.valueOf(screen.getText()));
        };
        equalsButton.addActionListener(equalsAction);

        ActionListener clearAction = c -> {
            calculatorController.handleClearButtonClick();
        };
        clearButton.addActionListener(clearAction);
    }

    public JTextField getScreen() {
        return screen;
    }

    private void initialize() {
        setUpWindow();
        setUpCalculatorScreen();
        setupPlusButton();
        setupMinusButton();
        setupMultiplyButton();
        setupDivisionButton();
        setupEqualsButton();
        setupClearButton();
        setupNumberButtons();

        showWindow();

    }

    public void showWindow() {
        //this.pack();
        this.setVisible(true);
    }

    private void setUpWindow() {
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");

        setLayout(new GridLayout(1, 1));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        GridBagLayout gbl = new GridBagLayout();
        panel.setLayout(gbl);
    }

    private void setUpCalculatorScreen() {
        this.screen = new JTextField("0");
        Font f = new Font("Lucida Console", Font.BOLD, 20);
        this.screen.setHorizontalAlignment(JTextField.RIGHT);
        this.screen.setFont(f);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 5;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(screen, gbc);
    }

    private void setupPlusButton() {
        GridBagConstraints gbc;
        this.plusButton = new JButton("+");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(plusButton, gbc);
    }

    private void setupMinusButton() {
        GridBagConstraints gbc;
        this.minusButton = new JButton("-");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(minusButton, gbc);
    }

    private void setupMultiplyButton() {
        GridBagConstraints gbc;
        this.multiplyButton = new JButton("*");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 3;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(multiplyButton, gbc);
    }

    private void setupDivisionButton() {
        GridBagConstraints gbc;
        this.divisionButton = new JButton("/");
        gbc = new GridBagConstraints();
        gbc.gridx = 3;
        gbc.gridy = 4;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(divisionButton, gbc);
    }

    private void setupEqualsButton() {
        GridBagConstraints gbc;
        this.equalsButton = new JButton("=");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 1;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(equalsButton, gbc);
    }

    private void setupClearButton() {
        GridBagConstraints gbc;
        this.clearButton = new JButton("C");
        gbc = new GridBagConstraints();
        gbc.gridx = 4;
        gbc.gridy = 2;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;
        panel.add(clearButton, gbc);
    }

    private void setupNumberButtons() {
        this.numberButtons = new JButton[10];
        GridBagConstraints gbc;
        gbc = new GridBagConstraints();

        for (int i = 0; i < 10; i++) {
            this.numberButtons[i] = new JButton("" + i);
            gbc.gridx = i % 3;
            gbc.gridy = i / 3 + 1;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;
            panel.add(numberButtons[i], gbc);
        }
    }

    public void printExceptionMessage() {
        JFrame exceptionMessage = new JFrame();
        exceptionMessage.setSize(200, 100);
        exceptionMessage.setLocationRelativeTo(null);
        exceptionMessage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exceptionMessage.setTitle("Arithmetic exception");
        JTextField message = new JTextField("Division by 0");
        exceptionMessage.add(message);
        exceptionMessage.setVisible(true);
    }
}
