package com.adventOfCode.model

import com.adventOfCode.configuration.Constants

trait RenderMethods extends CalculatePuzzleAnswer {
  def renderPartOne(inputValues: Array[String]): String = {
    val result = calculate_part_one(inputValues).toString()
    val msg    = s"${Constants.renderFirst} $result"
    msg
  }

  def renderPartTwo(inputValues: Array[String]): String = {
    val result = calculate_part_two(inputValues).getOrElse("Not Implemented").toString()
    val msg    = s"${Constants.renderSecond} $result"
    msg
  }

}
