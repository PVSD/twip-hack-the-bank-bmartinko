package com.company;
import java.util.*;
import javax.script.*;
import java.io.*;
/**
 * Created by dpennebacker on 2/13/17.
 */
public class bankAccount implements Comparable {

    public bankAccount(String nm, double amt) {
        name = nm;
        balance = amt;
    }

    public int compareTo(Object otherObject) {
        bankAccount otherAccount = (bankAccount) otherObject;
        int retValue;
        if (balance < otherAccount.balance) {
            retValue = -1;
        } else {
            if (balance > otherAccount.balance) {
                retValue = 1;
            } else {
                retValue = 0;
            }
        }
        return retValue;
    }
    public static boolean log(String z, double x){
        try{
            File logText = new File("log.txt");
            FileOutputStream fd = new FileOutputStream(logText);
            OutputStreamWriter idk = new OutputStreamWriter(fd);
            Writer k = new BufferedWriter(idk);
            k.write(z + " deposited $" + x);
        }catch (IOException q){
            System.out.println("Error writing to the text file, log.txt");
        }
        return true;
    }

    public void deposit(double dp) {
        balance = balance + dp;
    }

    public void withdraw(double wd) {
        balance = balance - wd;
    }

    public String name;
    public double balance;

}
