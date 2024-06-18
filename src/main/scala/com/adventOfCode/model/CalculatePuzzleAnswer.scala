package com.adventOfCode.model

trait CalculatePuzzleAnswer {
  def calculate_part_one(input: Iterator[String]): Int;

  def calculate_part_two(input: Iterator[String]): Option[Int];
}
