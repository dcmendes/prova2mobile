package com.example.diego.prova2.Model;

public class Installment {

    private int nInst;
    private double value;
    private double interest;
    private double amorization;
    


    public Installment(int nInst, double value, double interest, double amorization) {
        this.nInst = nInst;
        this.value = value;
        this.interest = interest;
        this.amorization = amorization;
    }

    public int getnInst() {
        return nInst;
    }

    public void setnInst(int nInst) {
        this.nInst = nInst;
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
