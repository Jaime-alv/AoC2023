package com.adventOfCode.controller

import com.adventOfCode.model.CalculatePuzzleAnswer
import com.adventOfCode.model.day.Day01Trebuchet

object Driver {
  def getPuzzle(value: Int): CalculatePuzzleAnswer = {
    value match {
        case 1 => Day01Trebuchet 
    } 
  }
}
