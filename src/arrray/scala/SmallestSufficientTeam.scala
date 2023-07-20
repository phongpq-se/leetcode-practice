package arrray.scala

import scala.util.control.Breaks.{break, breakable}

object SmallestSufficientTeam {

  def smallestSufficientTeam01(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val set = people.zipWithIndex.toSet
    val arrayRs = scala.collection.mutable.ArrayBuffer.empty[Int]
    breakable {
      for (i <- Range(1, people.length)) yield {
        val rs = set.subsets(i).find(v => req_skills.diff(v.flatMap(_._1).toSeq).isEmpty)
        if (rs.nonEmpty) {
          rs.get.map(_._2).toArray.foreach(v => println(v))
          arrayRs ++= rs.get.map(_._2).toArray
          break()
        }
      }
    }
    arrayRs.toArray
  }

  def smallestSufficientTeam(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val set = people.zipWithIndex.toSet
    val arrayRs = scala.collection.mutable.ArrayBuffer.empty[Int]
    var flag = false
    (1 to people.size).iterator.takeWhile(_ => !flag).foreach(i => {
      val rs = set.subsets(i).find(v => req_skills.diff(v.flatMap(_._1).toSeq).isEmpty)
      if (rs.nonEmpty) {
        arrayRs ++= rs.get.map(_._2).toArray
        flag = true
      }
    })
    arrayRs.toArray
  }

  def smallestSufficientTeam04(req_skills: Array[String], people: List[List[String]]): Array[Int] = {
    val map = req_skills.map(v => (v, AnyRef)).toMap

    people.foreach(v => {
      v
    })
    val set = people.zipWithIndex.toSet
    val arrayRs = scala.collection.mutable.ArrayBuffer.empty[Int]
    breakable {
      for (i <- Range(1, people.length)) yield {
        val rs = set.subsets(i).find(v => req_skills.diff(v.flatMap(_._1).toSeq).isEmpty)
        if (rs.nonEmpty) {
          rs.get.map(_._2).toArray.foreach(v => println(v))
          arrayRs ++= rs.get.map(_._2).toArray
          break()
        }
      }
    }
    arrayRs.toArray
  }

  def smallestSufficientTeam03(req_skills: Array[String], people: List[List[String]]): Unit = {
    people.zipWithIndex.toSet.subsets().toStream.filter(v => {
      req_skills.diff(v.flatMap(_._1).toSeq).isEmpty
    }).minBy(_.size).map(_._2).toArray
  }

  def main(args: Array[String]): Unit = {
    val reqSkill = Array("cpp", "python", "javascript", "kotlin", "ruby", "r", "c", "rust", "vb")
    val people = List(
      List("cpp", "c", "rust"),
      List("cpp", "python", "javascript", "c", "r", "rust"),
      List("cpp", "python", "javascript", "c", "r", "vb"),
      List("cpp", "python", "javascript", "ruby", "kotlin", "r", "c", "rust", "vb"),
      List("cpp", "python", "javascript", "kotlin", "ruby", "r", "c", "rust", "vb"),
      List("python", "r"),
      List("cpp", "python", "javascript", "ruby", "kotlin", "r", "c", "rust", "vb"),
      List("cpp", "python", "javascript", "r", "c", "rust"),
      List("cpp", "javascript", "rust", "vb"),
      List("kotlin", "ruby", "c", "vb"),
      List("cpp", "python", "kotlin", "ruby", "rust", "vb"),
      List("ruby", "c", "r", "rust"),
      List("python", "javascript"),
      List("javascript", "ruby", "rust"),
      List("python", "javascript", "ruby", "c", "r", "rust", "vb"),
      List("cpp", "javascript", "kotlin", "r", "c", "vb"),
      List("c", "rust"),
      List("cpp", "kotlin", "ruby", "c", "r", "rust", "vb"),
      List("cpp", "python", "javascript", "ruby", "kotlin", "rust"),
      List("cpp", "javascript", "ruby"),
      List("vb")
    )
    //    var sum = 0
    //    (0 to 1000).iterator.takeWhile(_ => sum < 5).foreach(i => {
    //      println(i)
    //      sum += i
    //    })

    smallestSufficientTeam(reqSkill, people).foreach(v => println(v))
  }
}
