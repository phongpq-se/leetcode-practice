package algorithms;

/*
https://www.geeksforgeeks.org/difference-between-and-equals-method-in-java/

There is a programming language with only four operations and one variable X:

++X and X++ increments the value of the variable X by 1.
--X and X-- decrements the value of the variable X by 1.
Initially, the value of X is 0.

Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
Example 1:

Input: operations = ["--X","X++","X++"]
Output: 1
Explanation: The operations are performed as follows:
Initially, X = 0.
--X: X is decremented by 1, X =  0 - 1 = -1.
X++: X is incremented by 1, X = -1 + 1 =  0.
X++: X is incremented by 1, X =  0 + 1 =  1.
* */

public class Operations {

    /*
    *
    runtime = 3ms
    Beats 6.03%of users with Java
    Memory = 42.12mb
    Beats 11.88%of users with Java
    * */
//    public static int finalValueAfterOperations(String[] operations) {
//        return Arrays.stream(operations).reduce(0, (x, y) -> {
//            if (y.equals("X++") || y.equals("++X")) return x + 1;
//            else return x - 1;
//        }, Integer::sum);
//    }

    public static int finalValueAfterOperations(String[] operations) {
        int rs = 0;
        for (String operation : operations) {
            if (operation.equals("X++") || operation.equals("++X")) rs++;
            else rs--;
        }
        return rs;
    }


    public static void main(String[] args) {
        String[] array = new String[]{"--X", "X++", "X++"};
        int rs = finalValueAfterOperations(array);
        System.out.println(rs);
    }
}
