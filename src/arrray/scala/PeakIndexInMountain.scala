package arrray.scala

object PeakIndexInMountain {

  def peakIndexInMountainArray(arr: Array[Int]): Int = {
    binarySearch(arr, 0, arr.length - 1)
  }

  def binarySearch(arr: Array[Int], min: Int, max: Int): Int = {
    val mid = ((min + max) / 2).floor.toInt
    if (min == max) min
    else if (arr(mid) > arr(mid + 1) && arr(mid) > arr(mid - 1)) mid
    else {
      if (arr(mid) > arr(mid - 1)) binarySearch(arr, mid + 1, max)
      else binarySearch(arr, mid, mid - 1)
    }
  }

  //  def binarySearch(arr: Array[Int], min: Int, max: Int): Int = {
  //    var index = 0
  //    while (min <= max) {
  //      var min = 0
  //      var max = arr.length - 1
  //      val mid = ((min + max) / 2).floor.toInt
  //      if (arr(mid) > arr(mid + 1) && arr(mid) > arr(mid - 1)) index = mid
  //      else {
  //        if (arr(mid) > arr(mid - 1)) max = mid - 1
  //        else min = mid + 1
  //      }
  //    }
  //    index
  //  }

  def main(args: Array[String]): Unit = {
    val arr = Array(0, 2, 1, 0)
    val arr01 = Array(3, 4, 5, 1)
    val arr02 = Array(3, 5, 3, 2, 0)
    val rs = peakIndexInMountainArray(arr02)
    println(rs)
  }
}
