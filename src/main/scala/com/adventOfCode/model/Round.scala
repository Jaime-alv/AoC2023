package com.adventOfCode.model

import Colour.Colour
import com.adventOfCode.enum

class Round(id: Int, val red: Array[Int], val blue: Array[Int], val green: Array[Int]) {
  private val maxAllowRed: Int   = 12
  private val maxAllowGreen: Int = 13
  private val maxAllowBlue: Int  = 14

  def getMaxValueForColour(colour: Colour): Int = {
    colour match {
      case Colour.blue  => blue.max
      case Colour.red   => red.max
      case Colour.green => green.max
    }
  }

  def getId(): Int = {
    id
  }

  def isBelowLimits(): Boolean = {
    this.getMaxValueForColour(colour = Colour.red) <= maxAllowRed && this.getMaxValueForColour(
      Colour.blue
    ) <= maxAllowBlue && this.getMaxValueForColour(Colour.green) <= maxAllowGreen
  }
}
