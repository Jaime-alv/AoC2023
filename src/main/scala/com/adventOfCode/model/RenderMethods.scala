package com.adventOfCode.model

import com.adventOfCode.configuration.Constants

trait RenderMethods extends CalculatePuzzleAnswer {
  def renderPartOne(inputValues: Array[String]): String = {
    val result = unpack(calculate_part_one(inputValues))
    val msg    = s"${Constants.renderFirst} $result"
    msg
  }

  def renderPartTwo(inputValues: Array[String]): String = {
    val result = unpack(calculate_part_two(inputValues))
    val msg    = s"${Constants.renderSecond} $result"
    msg
  }

  private def unpack(result: Option[Int]): String = {
    result.getOrElse("Not Implemented").toString()
  }

}
