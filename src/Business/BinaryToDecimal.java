package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class BinaryToDecimal {

    /***
     * Receives a non-empty array of n integers representing a number in
     * binary format and returns its decimal conversion.
     */
    public BinaryToDecimal(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,numValues,"binary");
        int decimalValue = getDecimalValue(arrayOfIntegers,0,0);
        System.out.println("\nThe decimal value of the entered value is: "+decimalValue+"\n");
    }

    private int getDecimalValue(ArrayList<Integer> arrayOfIntegers, int decimalValue,int position) {
        int size = arrayOfIntegers.size();
        if(position<size){
            if(arrayOfIntegers.get(position)==1) {
                if(position<size-1) {
                    decimalValue += calculatePower(arrayOfIntegers.get(position), (size-1)-position, 1);
                }else{
                    decimalValue += 1;
                }
            }
            return getDecimalValue(arrayOfIntegers,decimalValue,position+1);
        }
        return decimalValue;
    }

    public int calculatePower(Integer bit, int position,int accumulated) {
        if(position>0){
            accumulated *= bit * 2;
            return calculatePower(bit,position-1,accumulated);
        }
        return accumulated;
    }
}
