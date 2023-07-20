package arrray.scala

/*
Given an array of intervals intervals where intervals[i] = [starti, endi],
return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
* */
object NonOverlapping {
  def eraseOverlapIntervals(intervals: Array[Array[Int]]): Int = {
    val arr = intervals.sortWith((v1, v2) => v1(1) < v2(1))
    var maxFlag = arr.head(1)
    intervals.length - arr.tail.foldLeft(1)((count, v) => {
      if (v.head >= maxFlag) {
        maxFlag = v.last
        count + 1
      } else count
    })
  }

  def eraseOverlapIntervals1(intervals: Array[Array[Int]]): Int = {
    val arr = intervals.sortWith((v1, v2) => v1(1) < v2(1))
    var maxFlag = arr.head(1)
    val rs = arr.tail.filterNot(v => {
      if (v.head >= maxFlag) {
        maxFlag = v.last
        false
      } else true
    })
    intervals.length - (rs.length + 1)
  }

  def main(args: Array[String]): Unit = {
    val intervals = Array(Array(1, 2), Array(2, 3), Array(3, 4), Array(1, 3))
    val intervals01 = Array(Array(1, 2), Array(1, 2), Array(1, 2))
    val intervals02 = Array(Array(1, 2), Array(2, 3))
    val intervals03 = Array(Array(1, 100), Array(11, 22), Array(1, 11), Array(2, 12), Array(-5, -10))
    val intervals04 = Array(
      Array(40, 70),
      Array(56, 80),
      Array(63, 87),
      Array(-51, 39),
      Array(-74, 59),
      Array(38, 41),
      Array(-49, 17),
      Array(6, 57),
      Array(36, 85),
      Array(-73, 26),
      Array(-6, 70),
      Array(15, 70),
      Array(66, 78),
      Array(37, 87),
      Array(79, 96),
      Array(46, 97),
      Array(36, 49),
      Array(-58, 40),
      Array(-58, 52),
      Array(26, 83),
      Array(-27, 43),
      Array(15, 86),
      Array(11, 56),
      Array(23, 34),
      Array(-9, 73),
      Array(-95, -75),
      Array(2, 30),
      Array(-91, 26),
      Array(88, 89),
      Array(-83, -43)
    )
    // println("size " + intervals04.size)
    val rs = eraseOverlapIntervals(intervals04)
    println(rs)
  }
}
