package arrray.scala

object PredictWinner {
  def PredictTheWinner(nums: Array[Int]): Boolean = {
    isWin(nums, 0, nums.length - 1) >= 0
  }

  def isWin(nums: Array[Int], left: Int, right: Int): Int = {
    if (left == right) nums(left)
    else {
      val leftScore = nums(left) - isWin(nums, left + 1, right)
      val rightScore = nums(right) - isWin(nums, left, right - 1)
      Math.max(leftScore, rightScore)
    }
  }

  def main(args: Array[String]): Unit = {
    val nums = Array(1, 5, 233, 7)
    val nums01 = Array(1, 5, 2)
    val rs = PredictTheWinner(nums01)
    println(rs)
  }
}
