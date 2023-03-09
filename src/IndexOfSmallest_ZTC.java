import java.util.Arrays;
import java.util.Scanner;

public class IndexOfSmallest_ZTC {
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
            System.out.println("Index of smallest value:" + find_index(nums));
            in.nextLine();
            System.out.print("Retry? (Y/N):");
            cont = in.nextLine();
        }
    }
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