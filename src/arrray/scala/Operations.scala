package arrray.scala

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
object Operations {
  def finalValueAfterOperations(operations: Array[String]): Int = {
    operations.foldLeft[Int](0)((x, y) => y match {
      case "X++" | "++X" => x + 1
      case _ => x - 1
    })
  }

  def main(args: Array[String]): Unit = {
    val input = Array("X++", "++X", "--X", "X--")
    val rs = finalValueAfterOperations(input)
    println(rs)
  }
}
