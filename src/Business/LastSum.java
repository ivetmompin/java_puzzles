package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class LastSum {

    /***
     * Receives a non-empty array of n integers and returns whether the last position
     * is the sum of all previous ones
     */

    public LastSum(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,numValues,"all");
        int valueToCheck = arrayOfIntegers.get(arrayOfIntegers.size()-1);
        if(isSum(numValues-2,arrayOfIntegers,valueToCheck,0)){
            System.out.println("The last value of the array is the sum of all previous values");
        }else{
            System.out.println("The last value of the array is not the sum of all previous values");
        }
    }

    public boolean isSum(int numValues, ArrayList<Integer> arrayOfIntegers, Integer valueToCheck,int accumulated){
        if(numValues>=0){
            accumulated += arrayOfIntegers.get(numValues);
            return isSum(numValues-1,arrayOfIntegers,valueToCheck,accumulated);
        }else{
            return accumulated == valueToCheck;
        }
    }
}
