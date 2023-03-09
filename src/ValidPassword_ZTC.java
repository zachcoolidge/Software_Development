import java.util.Scanner;
// Class: CSC-490
// Term: Spring 2023
// Name: Zachary Coolidge
// Program Number: Assignment 1 Program 1

/**
 * This is a class that takes a password input from a user and checks
 * it for different criteria
 *
 * @see java.util.Scanner
 */
public class ValidPassword_ZTC {
    /**
     * main
     * Takes an input from user, specifically a potential password,
     * and passes it to the valid_password_ztc method, where it validates
     * certain criteria. Quits when the user enters N when prompted to retry.
     * @param args not used
     */
    public static void main(String[] args){

    Scanner in = new Scanner(System.in);
    String cont = "Y";
    while(cont.equals("Y")){
        System.out.print("Please enter your password:");
        String input = in.nextLine();
        System.out.println("Entered password:" + input);
        System.out.println("Judgement:" +valid_password_ztc(input));
        System.out.print("Retry? (Y/N):");
        cont = in.nextLine();
    }

    }

    /**
     * valid_password_ztc
     * Takes an inputted String password, and then takes that and
     * validates it through each rule method.
     * @param pass_in a password string
     * @return Valid Password if the inputted password meets all criteria,
     * else it returns the criteria that it failed.
     */
    public static String valid_password_ztc(String pass_in) {
        StringBuilder result = new StringBuilder();
        boolean[] rules = {rule_a(pass_in), rule_b(pass_in), rule_c(pass_in), rule_d(pass_in), rule_e(pass_in)}; //passes all the rules into a boolean array.
        if (rules[0] && rules[1] && rules[2] && rules[3] && rules[4]) {
            result.append("Valid Password");
            return result.toString();
        } else {
            char[] violations = {'A', 'B', 'C', 'D', 'E'};
            for (int i = 0; i < rules.length; i++) {
                if (!rules[i]) { //if a rule returns false, then this runs and adds a space between each violation.
                    result.append(violations[i]);
                    result.append((char) 32);
                }
            }
        }
        return "Violations: " + result;
    }

    /**
     * rule_a
     * rule a checks what the length of the password string is
     * @param input - a password string
     * @return true iff password is 8 or more characters
     *         false iff password is less than 8 characters
     */
    private static boolean rule_a(String input){
        return input.length() >= 8;
    }

    /**
     * rule_b
     * rule b checks if the password is only alphanumeric
     * @param input a string password
     * @return true iff the password only contains alphanumeric characters
     *         false iff the password contains other types of characters.
     */
    private static boolean rule_b(String input){
        for(int i=0;i<input.length();i++){
            if(!Character.isLetterOrDigit(input.charAt(i)))
                return false;
        }
        return true;
    }

    /**
     * rule_c
     * rule c checks if the password input has numbers in the password
     * @param input a string password
     * @return true iff the password input has 4 or more numbers
     *         false iff the password input has less than 4 numbers
     */
    private static boolean rule_c(String input){
        int num_count = 0;
        char [] chars = input.toCharArray();
        for (char x: chars){
            if (Character.isDigit(x))
                num_count++;
        }
        return num_count >= 4;
    }

    /**
     * rule_d
     * rule d checks if the password has lowercase letters
     *
     * @param input a password string
     * @return true iff the password has 3 or more lowercase letters
     *         false iff the password has less than 3 lowercase letters
     */
    private static boolean rule_d(String input){
        int low_count = 0;
        for(int i =0;i <input.length();i++){
            if(Character.isLowerCase(input.charAt(i)))
                low_count++;
        }
        return low_count >= 3;
    }

    /**
     * rule_e
     * rule e checks to see if the password string has uppercase letters
     * @param input a password string
     * @return true iff the password has 3 or more uppercase letters
     *         false iff the password has less than 3 uppercase letters
     */
    private static boolean rule_e(String input){
        int upper_count = 0;
        for(int i=0;i<input.length();i++){
            if(Character.isUpperCase(input.charAt(i)))
                upper_count++;
        }
        return upper_count>=3;
    }
}


//  I a_n       b_n       x          f(x)            Rel Err
//  1 1.00000000 3.00000000 2.00000000 -6.94507726e-01  5.00000000e-01
//  2 2.00000000 3.00000000 2.50000000 -2.72657170e-01  2.00000000e-01
//  3 2.50000000 3.00000000 2.75000000 -4.06962384e-02  9.09090909e-02
//  4 2.75000000 3.00000000 2.87500000  7.91836535e-02  4.34782609e-02
//  5 2.75000000 2.87500000 2.81250000  1.89532319e-02  2.22222222e-02
//  6 2.75000000 2.81250000 2.78125000 -1.09465813e-02  1.12359551e-02
//  7 2.78125000 2.81250000 2.79687500  3.98486733e-03  5.58659218e-03
//  8 2.78125000 2.79687500 2.78906250 -3.48551015e-03  2.80112045e-03
//  9 2.78906250 2.79687500 2.79296875  2.48520142e-04  1.39860140e-03
// 10 2.78906250 2.79296875 2.79101562 -1.61878522e-03  6.99790063e-04
// 11 2.79101562 2.79296875 2.79199219 -6.85205019e-04  3.49772648e-04
// 12 2.79199219 2.79296875 2.79248047 -2.18360548e-04  1.74855744e-04
// 13 2.79248047 2.79296875 2.79272461  1.50752706e-05  8.74202290e-05
// 14 2.79248047 2.79272461 2.79260254 -1.01643771e-04  4.37120252e-05
// 15 2.79260254 2.79272461 2.79266357 -4.32845329e-05  2.18555349e-05
// 16 2.79266357 2.79272461 2.79269409 -1.41047019e-05  1.09276480e-05
// 17 2.79269409 2.79272461 2.79270935  4.85266655e-07  5.46379417e-06
// 18 2.79269409 2.79270935 2.79270172 -6.80972199e-06  2.73190455e-06
// 19 2.79270172 2.79270935 2.79270554 -3.16222882e-06  1.36595041e-06
// 20 2.79270554 2.79270935 2.79270744 -1.33848130e-06  6.82974737e-07
// 21 2.79270744 2.79270935 2.79270840 -4.26607432e-07  3.41487252e-07
// 22 2.79270840 2.79270935 2.79270887  2.93296107e-08  1.70743597e-07
// 23 2.79270840 2.79270887 2.79270864 -1.98638911e-07  8.53718057e-08
// 24 2.79270864 2.79270887 2.79270875 -8.46546810e-08  4.26859010e-08
// 25 2.79270875 2.79270887 2.79270881 -2.76625443e-08  2.13429501e-08
// 26 2.79270881 2.79270887 2.79270884  8.33570990e-10  1.06714749e-08
// 27 2.79270881 2.79270884 2.79270883 -1.34145117e-08  5.33573749e-09
// 28 2.79270883 2.79270884 2.79270884 -6.29047348e-09  2.66786874e-09
// 29 2.79270884 2.79270884 2.79270884 -2.72849032e-09  1.33393437e-09
// 30 2.79270884 2.79270884 2.79270884 -9.47440792e-10  6.66967183e-10
// 31 2.79270884 2.79270884 2.79270884 -5.69757574e-11  3.33483591e-10
//The zero occurs approximately at x=2.7927088430 which took 31 iterations
//>>
