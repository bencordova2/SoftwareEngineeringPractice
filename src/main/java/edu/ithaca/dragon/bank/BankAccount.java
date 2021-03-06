package edu.ithaca.dragon.bank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BankAccount {

    private String email;
    private double balance;

    /**
     * @throws IllegalArgumentException if email is invalid
     */
    public BankAccount(String email, double startingBalance) {
        if (isEmailValid(email)) {
            this.email = email;
            this.balance = startingBalance;
        } else {
            throw new IllegalArgumentException("Email address: " + email + " is invalid, cannot create account");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }

    /**
     * @post reduces the balance by amount if amount is non-negative and smaller than balance
     */
    public void withdraw(double amount) {
        balance -= amount;

    }


    public static boolean isEmailValid(String email) {
        if (email.indexOf('@') == -1 || email.indexOf('@') == 0) {
            return false;
        }
        if (email.indexOf('.') == -1) {
            return false;
        }

        int count = 0;

        for (int i = email.indexOf('@'); i < email.length(); i++) {
            if (email.charAt(i) == ('.')) {
                count++;
            }
        }
        if (count != 1) {
            return false;
        }

        for (int i = 0; i < email.indexOf('@'); i++) {
            if (email.charAt(i) == ('.')) {
                if (email.charAt(i + 1) == ('.')) {
                    return false;
                }
            }
        }

        int count3 = 0;
        for (int j = email.indexOf('.'); j < email.length(); j++) {
            if (email.charAt(j) != (' ')) {
                count3++;
            }
        }


        if (count3 <= 1) {
            return false;
        }


        int count2=0;
        for(int i=0; i<email.length(); i++){
            if(email.indexOf('-') ==  email.indexOf('@')-1){
                count2++;
            }
        }

        if(count2 != 0){
            return false;
        }


        int count4 =0;
        int indx = email.lastIndexOf('.');

        while(indx < email.length()) {
            count4++;
            indx++;
        }
        if(count4 <=1){
            return false;
        }







        else {
            return true;
        }
    }

}