package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.ArrayList;
public class CountMaxRepeated {
    public CountMaxRepeated() {
        Utilities utilities = new Utilities();
        int numValues = utilities.askForDimensionOfMatrix();
        ArrayList<ArrayList<Integer>> matrixOfIntegers = new ArrayList<>();
        matrixOfIntegers = utilities.performMatrixAsking(matrixOfIntegers, numValues, 0, 0);
        int maximum = getMax(matrixOfIntegers, numValues, 0, 0, 0);
        int repetitions = getRepetitions(matrixOfIntegers,numValues,0,0,maximum,0);
        System.out.println("\nMax Value: " + maximum + " appears " + repetitions + " times in the matrix");
    }

    private int getRepetitions(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow, int maximum, int repetitions) {
        if(numColumn<dimension){
            if(numRow<dimension){
                if(maximum==matrixOfIntegers.get(numColumn).get(numRow)){
                    return getRepetitions(matrixOfIntegers,dimension,numColumn,numRow+1,maximum,repetitions+1);
                }
            }
            return getRepetitions(matrixOfIntegers,dimension,numColumn+1,numRow,maximum,repetitions);
        }
        return maximum;
    }

    private Integer getMax(ArrayList<ArrayList<Integer>> matrixOfIntegers, int dimension, int numColumn, int numRow, int maximum) {
            if(numColumn<dimension){
                if(numRow<dimension){
                    if(maximum<=matrixOfIntegers.get(numColumn).get(numRow)){
                        if(!(maximum==matrixOfIntegers.get(numColumn).get(numRow))) {
                            maximum = matrixOfIntegers.get(numColumn).get(numRow);
                        }
                    }
                    return getMax(matrixOfIntegers,dimension,numColumn,numRow+1,maximum);
                }
                return getMax(matrixOfIntegers,dimension,numColumn+1,numRow,maximum);
            }
            return maximum;
    }
}
