package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

import java.util.Objects;

public class CheckPunctuation {
    public CheckPunctuation(){
        Utilities utilities = new Utilities();
        String stringOfCharacters = "";
        stringOfCharacters = utilities.performStringAsking(stringOfCharacters,"all");
        boolean hasPunctuation = checkIfHasPunctuation(stringOfCharacters,0);
        if(hasPunctuation) {
            System.out.println("\nThe string has punctuation marks\n");
        }else{
            System.out.println("\nThe string doesn't have punctuation marks\n");
        }
    }

    private boolean checkIfHasPunctuation(String stringOfCharacters, int position) {
        if(position<stringOfCharacters.length()){
            if(Objects.equals(stringOfCharacters.charAt(position),'.')||Objects.equals(stringOfCharacters.charAt(position),',')){
                return true;
            }
            return checkIfHasPunctuation(stringOfCharacters,position+1);
        }
        return false;
    }
}
