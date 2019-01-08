package com.amelielaurent38.digital.calculatrice.models;

/**
 *
 */

public class Operation {

    private double Number1, Number2;

    public Operation(double Number1, double Number2) {
        this.Number1 = Number1;
        this.Number2 = Number2;
    }

    public double getNumber1() {
        return Number1;
    }

    public void setNumber1(double number1) {
        this.Number1 = number1;
    }

    public double getNumber2() {
        return Number2;
    }

    public void setNumber2(double number2) {
        this.Number2 = number2;
    }

    public double Addition() {
        return this.Number1 + this.Number2;
    }
    public double Soustraction() {
        return this.Number1 - this.Number2;
    }
    public double Division() {
        return this.Number1 / this.Number2;
    }
    public double Multiplication() {
        return this.Number1 * this.Number2;
    }
    public double Modulo() {
        return this.Number1 % this.Number2;
    }

}
