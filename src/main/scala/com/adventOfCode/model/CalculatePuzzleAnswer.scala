package com.adventOfCode.model

trait CalculatePuzzleAnswer {
  def calculate_part_one(input: Array[String]): Option[Int];

  def calculate_part_two(input: Array[String]): Option[Int];
}
