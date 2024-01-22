package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;
import java.util.Scanner;

public class Search {
    /***
     * Receives a non-empty array of n integers and another number, returning whether
     * it appears in the array
     */
    public Search(){
        Utilities utilities = new Utilities();
        Scanner scanner = new Scanner(System.in);
        int numValues = utilities.askForNumberOfValuesInArray();
        ArrayList<Integer> arrayOfIntegers = new ArrayList<>();
        arrayOfIntegers= utilities.performValuesAsking(arrayOfIntegers,numValues,"all");
        System.out.print("\tEnter the number to search:\040");
        int numberToSearch = scanner.nextInt();
        boolean containsNumber = checkIfNumberIsThere(arrayOfIntegers,numberToSearch,numValues-1);
        if (!containsNumber) {
            System.out.println("\nThe array does not contain the entered number");
        }else {
            System.out.println("\nThe array contains the number entered");
        }

    }

    private boolean checkIfNumberIsThere(ArrayList<Integer> arrayOfIntegers, int numberToSearch,int position) {
        if(position>=0){
            if(arrayOfIntegers.get(position)==numberToSearch){
                return true;
            }else{
                return checkIfNumberIsThere(arrayOfIntegers,numberToSearch,position-1);
            }
        }
        return false;
    }
}
