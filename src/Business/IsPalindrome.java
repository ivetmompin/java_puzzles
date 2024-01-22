package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

public class IsPalindrome {
    public IsPalindrome(){
        Utilities utilities = new Utilities();
        String stringOfCharacters = "";
        stringOfCharacters = utilities.performStringAsking(stringOfCharacters,"oneWord");
        boolean isPalindrome = checkIfPalindrome(stringOfCharacters,0);
        if(isPalindrome) {
            System.out.println("\nThe string is a palindrome\n");
        }else{
            System.out.println("\nThe string isn't a palindrome\n");
        }
    }

    public boolean checkIfPalindrome(String stringOfCharacters,int position){
        if(position<stringOfCharacters.length()){
            if(stringOfCharacters.charAt(position)!=stringOfCharacters.charAt((stringOfCharacters.length()-1)-position)){
                return false;
            }
            return checkIfPalindrome(stringOfCharacters,position+1);
        }
        return true;
    }
}
