package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class MultiplyNonZero {
    public MultiplyNonZero(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,numValues,"all");
        int nonZeroM = getNonZeroMultiplication(arrayOfIntegers,numValues,0,1);
        System.out.println("\nThe multiplication of non-zero elements amounts to: "+nonZeroM+"\n");
    }

    private int getNonZeroMultiplication(ArrayList<Integer> arrayOfIntegers, int dimension,int position, int multiplier) {
        if(position<dimension){
            if(!arrayOfIntegers.get(position).equals(0)){
                multiplier *= arrayOfIntegers.get(position);
            }
            return getNonZeroMultiplication(arrayOfIntegers,dimension,position+1,multiplier);
        }
        return multiplier;
    }
}
