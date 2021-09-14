package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 12 Solution
 *  Copyright 2021 Tyler Coleman
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the principal: ");
        String principalS = in.nextLine();
        System.out.println("Enter the rate of interest percentage: ");
        String interestPercentS = in.nextLine();
        System.out.println("Enter the number of years: ");
        String yearsS = in.nextLine();
        double principal = Double.parseDouble(principalS);
        double interestPercent = Double.parseDouble(interestPercentS);
        double years = Double.parseDouble(yearsS);
        double interest = interestPercent / 100;
        String yearsQuote;
        for (int i = 1; i <= years; i++) {
            double total = principal * (1 + interest * i);
            BigDecimal result = new BigDecimal(total).setScale(3, RoundingMode.HALF_UP);
            NumberFormat usdCostFormat = NumberFormat.getCurrencyInstance(Locale.US);
            if (i == 1) {
                yearsQuote = "year";
            }
            else {
                yearsQuote = "years";
            }
            System.out.printf("After %d %s at %.02f%%, the investment will be worth %s.\n", i, yearsQuote, interestPercent, usdCostFormat.format(result.doubleValue()));
        }
    }
}
