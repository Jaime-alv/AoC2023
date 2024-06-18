package com.adventOfCode

import com.typesafe.scalalogging.Logger
import com.typesafe.scalalogging.LazyLogging
import com.adventOfCode.configuration.Settings
import com.adventOfCode.enum.TargetDayEnum
import com.adventOfCode.configuration.TargetDay
import com.adventOfCode.model.day.Day01Trebuchet
import com.adventOfCode.controller.Driver
import java.io.FileNotFoundException

object Main extends LazyLogging {
  def main(args: Array[String]): Unit = {

    val day1 = new TargetDay(1)
    val lines = day1.readFile()
    val realLines: Iterator[String] = lines.get
    val puzzle = Driver.getPuzzle(day1.target())
    // val targetDay = new Day01Trebuchet
    logger.info(puzzle.calculate_part_one(realLines.toArray.clone().toIterator).toString())
    logger.info(puzzle.calculate_part_two(realLines).get.toString())
  }
}

