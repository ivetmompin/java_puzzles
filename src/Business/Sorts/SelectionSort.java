package src.Business.Sorts;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class SelectionSort {

    public SelectionSort(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers = utilities.performValuesAsking(arrayOfIntegers, numValues, "all");
        ArrayList<Integer> sorted = sortArray(arrayOfIntegers, numValues, 0,0);
        System.out.println("---Sorted Array---");
        utilities.printArray(sorted,0);
    }

    public ArrayList<Integer> sortArray(ArrayList<Integer> arrayOfIntegers, int dimension, int position, int minimum) {
        if(position<dimension){
            minimum=position;
            arrayOfIntegers=checkIfSwap(arrayOfIntegers,dimension,minimum,minimum+1);
            return sortArray(arrayOfIntegers,dimension,position+1,minimum);
        }
        return arrayOfIntegers;
    }

    private ArrayList<Integer> checkIfSwap(ArrayList<Integer> arrayOfIntegers, int dimension, int positionInSort, int positionInCheck) {
        if(positionInCheck<dimension){
            if(arrayOfIntegers.get(positionInCheck)<arrayOfIntegers.get(positionInSort)){
                int temp = arrayOfIntegers.get(positionInSort);
                arrayOfIntegers.set(positionInSort,arrayOfIntegers.get(positionInCheck));
                arrayOfIntegers.set(positionInCheck,temp);
            }
            return checkIfSwap(arrayOfIntegers,dimension,positionInSort,positionInCheck+1);
        }
        return arrayOfIntegers;
    }
}
