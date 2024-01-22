package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;
import java.util.Scanner;

public class ZeroInterval {
    /***
     * Receives a non-empty array of n integers and two integers in the [0, n) range, and
     * checks whether any of the elements comprised between those cursors (both included) is equal to 0
     */
    public ZeroInterval(){
        Utilities utilities = new Utilities();
        Scanner scanner = new Scanner(System.in);
        int number = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,number,"all");
        System.out.println("Okay. Now enter the range in which to do the search. ");
        System.out.print("\tEnter the starting position[0,"+(number-1)+"]:\040");
        int start = scanner.nextInt();
        System.out.print("\tEnter the ending position["+start+","+(number-1)+"]:\040");
        int end = scanner.nextInt();
        boolean containsZero = checkIfZeroInTheRange(arrayOfIntegers,start,end,false);
        if (!containsZero) {
            System.out.println("The array does not contain any 0");
        }else {
            System.out.println("The array contains at least a 0");
        }
    }

    private boolean checkIfZeroInTheRange(ArrayList<Integer> arrayOfIntegers,int start,int end,boolean containsZero) {
        if(!containsZero&&start<=end){
            containsZero=(arrayOfIntegers.get(start)==0);
            return checkIfZeroInTheRange(arrayOfIntegers,start+1,end,containsZero);
        }
        return containsZero;
    }
}
