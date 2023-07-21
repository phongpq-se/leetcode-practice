package arrray.scala

import java.lang

/*

We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents
 its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet,
the smaller one will explode. If both are the same size, both will explode.
Two asteroids moving in the same direction will never meet.
Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.

*/

object AsteroidCollision {

  def asteroidCollision(asteroids: Array[Int]): Array[Int] = {
    asteroids.tail.foldLeft(Array(asteroids.head))((ats, v) => {
      explodeAsteroidWhenMeetValue(ats, v)
    })
  }

  def explodeAsteroidWhenMeetValue(asteroids: Array[Int], value: Int): Array[Int] = {
    if (asteroids.nonEmpty) (value, asteroids.last) match {
      case (value, last) if value > 0 && last < 0 => asteroids :+ value
      case (value, last) if value < 0 && last > 0 && Math.abs(value) == Math.abs(last) =>
        asteroids.dropRight(1)
      case (value, last) if value < 0 && last > 0 && Math.abs(value) > Math.abs(asteroids.last) =>
        explodeAsteroidWhenMeetValue(asteroids.dropRight(1), value)
      case (value, last) if value < 0 && last > 0 => asteroids
      case _ => asteroids :+ value
    } else Array(value)
  }

  def main(args: Array[String]): Unit = {
    val input = Array(5, 10, -5)
    val input01 = Array(5, -5)
    val input02 = Array(10, 2, -5)
    val input03 = Array(-2, -1, 1, 2)
    asteroidCollision(input03).foreach(v => println(v))
  }
}
