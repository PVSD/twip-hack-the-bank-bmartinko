package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
public class Main {

    public static void main(String[] args) throws IOException, NullPointerException {

        NumberFormat fmt = NumberFormat.getNumberInstance();
        fmt.setMinimumFractionDigits(2);
        fmt.setMaximumFractionDigits(2);
        String name;
        ArrayList aryLst = new ArrayList();
        ListIterator iter = aryLst.listIterator();
        FileWriter ab = new FileWriter("log.txt");
        PrintWriter bc = new PrintWriter(ab);
        ArrayList log = new ArrayList();
        bankAccount[] aa = new bankAccount[10];
        bankAccount theif = new bankAccount("Pennebacker", 0);
        int it = 0;
        do {
            Scanner kbReader = new Scanner(System.in);
            System.out
                    .print("Please enter the name to whom the account belongs. (\"Exit\" to abort) ");
            name = kbReader.nextLine();

            if (name.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye");

            }else if (name.equalsIgnoreCase("debug")){
                System.out.println("Please select 1 for Deposits. Press 2 for Account Balances.");
                Scanner choice = new Scanner(System.in);
                int decision = choice.nextInt();
                if(decision == 1){
                    for(int ds = 0; ds < log.size(); ds++){
                        bc.print(log.get(ds));
                    }ab.close();
                    bc.close();
                }else if (decision == 2){
                    bankAccount cd = (bankAccount) iter.previous();
                    double maxBalance = cd.balance; // set last account as the winner so far
                    String maxName = cd.name;
                    double secondBalance = cd.balance ;
                    String secondName = cd.name;
                    double thirdBalance = cd.balance;
                    String thirdName = cd.name;
                    double fourthBalance = cd.balance;
                    String fourthName = cd.name;
                    double lastBalance = cd.balance;
                    String lastName = cd.name;

                    while (iter.hasPrevious()) {
                        cd = (bankAccount) iter.previous();
                        if (cd.balance > maxBalance) {
                            // We have a new winner, chicken dinner
                            lastBalance = fourthBalance;
                            lastName = fourthName;
                            fourthBalance = thirdBalance;
                            fourthName = thirdName;
                            thirdBalance = secondBalance;
                            thirdName = secondName;
                            secondBalance = maxBalance;
                            secondName = maxName;
                            maxBalance = cd.balance;
                            maxName = cd.name;

                        }
                    }
                    bc.print(maxName + ": $" + maxBalance + "\n"
                            + secondName + ": $" + secondBalance + "\n"
                            + thirdName + ": $" + thirdName + "\n"
                            + fourthName + ": $" + fourthBalance +"\n"
                            + lastName + ": $" + lastName);
                    ab.close();
                    bc.close();

                }
            }else if (name.equalsIgnoreCase("withdraw")){
                System.out.println("What's your name?");
                Scanner namer = new Scanner(System.in);
                String nameB = namer.nextLine();
                System.out.print("Please enter the amount of the withdraw. ");
                Scanner withdrawAmount = new Scanner(System.in);
                double amountB = withdrawAmount.nextDouble();
                bankAccount anotherAccount = new bankAccount(nameB, -amountB);
                String y = nameB + " withdrew $" + amountB + "\n";
                log.add(y);
                iter.add(anotherAccount);
                aa[it] = anotherAccount;
                it++;
            }
            else {
                System.out.print("Please enter the amount of the deposit. ");
                double amount = kbReader.nextDouble();
                System.out.println(" "); // gives an eye pleasing blank line
                // between accounts
                bankAccount theAccount = new bankAccount(name, amount);
                String z = name + " deposited $" + amount +"\n";
                log.add(z);
                aa[it] = theAccount;
                iter.add(theAccount);
                it++;
            }
        } while (!name.equalsIgnoreCase("EXIT"));

        // Search aryLst and print out the name and amount of the largest bank
        // account


        bankAccount ba = (bankAccount) iter.previous();
        double maxBalance = ba.balance; // set last account as the winner so far
        String maxName = ba.name;
        while (iter.hasPrevious()) {
            ba = (bankAccount) iter.previous();
            if (ba.balance > maxBalance) {
                // We have a new winner, chicken dinner
                maxBalance = ba.balance;
                maxName = ba.name;
            }
        }
        System.out.println("Was there a thief? ");
        Scanner finalChoice = new Scanner(System.in);
        String finallyy = finalChoice.nextLine();
        if(finallyy.equalsIgnoreCase("yes")|| finallyy.equalsIgnoreCase("yeah")){
            maxBalance += theif.balance;
            maxName = theif.name;
        }
        System.out.println(" ");
        System.out.println("The account with the largest balance belongs to "
                + maxName + ".");
        System.out.println("The amount is $" + fmt.format(maxBalance) + ".");

    }
}
