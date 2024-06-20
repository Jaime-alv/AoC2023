package com.adventOfCode.service

import com.adventOfCode.model.Colour.Colour
import com.adventOfCode.enum
import com.adventOfCode.model.Round
import com.adventOfCode.model.Colour

object Day02Impl {

  val maxRed: Int   = 12
  val maxGreen: Int = 13
  val maxBlue: Int  = 14

  /** Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
    *
    * @param inputValue
    * @return
    */
  def explodeGameSet(gameSet: String): Round = {
    val explodeSet: Array[String] = gameSet.split(":")
    val gameRound: Option[Int]    = getRoundNumber(explodeSet.head)
    val colourSet: Array[String]  = explodeSetsIntoColours(explodeSet.last)
    val redColours: Array[Int]    = filterByColour(colourSet, Colour.red)
    val blueColours: Array[Int]   = filterByColour(colourSet, Colour.blue)
    val greenColours: Array[Int]  = filterByColour(colourSet, Colour.green)
    val game = new Round(gameRound.get, red = redColours, blue = blueColours, green = greenColours)
    game
  }

  def getRoundNumber(gameSlice: String): Option[Int] = {
    gameSlice.split(" ").last.trim().toIntOption
  }

  def filterByColour(set: Array[String], colour: Colour): Array[Int] = {
    set
      .filter(_.contains(colour.toString()))
      .map(x => x.split(" ").head.toIntOption)
      .filter(_.isDefined)
      .map(_.get)
  }

  def explodeSetsIntoColours(gameSlice: String): Array[String] = {
    gameSlice.split(";").flatMap(sets => sets.split(",")).map(item => item.trim())
  }

  def gameRoundIsBelowLimits(round: Round): Boolean = {
    round.getMaxValueForColour(colour = Colour.red) <= maxRed && round.getMaxValueForColour(
      Colour.blue
    ) <= maxBlue && round.getMaxValueForColour(Colour.green) <= maxGreen
  }

  def addRounds(games: Iterator[Round]): Int = {
    games.filter(game => gameRoundIsBelowLimits(game)).map(round => round.getId()).reduce(_ + _)
  }

  def splitInputInRounds(inputValue: Array[String]): Iterator[Round] = {
    inputValue.map(line => explodeGameSet(line)).toIterator
  }

  def sumRounds(inputValue: Array[String]): Int = {
    addRounds(splitInputInRounds(inputValue))
  }

  def computeRoundPower(round: Round): Int = {
    val maxRed   = round.getMaxValueForColour(Colour.red)
    val maxBlue  = round.getMaxValueForColour(Colour.blue)
    val maxGreen = round.getMaxValueForColour(Colour.green)
    maxRed * maxBlue * maxGreen
  }

  def computeGamePower(inputValue: Array[String]): Int = {
    inputValue
      .map(explodeGameSet)
      .map(computeRoundPower)
      .reduce(_ + _)
  }
}
