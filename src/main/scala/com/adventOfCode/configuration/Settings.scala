package com.adventOfCode.configuration

class Settings(inputDir: String = "input", outDir: String = "output") {
  private val _inputDir: String = inputDir
  private val _outDir: String   = outDir

  def this(inputDir: String, outDir: String, settingsFile: String) = {
    this(inputDir, outDir)
  }

//   def this() = {
//     this("./inputDir", "./outDir")
//   }

  def display(): String = {
    val iDir: String = s"Input directory = ${this._inputDir}"
    val oDir: String = s"Output directory = ${this._outDir}"
    val msg: String  = s"$iDir\n$oDir"
    msg
  }

  def getInputDir(): String = {
    this._inputDir
  }

  def getOutputDir(): String = {
    this._outDir
  }
}
