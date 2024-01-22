package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;

public class CheckUpperTriangular {
    public CheckUpperTriangular(){
        Utilities utilities = new Utilities();
        int numValues = utilities.askForDimensionOfMatrix();
        ArrayList<ArrayList<Integer>> matrixOfIntegers = new ArrayList<>();
        matrixOfIntegers= utilities.performMatrixAsking(matrixOfIntegers,numValues,0,0);
        boolean triangular = isUpperTriangular(matrixOfIntegers,numValues,0,1);
        if (!triangular) {
            System.out.println("\nThe matrix is not triangular");
        }else {
            System.out.println("\nThe matrix is triangular");
        }
    }

    public boolean isUpperTriangular(ArrayList<ArrayList<Integer>> matrix, int dimension,int numColumn, int numRow){
        if(numColumn<dimension) {
            if (numRow < numColumn) {
                if (matrix.get(numColumn).get(numRow) != 0) {
                    return false;
                }
                return isUpperTriangular(matrix, dimension,numColumn, numRow+1);
            }
            return isUpperTriangular(matrix,dimension,numColumn+1,numRow);
        }
        return true;
    }
}
