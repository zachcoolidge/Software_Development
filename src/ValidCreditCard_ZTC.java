import java.util.Scanner;
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
            //System.out.println("Number to be doubled " + nums[i]);
            //System.out.println("doubled number ");
            if (doubled_number>=10) {
                char[] dub_num = Integer.toString(doubled_number).toCharArray();
                doubled_number= Character.getNumericValue(dub_num[0]) + Character.getNumericValue(dub_num[1]);
                //System.out.println("new doubled number if greater than 10 " +doubled_number);
            }
            even_sum+= doubled_number;
        }
        //System.out.println("even sum " + even_sum);
        int odd_sum = 0;
        for(int i=nums.length-1;i>=0;i-=2)
            odd_sum += Character.getNumericValue(nums[i]);
        //System.out.println("odd sum " + odd_sum);
        if((even_sum+odd_sum) % 10 == 0)
            return "valid";
        return "not valid";
    }
}
