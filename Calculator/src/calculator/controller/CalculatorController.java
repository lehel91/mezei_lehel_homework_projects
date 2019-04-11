package calculator.controller;

import calculator.view.CalculatorView;
import calculator.model.CalculatorModel;
import calculator.model.Operand;

public class CalculatorController {

    CalculatorModel calculatorModel;
    CalculatorView calculatorView;

    public CalculatorController() {
        calculatorModel = new CalculatorModel();
        calculatorView = new CalculatorView(this);
    }

    public void handleNumberButtonClick(String nextDigit) {
        if (calculatorView.getScreen().getText().equals("" + 0)) {
            calculatorView.getScreen().setText(nextDigit);
        } else {
            calculatorView.getScreen().setText(calculatorView.getScreen().getText() + nextDigit);
        }
    }

    public void handlePlusButtonClick(Integer number) {
        handleCurrentOperation(number);
        calculatorModel.setOperand(Operand.ADDITION);
    }

    public void handleMinusButtonClick(Integer number) {
        handleCurrentOperation(number);
        calculatorModel.setOperand(Operand.EXTRACTION);
    }

    public void handleMultiplyButtonClick(Integer number) {
        handleCurrentOperation(number);
        calculatorModel.setOperand(Operand.MULTIPLICATION);
    }

    public void handleDivideButtonClick(Integer number) {
        handleCurrentOperation(number);
        calculatorModel.setOperand(Operand.DIVISION);
    }

    public void handleEqualsButtonClick(Integer number) {
        switch (calculatorModel.getOperand()) {
            case ADDITION:
                calculatorModel.setNumber(calculatorModel.getNumber() + number);
                calculatorView.getScreen().setText("" + calculatorModel.getNumber());
                calculatorModel.setOperand(Operand.ADDITION);
                break;
            case EXTRACTION:
                calculatorModel.setNumber(calculatorModel.getNumber() - number);
                calculatorView.getScreen().setText("" + calculatorModel.getNumber());
                calculatorModel.setOperand(Operand.ADDITION);
                break;
            case MULTIPLICATION:
                calculatorModel.setNumber(calculatorModel.getNumber() * number);
                calculatorView.getScreen().setText("" + calculatorModel.getNumber());
                calculatorModel.setOperand(Operand.ADDITION);
                break;
            case DIVISION:
                try {
                    calculatorModel.setNumber(calculatorModel.getNumber() / number);
                    calculatorView.getScreen().setText("" + calculatorModel.getNumber());
                    calculatorModel.setOperand(Operand.ADDITION);
                    break;
                } catch (ArithmeticException ae) {
                    calculatorView.printExceptionMessage();
                }
        }
    }

    public void handleCurrentOperation(Integer number) {
        switch (calculatorModel.getOperand()) {
            case ADDITION:
                calculatorModel.setNumber(calculatorModel.getNumber() + number);
                calculatorView.getScreen().setText("" + 0);
                break;
            case EXTRACTION:
                calculatorModel.setNumber(calculatorModel.getNumber() - number);
                calculatorView.getScreen().setText("" + 0);
                break;
            case MULTIPLICATION:
                calculatorModel.setNumber(calculatorModel.getNumber() * number);
                calculatorView.getScreen().setText("" + 0);
                break;
            case DIVISION:
                try {
                    calculatorModel.setNumber(calculatorModel.getNumber() / number);
                    calculatorView.getScreen().setText("" + 0);
                    break;
                } catch (ArithmeticException ae) {
                    calculatorView.printExceptionMessage();
                }
        }
    }

    public void handleClearButtonClick() {
        calculatorModel.setNumber(0);
        calculatorView.getScreen().setText("" + 0);
        calculatorModel.setOperand(Operand.ADDITION);
    }
}
