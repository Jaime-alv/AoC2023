package com.adventOfCode.configuration

import java.io.FileNotFoundException

class TargetDay(day: Int, year: Int, mainFolder: String, subFolder: String, fileName: String) {
  private val _day: String      = subFolder;
  private val _folder: String   = mainFolder
  private val _target: Int      = day;
  private val _year: Int        = year;
  private val _fileName: String = fileName;

  def display(): String = {
    val msg: String = s"Target folder \"${getFullPath()}\""
    msg
  }

  def this(day: Int) = {
    this(day = day, year = 2023, mainFolder = "./resources", subFolder = "day", fileName = "input")
  }

  def target(): Int = {
    this._target
  }

  def getYear(): Int = {
    this._year
  }

  def getTargetDay(): String = {
    "%02d".format(this._target)

  }

  def getFullPath(): String = {
    val folder: String = f"${this._folder}/${this._day}/${getTargetDay()}"
    folder
  }

  def getFilePath(): String = {
    val folder = getFullPath()
    s"${folder}/${this._fileName}"
  }

  private def split_day(value: String): String = {
    val splittedStringDay: String = value.replace("_", " ")
    splittedStringDay
  }

  def readFile(): Option[Iterator[String]] = {
    try {
      val lines = scala.io.Source.fromFile(getFilePath()).getLines()
      Some(lines)
    } catch {
      case ex: FileNotFoundException => None
    }

  }
}
