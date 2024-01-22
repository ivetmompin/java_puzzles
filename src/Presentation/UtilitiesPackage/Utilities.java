package src.Presentation.UtilitiesPackage;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {
    Scanner scanner;
    public Utilities(){
        scanner = new Scanner(System.in);
    }

    public int askForNumberOfValuesInArray(){
        System.out.print("Please, enter the number of values to add in the array:\040");
        int number = scanner.nextInt();
        if(number>0){
            return number;
        }else{
            System.out.println("You have to enter an integer greater than 0");
            return askForNumberOfValuesInArray();
        }
    }
    public ArrayList<Integer> performValuesAsking(ArrayList<Integer> arrayOfInteger, int numberOfValues,String inputType) {
        if(numberOfValues>0){
            System.out.print("Enter next value to store:\040");
            switch (inputType){
                case "all"->{
                    try {
                        arrayOfInteger.add(scanner.nextInt());
                        return performValuesAsking(arrayOfInteger, numberOfValues - 1,inputType);
                    } catch (Exception e) {
                        System.out.println("The value entered is not an integer. Try Again");
                        return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                    }
                }
                case "binary"->{
                    try {
                        int bit = scanner.nextInt();
                        if(bit==0||bit==1) {
                            arrayOfInteger.add(bit);
                            return performValuesAsking(arrayOfInteger, numberOfValues - 1,inputType);
                        }else{
                            System.out.println("The value entered is not 0 or 1. Try Again");
                            return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                        }
                    } catch (Exception e) {
                        System.out.println("The value entered is not an integer. Try Again");
                        return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                    }

                }
                case "noZero"->{
                    try {
                        int value = scanner.nextInt();
                        if(value!=0) {
                            arrayOfInteger.add(value);
                            return performValuesAsking(arrayOfInteger, numberOfValues - 1,inputType);
                        }else{
                            System.out.println("The value entered cannot be 0. Try Again");
                            return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                        }
                    } catch (Exception e) {
                        System.out.println("The value entered is not an integer. Try Again");
                        return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                    }
                }
                case "ZeroTen"->{
                    try {
                        int value = scanner.nextInt();
                        if(value>=0&&value<=10&&!arrayOfInteger.contains(value)) {
                            arrayOfInteger.add(value);
                            return performValuesAsking(arrayOfInteger, numberOfValues - 1,inputType);
                        }else{
                            System.out.println("The value entered cannot be repeated, smaller than 0 or greater than 10. Try Again");
                            return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                        }
                    } catch (Exception e) {
                        System.out.println("The value entered is not an integer. Try Again");
                        return performValuesAsking(arrayOfInteger, numberOfValues,inputType);
                    }
                }
            }
        }
        System.out.print("\nFinal array: ");
        printArray(arrayOfInteger,0);
        return arrayOfInteger;
    }

    public void printArray(ArrayList<Integer> array,int position){
        if(position<array.size()){
            System.out.print(array.get(position)+" ");
            printArray(array,position+1);
        }
    }

    public String performStringAsking(String stringOfCharacters, String caseAsk) {
        System.out.print("Please, enter the string you want to check:\040");
        switch(caseAsk){
            case "all":
                stringOfCharacters = scanner.next();
                break;
            case "oneWord":
                stringOfCharacters = scanner.nextLine();
                if(stringOfCharacters.contains(" ")){
                    System.out.println("You can only enter one word. Try Again");
                    return performStringAsking(stringOfCharacters,caseAsk);
                }
                break;
            default:
                break;
        }
        return stringOfCharacters;
    }

    public Integer performIntegerAsking(Integer integer, String caseAsk) {
        System.out.print("Please, enter the integer you want to check:\040");
        switch(caseAsk){
            case "all":
                integer = scanner.nextInt();
                break;
            case "positive":
                integer = scanner.nextInt();
                if(integer<0){
                    System.out.println("You can only enter positive integer. Try Again");
                    return performIntegerAsking(integer,caseAsk);
                }
                break;
            default:
                break;
        }
        return integer;
    }

    public ArrayList<ArrayList<Integer>> performMatrixAsking(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow) {
        if(numColumn<dimension){
            if(numRow<dimension) {
                try{
                    System.out.print("Enter value (" + numRow + "," + numColumn + "):\040");
                    int value = scanner.nextInt();
                    if (numRow == 0) {
                        ArrayList<Integer> nextColumn = new ArrayList<>();
                        matrixOfIntegers.add(nextColumn);
                    }
                    matrixOfIntegers.get(numColumn).add(value);
                    if (numRow < (dimension - 1)) {
                        return performMatrixAsking(matrixOfIntegers, dimension, numColumn, numRow + 1);
                    }
                    return performMatrixAsking(matrixOfIntegers, dimension, numColumn + 1, 0);
                }catch(Exception e){
                    System.out.println("The value entered is not an integer. Try Again");
                    return performMatrixAsking(matrixOfIntegers,dimension,numColumn,numRow);
                }
            }
        }
        System.out.println("\nFinal matrix: ");
        printMatrix(matrixOfIntegers,dimension,0);
        return matrixOfIntegers;
    }

    private void printMatrix(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension,int position) {
        if(position<dimension){
            printArray(matrixOfIntegers.get(position),0);
            System.out.print("\n");
            printMatrix(matrixOfIntegers,dimension,position+1);
        }
    }

    public int askForDimensionOfMatrix() {
        System.out.print("Enter the dimension of the matrix nxn: \040");
        int dimension;
        try {
            dimension = scanner.nextInt();
            if (dimension < 1) {
                System.out.println("The value entered has to be greater than 0. Try Again");
                return askForDimensionOfMatrix();
            }
        }catch(Exception e){
            System.out.println("The value entered is not an integer. Try Again");
            return askForDimensionOfMatrix();
        }
        return dimension;
    }
}
