package com.adventOfCode

import com.typesafe.scalalogging.Logger
import com.typesafe.scalalogging.LazyLogging
import com.adventOfCode.configuration.TargetDay
import com.adventOfCode.model.day.Day01Trebuchet
import com.adventOfCode.controller.Driver
import java.io.FileNotFoundException

object Main extends LazyLogging {
  def main(args: Array[String]): Unit = {

    val targetDay = new TargetDay(2)
    val lines = targetDay.readFile()
    val realLines: Array[String] = lines.get
    val puzzle = Driver.getPuzzleSolution(targetDay)
    logger.info(puzzle.renderPartOne(realLines))
    logger.info(puzzle.renderPartTwo(realLines))
  }
}

