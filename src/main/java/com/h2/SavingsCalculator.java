package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    private static float[] credits;
    private static float[] debits;

    public SavingsCalculator(float[] credits1, float[] debits1) {
        this.credits = credits1;
        this.debits = debits1;
    }

    private static float sumOfCredits(float[] credits) {

        float sum = 0.0f;

        for (int i = 0; i < credits.length; i++) {
            sum += credits[i];
        }

        return sum;
    }

    private static float sumOfDebits(float[] debits) {

        float sum = 0.0f;

        for (int i = 0; i < debits.length; i++) {
            sum += debits[i];
        }
        return sum;
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();
        int remainingDays = totalDaysInMonth - date.getDayOfMonth();
        return remainingDays;
    }

    public static float calculate(float[] credits, float[] debts) {
        return sumOfDebits(debts) - sumOfCredits(credits);
    }

    public static void main(String[] args) {
      
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");

        float[] credits = new float[creditsAsString.length];
        float[] debits = new float[debitsAsString.length];

        for (int i = 0; i < creditsAsString.length; i++) {
            credits[i] = Float.parseFloat(creditsAsString[i]);
        }

        for (int i = 0; i < debitsAsString.length; i++) {
            debits[i] = Float.parseFloat(debitsAsString[i]);
        }

        float netSavings = calculate(credits, debits);

        System.out.println("Net Savings = " + netSavings + ", remaining days in month = " +
                remainingDaysInMonth(LocalDate.now()));
    }
}

//Net Savings = -5.0, remaining days in month = 11