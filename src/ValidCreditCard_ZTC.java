import java.util.Scanner;
// Class: CSC-490
// Term: Spring 2023
// Name: Zachary Coolidge
// Program Number: Assignment 1 Program 5
// IDE: Intellij
public class ValidCreditCard_ZTC {
    /**
     * Zachary Coolidge
     * This program verifies if a credit card number is valid.
     *
     */
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer:");
        long input = in.nextLong();
        System.out.println(input + " is " + verify_cc(input));
    }

    /**
     * This verifies the credit card number based on the Luhn check algorithm.
     * @param credit_card_num a long integer
     * @return returns valid if the credit card number is valid otherwise returns invalid.
     */
    public static String verify_cc(long credit_card_num){
        char[] nums = Long.toString(credit_card_num).toCharArray();
        int even_sum = 0;
        for(int i=nums.length-2;i>=0;i-=2){ // for loop starting at the second to last number index
            int doubled_number = Character.getNumericValue(nums[i]) * 2; // turns the character to an integer instead of ascii value
            if (doubled_number>=10) {
                doubled_number= Integer.toString(doubled_number).charAt(0) + Integer.toString(doubled_number).charAt(1); // if the number is greater than 10, this splits the numbers then adds them.
                //System.out.println("new doubled number if greater than 10 " +doubled_number);
            }
            even_sum+= doubled_number;
        }
        //System.out.println("even sum " + even_sum);
        int odd_sum = 0;
        for(int i=nums.length-1;i>=0;i-=2) // for loop starts at the end of the credit card number and skips every other number
            odd_sum += Character.getNumericValue(nums[i]);
        //System.out.println("odd sum " + odd_sum);
        if((even_sum+odd_sum) % 10 == 0) // if the sum of even/odd places is divisible by 10, it is a valid card
            return "valid";
        return "not valid";
    }
}
