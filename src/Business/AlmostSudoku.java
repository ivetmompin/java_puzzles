package src.Business;

import java.util.ArrayList;
import src.Presentation.UtilitiesPackage.Utilities;
public class AlmostSudoku {
    public AlmostSudoku(){
        Utilities utilities = new Utilities();
        ArrayList<ArrayList<Integer>> matrixOfIntegers = new ArrayList<>();
        matrixOfIntegers= utilities.performMatrixAsking(matrixOfIntegers,9,0,0);
        boolean sudoku = isSudoku(matrixOfIntegers,9,0,0);
        if (!sudoku) {
            System.out.println("\nThe matrix is not a sudoku");
        }else {
            System.out.println("\nThe matrix is a sudoku");
        }
    }

    public boolean isSudoku(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow){
        if(numRow<dimension&&numColumn<dimension){
            if(checkRowColumn(matrixOfIntegers,dimension,numColumn,numRow)){
                return isSudoku(matrixOfIntegers,dimension,numColumn+1,numRow+1);
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean checkRowColumn(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow) {
        if(checkColumn(matrixOfIntegers,dimension,numColumn,0,new ArrayList<>())){
            if(checkRow(matrixOfIntegers,dimension,0,numRow,new ArrayList<>())){
                return true;
            }
        }
        return false;
    }
    private boolean checkColumn(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow, ArrayList<Integer> differentValues){
        if(numRow<dimension){
            if(!differentValues.contains(matrixOfIntegers.get(numColumn).get(numRow))) {
                differentValues.add(matrixOfIntegers.get(numColumn).get(numRow));
                return checkColumn(matrixOfIntegers, dimension, numColumn, numRow + 1, differentValues);
            }else{
                return false;
            }
        }
        return true;
    }

    private boolean checkRow(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow, ArrayList<Integer> differentValues){
        if(numColumn<dimension){
            if(!differentValues.contains(matrixOfIntegers.get(numColumn).get(numRow))) {
                differentValues.add(matrixOfIntegers.get(numColumn).get(numRow));
                return checkRow(matrixOfIntegers, dimension, numColumn+1, numRow, differentValues);
            }else{
                return false;
            }
        }
        return true;
    }
}
