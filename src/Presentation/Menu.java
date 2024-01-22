package src.Presentation;

import src.Business.*;
import src.Business.Searches.BinarySearch;
import src.Business.Sorts.BubbleSort;
import src.Business.Sorts.InsertionSort;
import src.Business.Sorts.SelectionSort;

import java.util.Scanner;

public class Menu {
    public Menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                
                Select the operation to perform:
                
                \t1)  SuperFactorial
                \t2)  Zero Interval
                \t3)  Search
                \t4)  Last Sum
                \t5)  Binary To Decimal
                \t6)  Alternating Sum
                \t7)  Check Balance
                \t8)  One Missing
                \t9)  Check Punctuation
                \t10) Uppercase
                \t11) Is Palindrome?
                \t12) Check Upper Triangular
                \t13) Count Maximum Repeated
                \t14) Almost Sudoku
                \t15) Multiply Non Zero
                \t16) Split By Sign
                \t17) Selection Sort
                \t18) Insertion Sort
                \t19) Bubble Sort
                \t20) Odd Number
                \t21) Binary Search
                \t22) Count Digits
                
                Enter your answer[1,24]:\040""");

        int answer = Integer.parseInt(scanner.next());

        switch(answer){
            case 1: new SuperFactorial();
            case 2: new ZeroInterval();
            case 3: new Search();
            case 4: new LastSum();
            case 5: new BinaryToDecimal();
            case 6: new AlternatingSum();
            case 7: new CheckBalance();
            case 8: new OneMissing();
            case 9: new CheckPunctuation();
            case 10:new UpperCase();
            case 11:new IsPalindrome();
            case 12:new CheckUpperTriangular();
            case 13:new CountMaxRepeated();
            case 14:new AlmostSudoku();
            case 15:new MultiplyNonZero();
            case 16:new SplitBySign();
            case 17:new SelectionSort();
            case 18:new InsertionSort();
            case 19:new BubbleSort();
            case 20:new OddNumber();
            case 21:new BinarySearch();
            case 22:new CountDigits();
            default: new Menu();
        }
    }
}
