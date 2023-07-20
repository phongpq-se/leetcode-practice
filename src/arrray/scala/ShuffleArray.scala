package arrray.scala

/*
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Input: nums = [2,5,1,3,4,7], n = 3
Output: [2,3,5,4,1,7]
Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
* */
object ShuffleArray {
  def shuffle(nums: Array[Int], n: Int): Array[Int] = {
    val rs = new Array[Int](nums.length)
    var i = 0
    while (i < nums.length) {
      rs(i) = nums(i / 2)
      rs(i + 1) = nums(n + (i / 2))
      i = i + 2
    }
    rs
  }

  def main(args: Array[String]): Unit = {
    val n = 3
    val array = Array(2, 5, 1, 3, 4, 7)
    //    array(1) = 100
    //    array.foreach(v => println(v))
    val rs = shuffle(array, n)
    rs.foreach(v => println(v))
  }
}
