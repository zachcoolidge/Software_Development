import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// Class: CSC-490
// Term: Spring 2023
// Name: Zachary Coolidge
// Program Number: Assignment 1 Program 4
// IDE: Intellij
public class DistinctValues_ZTC {
    /**
     * Zachary Coolidge
     * This program takes an input of 10 integers and returns a list of the values excluding all repeated instances of each int.
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cont = "Y";
        while (cont.equals("Y")) {
            int i;
            int[] nums = new int[10];
            System.out.print("Please enter 10 integers:");
            for (i = 0; i < nums.length; i++) {
                int input = in.nextInt();
                nums[i] = input;
            }
            System.out.println("Entered numbers:" + Arrays.toString(nums));
            System.out.println("Distinct Numbers" + get_values(nums));
            in.nextLine();
            System.out.print("Retry? (Y/N):");
            cont = in.nextLine();

        }
    }

    /**
     * takes in an array of integers and adds each distinct integer to an arraylist
     * @param int_array an array of integers to check
     * @return returns an ArrayList containing the distinct values.
     */
    public static ArrayList<Integer> get_values(int[] int_array) {
        ArrayList<Integer> distinct_vals = new ArrayList<>();
        for (int num: int_array){
            if (!distinct_vals.contains(num)) // if the ArrayList distinct_vals doesn't have the num contained in it, it adds it to that ArrayList.
                distinct_vals.add(num);
        }
        return distinct_vals;
    }
}
