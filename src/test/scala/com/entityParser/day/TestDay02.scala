package com.entityParser.day

import org.scalatest.funsuite.AnyFunSuite
import com.adventOfCode.service.Day02Impl
import com.adventOfCode.enum.Colour.Colour
import com.adventOfCode.enum
import com.adventOfCode.model.Round

class TestDay02 extends AnyFunSuite {
  val exampleColourSet: Array[String] = Array(
    "3 blue",
    "4 red",
    "1 red",
    "2 green",
    "6 blue",
    "2 green"
  )

  val roundExample: String = "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"

  val roundGame: Round = new Round(
    id = 1,
    red = Array(4, 1),
    blue = Array(3, 6),
    green = Array(2, 2)
  )

  val gameRoundExample: Array[String] = Array(
    "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
    "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
    "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
    "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
    "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
  )

  test("Cast String to int in game Round") {
    val example: String = "Game 1"
    assert(Day02Impl.getRoundNumber(example).equals(Some(1)))
  }

  test("Fail cast string to int") {
    assert(Day02Impl.getRoundNumber("Game a").equals(None))
  }

  test("Explode Sets") {
    val set: String = "3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green"
    val expectedSet: Array[String] = Array(
      "3 blue",
      "4 red",
      "1 red",
      "2 green",
      "6 blue",
      "2 green"
    )
    assertResult(expectedSet)(Day02Impl.explodeSetsIntoColours(set))
  }

  test("Get Colour red values") {
    val set: Array[String] = exampleColourSet.clone()
    val expected: Array[Int] = Array(
      4,
      1
    )
    val red: Colour = enum.Colour.red
    assertResult(expected)(Day02Impl.filterByColour(set, red))
  }

  test("Get Colour blue values with weird combinations") {
    val set: Array[String] = Array(
      "3 blue",
      "4 red",
      "1 red",
      "2 green",
      "6 blue",
      "2 green",
      "a blue",
      "2d blue"
    )
    val expected: Array[Int] = Array(
      3,
      6
    )
    assertResult(expected)(Day02Impl.filterByColour(set, enum.Colour.blue))
  }

  test("Create Round object from string") {
    assertResult(roundGame.getId)(Day02Impl.explodeGameSet(roundExample).getId())
    assertResult(roundGame.red)(Day02Impl.explodeGameSet(roundExample).red)
    assertResult(roundGame.blue)(Day02Impl.explodeGameSet(roundExample).blue)
    assertResult(roundGame.green)(Day02Impl.explodeGameSet(roundExample).green)
  }

  test("Max item in round") {
    assertResult(6)(roundGame.getMaxValueForColour(enum.Colour.blue))
    assertResult(4)(roundGame.getMaxValueForColour(enum.Colour.red))
    assertResult(2)(roundGame.getMaxValueForColour(enum.Colour.green))
  }

  test("Compute example rounds") {
    assertResult(8)(Day02Impl.sumRounds(gameRoundExample))
  }
}
