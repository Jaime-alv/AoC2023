package com.adventOfCode.service

object Day01Impl {

  val numberNames: Array[String] = Array(
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine"
  )

  def filterDigits(value: String): String = {
    value.filter(x => x.isDigit)
  }

  def castToInt(value: String): Option[Int] = {
    value.toIntOption
  }

  def getFirstAndLast(value: String): String = {
    val first = value.substring(0, 1)
    val last  = value.reverse.substring(0, 1)
    s"$first$last"
  }

  def sumElements(elements: Iterator[String]): Int = {
    elements.map(filterDigits).map(getFirstAndLast).map(castToInt(_) getOrElse (0)).reduce(_ + _)
  }

  def castToLowerCase(input: String): String = {
    input.map(x =>
      try { x.toLower }
      catch { case ex: Exception => x }
    )
  }

  def filterDigitsWithNames(value: String): String = {
    value
      .replaceAll("one", "1")
      .replaceAll("two", "2")
      .replaceAll("three", "3")
      .replaceAll("four", "4")
      .replaceAll("five", "5")
      .replaceAll("six", "6")
      .replaceAll("seven", "7")
      .replaceAll("eight", "8")
      .replaceAll("nine", "9")
  }

  def castNameToString(number: String): Int = {
    number.toLowerCase match {
      case "one"   => 1
      case "two"   => 2
      case "three" => 3
      case "four"  => 4
      case "five"  => 5
      case "six"   => 6
      case "seven" => 7
      case "eight" => 8
      case "nine"  => 9
    }
  }
}
