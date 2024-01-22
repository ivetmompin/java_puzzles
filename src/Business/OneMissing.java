package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class OneMissing {

    public OneMissing() {
        Utilities utilities = new Utilities();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers = utilities.performValuesAsking(arrayOfIntegers, 10, "ZeroTen");
        int missing = getNumberMissing(arrayOfIntegers, 0, 0);
        System.out.println("\nThe number missing is: " + missing + "\n");
    }

    private int getNumberMissing(ArrayList<Integer> arrayOfIntegers, int position, int currentValue) {
        if(position<10){
            if(currentValue==arrayOfIntegers.get(position)){
                return getNumberMissing(arrayOfIntegers,0,currentValue+1);
            }else{
                return getNumberMissing(arrayOfIntegers,position+1,currentValue);
            }
        }
        return currentValue;
    }
}
