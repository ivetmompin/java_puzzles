package src.Business.Sorts;

import src.Presentation.UtilitiesPackage.Utilities;
import java.util.ArrayList;

public class InsertionSort {
    public InsertionSort(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers = utilities.performValuesAsking(arrayOfIntegers, numValues, "all");
        ArrayList<Integer> sorted = sortArray(arrayOfIntegers, numValues, 1);
        System.out.println("\n---Sorted Array---");
        utilities.printArray(sorted,0);
    }
    public ArrayList<Integer> sortArray(ArrayList<Integer> arrayOfIntegers, int dimension, int position) {
        if(position<dimension){
            int temp = arrayOfIntegers.get(position);
            arrayOfIntegers=checkIfSwap(arrayOfIntegers,position-1,temp);
            return sortArray(arrayOfIntegers,dimension,position+1);
        }
        return arrayOfIntegers;
    }

    private ArrayList<Integer> checkIfSwap(ArrayList<Integer> arrayOfIntegers, int positionInCheck, int temp) {
        if(positionInCheck>=0 && arrayOfIntegers.get(positionInCheck)>temp){
            arrayOfIntegers.set(positionInCheck+1,arrayOfIntegers.get(positionInCheck));
            return checkIfSwap(arrayOfIntegers,positionInCheck-1,temp);
        }
        arrayOfIntegers.set(positionInCheck+1,temp);
        return arrayOfIntegers;
    }
}
