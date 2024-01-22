package src.Business.Sorts;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class BubbleSort {
    public BubbleSort(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers = utilities.performValuesAsking(arrayOfIntegers, numValues, "all");
        ArrayList<Integer> sorted = sortArray(arrayOfIntegers, numValues,0);
        System.out.println("\n---Sorted Array---");
        utilities.printArray(sorted,0);
    }
    public ArrayList<Integer> sortArray(ArrayList<Integer> arrayOfIntegers, int dimension, int position){
        if(position<dimension-1){
            int temp =0;
            arrayOfIntegers=checkIfSwap(arrayOfIntegers,0,dimension,position,temp,false);
            if(arrayOfIntegers.size()>dimension){
                arrayOfIntegers=removeDimensions(arrayOfIntegers,dimension);
                position=dimension;
            }
            return sortArray(arrayOfIntegers,dimension, position+1);
        }
        return arrayOfIntegers;
    }

    private ArrayList<Integer> removeDimensions(ArrayList<Integer> arrayOfIntegers, int dimension) {
        if(dimension<arrayOfIntegers.size()){
            arrayOfIntegers.remove(dimension);
            return removeDimensions(arrayOfIntegers,dimension+1);
        }
        return arrayOfIntegers;

    }

    private ArrayList<Integer> checkIfSwap(ArrayList<Integer> arrayOfIntegers, int positionInCheck, int dimension, int positionInSort, int temp, boolean swap) {
        if(positionInCheck<dimension-positionInSort-1){
            if (arrayOfIntegers.get(positionInCheck) > arrayOfIntegers.get(positionInCheck + 1)) {
                temp = arrayOfIntegers.get(positionInCheck);
                arrayOfIntegers.set(positionInCheck, arrayOfIntegers.get(positionInCheck + 1));
                arrayOfIntegers.set(positionInCheck + 1, temp);
                swap = true;
            }
            return checkIfSwap(arrayOfIntegers,positionInCheck+1,dimension, positionInSort, temp, swap);
        }
        if(swap){
            arrayOfIntegers.add(dimension);
        }
        return arrayOfIntegers;
    }
}
