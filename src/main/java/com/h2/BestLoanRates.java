package com.h2;

import java.util.Map;
import java.util.Scanner;

public class BestLoanRates {

    public static final Map<Integer, Float> bestRates;

    static {
        bestRates = Map.of(1, 5.5f, 2, 3.45f, 3, 2.67f);
    }

    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter your name" );
        String name = scanner.next();
        System.out.println("Hello " + name);

        System.out.println("Enter the loan term (in years)");
        int loanYears = scanner.nextInt();
        float bestRate = getRates(loanYears);
        if(bestRate != 0.0f) {
            System.out.println("Best available rate for term : " + loanYears + " years "
                    + "and best rante is " + bestRate);
        } else {
            System.out.println("No available rates are available");
        }

    }
    public static float getRates(int loanTermInYears) {
        if(bestRates.containsKey(loanTermInYears))
            return bestRates.get(loanTermInYears);
        else
            return 0.0f;
    }
}
