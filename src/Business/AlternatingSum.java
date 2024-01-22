package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class AlternatingSum {

    /***
     * Receives a non-empty array of n reals and returns the result of adding
     * together all values found in positions with an odd index.
     */
    public AlternatingSum(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,numValues,"all");
        int oddSum = getOddSum(arrayOfIntegers,0,0);
        System.out.println("\nThe sum of the odd indexes amounts to: "+oddSum+"\n");
    }

    private int getOddSum(ArrayList<Integer> arrayOfIntegers, int position, int accumulated) {
        if(position<arrayOfIntegers.size()){
            if(position%2!=0){
                accumulated+=arrayOfIntegers.get(position);
            }
            return getOddSum(arrayOfIntegers,position+1,accumulated);
        }
        return accumulated;
    }
}
