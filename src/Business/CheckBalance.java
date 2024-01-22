package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class CheckBalance {
    /***
     Receives a non-empty array of n integers without any zeroes and checks whether it
     includes the same number of positive and negative values.
     ***/
    public CheckBalance() {
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers = utilities.performValuesAsking(arrayOfIntegers, numValues, "noZero");
        boolean balanced = checkBalance(arrayOfIntegers, 0, 0, 0);
        if(balanced){
            System.out.println("\nThe array is balanced\n");
        }else{
            System.out.println("\nThe array is not balanced\n");
        }
    }

    private boolean checkBalance(ArrayList<Integer> arrayOfIntegers, int position, int acumPositive, int acumNegative) {
        if(position<arrayOfIntegers.size()){
            if(arrayOfIntegers.get(position)>0){
                acumPositive+=1;
            }else{
                acumNegative+=1;
            }
            return checkBalance(arrayOfIntegers,position+1,acumPositive,acumNegative);
        }
        return acumNegative == acumPositive;
    }
}
