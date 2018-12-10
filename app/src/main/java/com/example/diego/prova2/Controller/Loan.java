package com.example.diego.prova2.Controller;

import android.util.Log;

import com.example.diego.prova2.Model.Installment;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Loan {

    public List <Installment> listInstallment;
    private double amount, payment, rateInterest;
    private int loanTime;

    public Loan(double amount, double rateInterest, int loanTime ){

        this.amount = amount;
        this.rateInterest = rateInterest;
        this.loanTime = loanTime;
        this.listInstallment = new ArrayList<Installment>();



    }

    public void firstInstallment( double amount, double rateInterest, int loanTime){
        this.listInstallment.add(new Installment(0,0,0, amount));
    }

    public void othersInstallment ( double amount, double rateInterest, int loanTime){
        double rateInterest2 = 1 + this.rateInterest;
        double turn1 = (Math.pow(rateInterest2,loanTime)) * rateInterest;
        double turn2 = (Math.pow(rateInterest2, loanTime)) -1;
        this.payment = payment;
    }

    public void logList(){
        for (int i =0; i <= this.listInstallment.size() -1; i++){
            logInstallment(this.listInstallment.get(i));
        }
    }

    public void logInstallment(Installment in){
        NumberFormat format = new DecimalFormat("#0.00");
        Log.i("Price", "--------------- -----------" + this.payment);
        Log.i("Installment n :", "" + in.getOrdInst());
        Log.i("Installment j :", "" + format.format(in.getInterest()));
        Log.i("Installment a :", "" + format.format(in.getAmorization()));
        Log.i("Installment sdv :", "" + format.format(in.getValue()));
    }

    public ArrayList<Installment> getListInstallments() {
        return(ArrayList<Installment>) this.listInstallment;
    }

    public void setListInstallment(List<Installment> listInstallment) {
        this.listInstallment = listInstallment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getRateInterest() {
        return rateInterest;
    }

    public void setRateInterest(double rateInterest) {
        this.rateInterest = rateInterest;
    }

    public int getLoanTime() {
        return loanTime;
    }

    public void setLoanTime(int loanTime) {
        this.loanTime = loanTime;
    }
}