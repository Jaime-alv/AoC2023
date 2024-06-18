package com.adventOfCode.configuration

import org.scalatest.funsuite.AnyFunSuite
import com.adventOfCode.configuration.TargetDay

class TestTargetDay extends AnyFunSuite {
  test("New class") {
    val day = new TargetDay(1);
    assert(day.getTargetDay() == "01")
    val ten = new TargetDay(10)
    assert(ten.getTargetDay().equals("10"))
  }

  test("Get File path") {
    val day = new TargetDay(2)
    val path = "./resources/day/02"
    assert(day.getFullPath() == path)
  }
}
