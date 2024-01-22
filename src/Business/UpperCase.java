package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

public class UpperCase {
    public UpperCase(){
        Utilities utilities = new Utilities();
        String stringOfCharacters = "";
        stringOfCharacters = utilities.performStringAsking(stringOfCharacters,"all");
        stringOfCharacters = performUpperCase(stringOfCharacters,0);
        System.out.println("\nThe uppercase string is: " +stringOfCharacters+"\n");

    }
    private String performUpperCase(String stringOfCharacters,int position) {
        if(position<stringOfCharacters.length()){
            stringOfCharacters=stringOfCharacters.replace(stringOfCharacters.charAt(position),Character.toUpperCase(stringOfCharacters.charAt(position)));
            return performUpperCase(stringOfCharacters,position+1);
        }
        return stringOfCharacters;
    }
}
