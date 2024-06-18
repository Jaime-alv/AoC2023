package com.adventOfCode.day

import org.scalatest.funsuite.AnyFunSuite
import com.adventOfCode.model.day.Day01Trebuchet
import com.adventOfCode.service.Day01Impl

class TestDay01 extends AnyFunSuite {
  val examplePartOne: Array[String] =
    Array("1abc2", "pqr3stu8vwx", "a1b2c3d4e5f", "treb7uchet")

  val examplePartTwo: Array[String] = Array(
    "two1nine",
    "eightwothree",
    "abcone2threexyz",
    "xtwone3four",
    "4nineeightseven2",
    "zoneight234",
    "7pqrstsixteen"
  )

  test("Filter digits") {
    assert("12" == Day01Impl.filterDigits("1abc2"))
    assert("38" == Day01Impl.filterDigits("pqr3stu8vwx"))
    assert("12345" == Day01Impl.filterDigits("a1b2c3d4e5f"))
    assert("7" == Day01Impl.filterDigits("treb7uchet"))
  }

  test("Filter empty String") {
    assert(Day01Impl.filterDigits("avcd").equals(""))
  }

  test("Cast to Int") {
    assert(Day01Impl.castToInt("a").equals(None))
    assert(Day01Impl.castToInt("2").get.equals(2))
  }

  test("Get first and last element") {
    assert(Day01Impl.getFirstAndLast("12345") == "15")
  }

  test("Reduce sum") {
    val local: Iterator[String] = examplePartOne.clone().toIterator
    assert(Day01Trebuchet.calculate_part_one(local) == 142)
  }

  test("sum elements") {
    val local: Iterator[String] = examplePartOne.clone().toIterator
    assert(Day01Impl.sumElements(local) == 142)
  }

  test("Cast string to lowercase") {
    assert(Day01Impl.castToLowerCase("BaRcOde").equals("barcode"))
  }

  test("Cast string with numbers") {
    assert(Day01Impl.castToLowerCase("4EverY0un6").equals("4every0un6"))
  }

  test("Replace number names for numbers") {
    assert(Day01Impl.filterDigitsWithNames("eightwothree") == "e8eight2twot3three")
  }

  test("Replace characters in a weird way") {
    assert(Day01Impl.replaceNumberWithDigit("one").equals("o1one"))
    assert(Day01Impl.replaceNumberWithDigit("three").equals("t3three"))
  }

  test("part 2 solution") {
    val values: Iterator[String] = examplePartTwo.clone().toIterator
    val newValues = Day01Impl.replaceIteratorValues(values)
    assert(Day01Impl.sumElements(newValues).equals(281))
  }
}
