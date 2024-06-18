package com.adventOfCode.controller

import com.adventOfCode.model.CalculatePuzzleAnswer
import com.adventOfCode.model.day.Day01Trebuchet
import com.adventOfCode.model.RenderMethods

object Driver {
  def getPuzzleSolution(value: Int): RenderMethods = {
    value match {
        case 1 => Day01Trebuchet 
    } 
  }
}
