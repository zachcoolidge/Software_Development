import java.util.Arrays;
import java.util.Scanner;

/**
 * This program takes an input of 10 integers and outputs the smallest integer in that array.
 */
public class IndexOfSmallest_ZTC {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String cont = "Y";
        while (cont.equals("Y")) {
            int[] nums = new int[10];
            System.out.print("Please enter 10 integers:");
            for (int i = 0; i < nums.length; i++) {
                int input = in.nextInt();
                nums[i] = input; //adds each input to an int array
            }
            System.out.println("Entered numbers:" + Arrays.toString(nums));
            System.out.println("Index of smallest value:" + find_index(nums));
            in.nextLine();
            System.out.print("Retry? (Y/N):");
            cont = in.nextLine();
        }
    }

    /**
     * Takes an int array and returns the index of the smallest number
     * @param num_list an int array
     * @return the index of the smallest integer
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static int find_index(int[] num_list){
        int i;
        int min = Arrays.stream(num_list).min().getAsInt();
        for(i=0;i<num_list.length;i++) {
            if (num_list[i] == min)
                break;
        }
        return i;
    }
}