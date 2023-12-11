package main.scala

object NumberLongestIncreasingSubSeq {
  def findNumberOfLIS(nums: Array[Int]): Int = {
    val sorted = nums.sortWith((v1, v2) => v1 > v2)
    if (sorted.zip(nums).exists(v => v._1 != v._2) && sorted.distinct.length != 1) {
      cal1(nums, 1, 1)
    } else nums.length
  }

  def cal1(nums: Array[Int], count: Int, length: Int): Int = {
    val rs = cal(nums, count, length)
    val maxCount = rs._1
    val maxLength = rs._2
    println(s"maxcount ${maxCount}, maxLength ${maxLength}")
    if (maxLength == nums.length) maxCount
    else if (maxLength <= nums.tail.length) cal1(nums.tail, maxCount, maxLength)
    else count
  }

  def cal(nums: Array[Int], maxCount: Int, maxLength: Int): (Int, Int) = {
    val rs = nums.tail.zipWithIndex.foldLeft((1, 1, nums.head, Map.empty[Int, Int]))((tuple, v) => {
      val map = tuple._4
      val prevValue = tuple._3
      val currentValue = v._1
      val indexOfNum = v._2 + 1

      val rs = if (currentValue > prevValue) {
        (tuple._1, tuple._2 + 1, currentValue, map)
      } else if (currentValue == prevValue) {
        val mapAfterCal = if (map.keys.exists(v => v == currentValue)) {
          val v = map(currentValue) + 1
          map ++ Map(currentValue -> v)
        } else map ++ Map(currentValue -> 2)
        val count = mapAfterCal(currentValue)
        (tuple._1 + count, tuple._2, currentValue, mapAfterCal)
      } else {

        val maxValue = if (currentValue == prevValue) {
          val mapAfterCal = if (map.keys.exists(v => v == currentValue)) {
            val v = map(currentValue) + 1
            map ++ Map(currentValue -> v)
          } else map ++ Map(currentValue -> 2)
          (currentValue, mapAfterCal)
        } else (prevValue, map)

        val c = indexOfNum - 2
        if (c >= 0 && currentValue > nums(c)) {
          (tuple._1 + maxValue._2(currentValue), tuple._2, maxValue._1, maxValue._2)
        } else (tuple._1, tuple._2, maxValue._1, maxValue._2)
      }
      rs
    })
    val currCount = rs._1
    val currLength = rs._2
    println(s"currCount ${currCount}, ${currLength}")
    if (currLength == maxLength) (maxCount + currCount, maxLength)
    else if (currLength > maxLength) (currCount, currLength)
    else (maxCount, maxLength)
  }

  def main(args: Array[String]): Unit = {
    val array = Array(1, 1, 1, 2, 2, 2, 3, 3, 3)
    val array01 = Array(2, 2, 2, 2, 2)
    val array02 = Array(2, 2, 2, 2, 2, 3, 3, 3, 3)
    val rs = findNumberOfLIS(array)
    println(rs)
  }
}
