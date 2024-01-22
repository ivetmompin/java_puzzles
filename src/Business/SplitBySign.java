package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class SplitBySign {
    public SplitBySign() {
        Utilities utilities = new Utilities();
        int numValues = utilities.askForNumberOfValuesInArray();
        if(numValues%2!=0){
            System.out.println("The number of values has to be an even number.");
            new SplitBySign();
        }
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,numValues,"all");
        if(arrayOfIntegers.contains(0)) {
            System.out.println("\nThe array cannot have 0s. Enter only positive or negative integers\n");
            new SplitBySign();
        }
        if(!checkSameNumPositiveAndNegative(arrayOfIntegers,0,0)){
            System.out.println("The array has to have the same number of positive and negative values");
            new SplitBySign();
        }
        ArrayList<ArrayList<Integer>> arrays = new ArrayList<>();
        arrays.add(new ArrayList<>());
        arrays.add(new ArrayList<>());
        arrays=getPositiveNegativeArrays(arrayOfIntegers,0,arrays);
        System.out.println("\nPositive array: ");
        utilities.printArray(arrays.get(0),0);
        System.out.println("\nNegative array: ");
        utilities.printArray(arrays.get(1),0);
    }

    private boolean checkSameNumPositiveAndNegative(ArrayList<Integer> arrayOfIntegers, int position, int positive) {
        if(position<arrayOfIntegers.size()){
            if(arrayOfIntegers.get(position)>0){
                positive++;
            }
            return checkSameNumPositiveAndNegative(arrayOfIntegers,position+1,positive);
        }
        return positive == (arrayOfIntegers.size() / 2);
    }

    private ArrayList<ArrayList<Integer>> getPositiveNegativeArrays(ArrayList<Integer> arrayOfIntegers, int position, ArrayList<ArrayList<Integer>> arrays) {
        if(position<arrayOfIntegers.size()) {
            if(arrayOfIntegers.get(position)<0){
                arrays.get(1).add(arrayOfIntegers.get(position));
            }else{
                arrays.get(0).add(arrayOfIntegers.get(position));
            }
            return getPositiveNegativeArrays(arrayOfIntegers,position+1,arrays);
        }
        return arrays;
    }

}
