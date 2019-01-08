package com.amelielaurent38.digital.calculatrice.models;

/**
 *
 */

public class Operation {

    private double number1, number2;
    private OperationType operationType;

    public Operation(double Number1, double Number2, OperationType operationType) {
        this.number1 = Number1;
        this.number2 = Number2;
        this.operationType = operationType;
    }

    public Double getResult() {
        switch (operationType) {
            case ADDTION:
                return doAddition();
            case SOUSTRACTION:
                return doSoustraction();
            case DIVISION:
                return doDivision();
            case MUTIPLICATION:
                return doMultiplication();
            case PERCENT:
                return doPercent();
            default:
                return 0.0;
        }
    }

    public double getNumber1() {
        return number1;
    }

    public void setNumber1(double number1) {
        this.number1 = number1;
    }

    public double getNumber2() {
        return number2;
    }

    public void setNumber2(double number2) {
        this.number2 = number2;
    }

    private double doAddition() {
        return this.number1 + this.number2;
    }

    private double doSoustraction() {
        return this.number1 - this.number2;
    }

    private double doDivision() {
        return this.number1 / this.number2;
    }

    private double doMultiplication() {
        return this.number1 * this.number2;
    }

    private double doPercent() {
        return this.number1 / 100;
    }

}
