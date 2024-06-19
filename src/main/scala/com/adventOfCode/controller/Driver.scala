package com.adventOfCode.controller

import com.adventOfCode.model.CalculatePuzzleAnswer
import com.adventOfCode.model.day.Day01Trebuchet
import com.adventOfCode.model.RenderMethods
import com.adventOfCode.model.day.Day02CubeConundrum
import com.adventOfCode.configuration.TargetDay

object Driver {
  def getPuzzleSolution(targetDay: TargetDay): RenderMethods = {
    val value = targetDay.day()
    value match {
        case 1 => Day01Trebuchet 
        case 2 => Day02CubeConundrum
    } 
  }
}
