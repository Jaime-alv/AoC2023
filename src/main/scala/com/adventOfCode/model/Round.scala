package com.adventOfCode.model

import com.adventOfCode.enum.Colour.Colour
import com.adventOfCode.enum

class Round(id: Int, val red: Array[Int], val blue: Array[Int], val green: Array[Int]) {
  def getMaxValueForColour(colour: Colour): Int = {
    colour match {
      case enum.Colour.blue  => blue.max
      case enum.Colour.red   => red.max
      case enum.Colour.green => green.max
    }
  }

  def getId(): Int = {
    id
  }
}
