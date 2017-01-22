package challenge299.intermediate

import challenge299.intermediate.Directions.*

class Solution299 {

  fun intersections(maze: List<CharArray>): Int {
    var count = 0
    maze.forEachIndexed { x, line ->
      line.forEachIndexed { y, char ->
        if (char.isDot() && hasValidDirections(maze, x, y)) count++
      }
    }
    return count
  }

  fun hasValidDirections(maze: List<CharArray>, x: Int, y: Int): Boolean {
    return listOf(
      TOP.direction(x, y),
      LEFT.direction(x, y),
      RIGHT.direction(x, y),
      BOTTOM.direction(x, y)
    ).filter { maze[it.first][it.second].isDot() }.size >= 3
  }
}

enum class Directions {
  TOP {
    override fun direction(x: Int, y: Int) = x to (y - 1)
  },
  LEFT {
    override fun direction(x: Int, y: Int) = (x - 1) to (y)
  },
  RIGHT {
    override fun direction(x: Int, y: Int) = (x + 1) to (y)
  },
  BOTTOM {
    override fun direction(x: Int, y: Int) = x to (y + 1)
  };

  abstract fun direction(x: Int, y: Int): Pair<Int, Int>
}

fun Char.isDot() = this == '.'