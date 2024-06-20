package com.adventOfCode.model

trait RenderMethods extends CalculatePuzzleAnswer {
  val renderFirst: String  = "Part One result: "
  val renderSecond: String = "Part One result: "

  def renderPartOne(inputValues: Array[String]): String = {
    val result = unpack(calculate_part_one(inputValues))
    val msg    = s"${renderFirst} $result"
    msg
  }

  def renderPartTwo(inputValues: Array[String]): String = {
    val result = unpack(calculate_part_two(inputValues))
    val msg    = s"${renderSecond} $result"
    msg
  }

  private def unpack(result: Option[Int]): String = {
    try {
      result.getOrElse("Not Implemented").toString()
    } catch {
      case ex: NotImplementedError => "Not implemented"
    }
  }

}
