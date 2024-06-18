package com.adventOfCode.service

object Day01Impl {


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

  def replaceIteratorValues(inputIterator: Iterator[String]): Iterator[String] = {
    inputIterator.map(filterDigitsWithNames)
  }

  def filterDigitsWithNames(value: String): String = {
    value
      .replaceAll("one", replaceNumberWithDigit("one"))
      .replaceAll("two", replaceNumberWithDigit("two"))
      .replaceAll("three", replaceNumberWithDigit("three"))
      .replaceAll("four", replaceNumberWithDigit("four"))
      .replaceAll("five", replaceNumberWithDigit("five"))
      .replaceAll("six", replaceNumberWithDigit("six"))
      .replaceAll("seven", replaceNumberWithDigit("seven"))
      .replaceAll("eight", replaceNumberWithDigit("eight"))
      .replaceAll("nine", replaceNumberWithDigit("nine"))
  }

  def replaceNumberWithDigit(number: String): String = {
    val firstLetter = number.charAt(0)
    f"${firstLetter}${castNameToString(number)}$number"
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
