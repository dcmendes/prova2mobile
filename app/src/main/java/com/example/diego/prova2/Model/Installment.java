package com.example.diego.prova2.Model;

public class Installment {

    private int ordInst;
    private double value;
    private double interest;
    private double amorization;
    


    public Installment(int nInst, double value, double interest, double amorization) {
        this.ordInst = nInst;
        this.value = value;
        this.interest = interest;
        this.amorization = amorization;
    }

    public int getOrdInst() {
        return ordInst;
    }

    public void setnInst(int nInst) {
        this.ordInst = nInst;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public double getAmorization() {
        return amorization;
    }

    public void setAmorization(double amorization) {
        this.amorization = amorization;
    }
}
