package src.Business;
import java.util.Scanner;

public class SuperFactorial {
    /***
     * Receives a strictly positive integer and returns its superfactorial. The superfactorial
     * of an integer n is the result of multiplying all factorials from 1! to n!.For
     * instance, the superfactorial of 4 is 1!·2!·3!·4! = 288.
     */
    public SuperFactorial(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please, enter the number to do the super factorial:\040");
        int number = scanner.nextInt();
        if (number > 0) {
            int answer = performFactorial(number,1);
            System.out.println("\nThe super factorial of the number entered is: "+answer+"\n");
        }else {
            System.out.println("You have to enter an integer greater than 0");
            new SuperFactorial();
        }

    }

    public int performFactorial(int number, int answer){
        if(number>0){
            System.out.println("Performing subFactorial of "+number);
            answer*=performSubFactorial(number,1);
            answer=performFactorial(number-1,answer);
        }
        return answer;
    }

    private int performSubFactorial(int number,int answer) {
        if(number>0){
            answer*=number;
            System.out.println("\tcurrent answer: "+answer);
            answer=performSubFactorial(number-1,answer);
        }
        return answer;
    }
}
