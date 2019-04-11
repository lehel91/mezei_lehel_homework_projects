package calculator.model;

public class CalculatorModel {

    private int number;
    private Operand operand;

    public CalculatorModel() {
        this.number = 0;
        this.operand = Operand.ADDITION;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Operand getOperand() {
        return operand;
    }

    public void setOperand(Operand operand) {
        this.operand = operand;
    }

}
