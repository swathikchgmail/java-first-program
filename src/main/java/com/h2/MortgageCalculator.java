package com.h2;

import java.text.DecimalFormat;

public class MortgageCalculator {

    private long loanAmount;
    private float annualRate;
    private static double monthlyPayment;
    private int termInYears;

    public MortgageCalculator(long loanAmount,  int termInYears, float annualRate) {
        this.loanAmount = loanAmount;
        this.annualRate = annualRate;
        this.termInYears = termInYears;
    }

    private int getNumberOfPayments() {
        return termInYears * 12;
    }

    private float getMonthlyInterestRate() {
        float interestRate = annualRate/100;
        return interestRate/12;
    }

    public void calculateMonthlyPayment() {
        long p = loanAmount;
        float r = getMonthlyInterestRate();
        int n = getNumberOfPayments();
        double m = p * (((r * Math.pow(1 + r, n))) / ((Math.pow((1 + r), n)) - 1));;
        this.monthlyPayment = m;
    }

    @Override
    public String toString() {
//        return "MortgageCalculator{" +
//                "loanAmount=" + loanAmount +
//                ", annualRate=" + annualRate +
//                ", monthlyPayment=" + monthlyPayment +
//                ", termInYears=" + termInYears +
//                '}';

        DecimalFormat df = new DecimalFormat("####0.00");

        return "monthlyPayment: " + df.format(monthlyPayment);

    }

    public static void main(String[] args) {
        long loanAmount = Long.parseLong(args[0]);
        int termInYears = Integer.parseInt(args[1]);
        float annualRate = Float.parseFloat(args[2]);

        MortgageCalculator calculator = new MortgageCalculator(loanAmount, termInYears, annualRate);
        calculator.calculateMonthlyPayment();
        System.out.println(calculator.toString());
    }
}
