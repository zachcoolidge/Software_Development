import java.util.Scanner;
import java.util.ArrayList;

// Class: CSC-490
// Term: Spring 2023
// Name: Zachary Coolidge
// Program Number: Assignment 1 Program 3
public class FreqDist_ZTC {
    /**
     * This program takes an arbitrary number of inputs and outputs a formatted list containing each number inputted, and the amount of occurrences.
     * @param args args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in); // Create a Scanner object to read user input from the console.
        ArrayList<Integer> nums = new ArrayList<>(); // Create an ArrayList of integers to store the user input.
        System.out.print("Please enter integers in the range of 0-40\n then enter a number not in range to quit:"); // Prompt the user to enter integers in the range of 0-40, and then enter a number not in range to quit.
        int input = in.nextInt(); // Read the user input and add it to the ArrayList of integers.
        nums.add(input);
        while (input >= 0 && input <=40) { // Use a while loop to continue reading user input and adding it to the ArrayList until the user enters a number outside of the range of 0-40.
            input = in.nextInt();
            if (!(input < 0 || input > 40))
                nums.add(input);
        }
        ArrayList<Integer> num_list = new ArrayList<>(); // Create a new ArrayList to store the unique integers entered by the user.
        int[] num_occurrence = new int[nums.size()]; // Create an integer array to store the frequency of each integer.
        int index = 0;
        for (Integer number : nums) { // Use a for-each loop to iterate over the ArrayList of integers entered by the user.
            if (!num_list.contains(number)) { // If the current integer is not already in the num_list ArrayList, add it and set the corresponding element in the num_occurrence array to 1.
                num_list.add(number);
                num_occurrence[index] = 1;
            } else // If the integer is already in the num_list ArrayList, increment the corresponding element in the num_occurrence array.
                num_occurrence[num_list.indexOf(number)] += 1;
            index++;
        }
        print_nums(num_list,num_occurrence); // Call the print_nums method, passing in the num_list and num_occurrence arrays.
    }

    /**
     * helper method that prints each unique number and the number of occurences.
     * @param list an ArrayList of unique integers
     * @param occurrences a list of the occurnces of each number.
     */
    public static void print_nums(ArrayList<Integer> list, int[] occurrences){ // Define a method called print_nums that takes the num_list and num_occurrence arrays as parameters and prints out a formatted frequency distribution table.
        System.out.println("Number   Times");
        for(int i=0;i<list.size();i++){
            System.out.printf("%2d %8d\n", list.get(i),occurrences[i]);
        }
    }
}
