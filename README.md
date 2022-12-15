## Advent of Code 2022

[![run unit tests](https://github.com/hallieswan/advent-of-code-2022/actions/workflows/run-tests.yml/badge.svg)](https://github.com/hallieswan/advent-of-code-2022/actions/workflows/run-tests.yml)

### Introduction

[Advent of Code](https://adventofcode.com/2022/about)

> Advent of Code is an Advent calendar of small programming puzzles 
> for a variety of skill sets and skill levels that can be solved 
> in any programming language you like.

### Repository Structure

This repository's structure is based on 
[shpikat/advent-of-code-2018](https://github.com/shpikat/advent-of-code-2018).
 
I'm planning to include unit tests and a GitHub Action to run those tests.


### Things I Learned

- In Day 11 part 2, we will generate very large numbers. I initially 
tried using a BigInteger to store the values, but that wasn't effective. After 
looking into what [others](https://www.reddit.com/r/adventofcode/comments/zifqmh/2022_day_11_solutions/) 
[had done](https://github.com/romamik/aoc2022/tree/master/src/day11#part-2), 
I found that most people solved the question using [modular arithmetic](https://en.wikipedia.org/wiki/Modular_arithmetic), 
specifically by applying the [Chinese Remainder Theorem](http://homepages.math.uic.edu/~leon/mcs425-s08/handouts/chinese_remainder.pdf),
i.e. calculate a [least common multiple](https://en.wikipedia.org/wiki/Least_common_multiple)
of all the monkey's divisors, then modulo each item's worry level by that LCM.