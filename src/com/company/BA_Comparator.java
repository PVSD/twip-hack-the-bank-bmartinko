package com.company;
import java.util.*;

public class BA_Comparator implements Comparator {
    public int compare(Object firstObject, Object secondObject){
        bankAccount ba1 = (bankAccount)firstObject;
        bankAccount ba2 = (bankAccount)secondObject;

        int retValue;
        if(ba1.balance < ba2.balance){
            retValue = -1;
        }else{
            if(ba1.balance>ba2.balance){
                retValue = 1;
            }else{
                retValue = 0;
            }
        }
        return retValue;
    }
}
