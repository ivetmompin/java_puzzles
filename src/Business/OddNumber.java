package src.Business;

import java.util.Scanner;

public class OddNumber {
    Scanner scanner = new Scanner(System.in);
    public OddNumber() {
        System.out.print("Enter a number:\040");
        int number = scanner.nextInt();
        int sum=0;
        System.out.print(""" 
                         Which type of recursive algorithm do you want to implement?
                                1) Simple Recursive
                                2) Tail Recursive
                         Enter 1 or 2:\040""");
        int choice = scanner.nextInt();
        if(choice==1) {
            sum = addAllOddsTail(number, 1, 0);
        }else if(choice==2){
            sum = addAllOddsSimple(number);
        }else{
            new OddNumber();
        }
        System.out.println("The total sum is: "+sum);
    }
    //NON-TAIL RECURSION --> WE FIND THE ANSWER ON THE WAY DOWN
    public int addAllOddsSimple(int number) {
        if(number%2==0){
            number=number-1;
        }else{
            if(number==1){
                return 1;
            }
        }
        return number + addAllOddsSimple(number-2);
    }

    //TAIL RECURSION: WE FIND THE ANSWER ON THE WAY UP
    public int addAllOddsTail(int number, int currentValue, int sum){
        if(currentValue<=number){
             sum += currentValue;
             return addAllOddsTail(number,currentValue+2, sum);
        }
        return sum;
    }
}
