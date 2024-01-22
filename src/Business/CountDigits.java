package src.Business;

import src.Presentation.UtilitiesPackage.Utilities;

public class CountDigits{

    private Utilities utilities;
    public CountDigits() {
        utilities = new Utilities();
        int integer = 0;
        integer = utilities.performIntegerAsking(integer,"positive");
        int numDigits=performCountDigits(integer);
        System.out.println(integer+" has "+numDigits+ " digits");
    }

    public int performCountDigits(int integer){
        if(integer<10){
            return 1;
        }else{
            return 1 + performCountDigits(integer/10);
        }
    }
}
