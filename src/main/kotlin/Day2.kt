package zebra.zyber

import java.io.File

fun main() {
    val filePath = "src/main/resources/day2.txt"
    val listOfList = mutableListOf<List<Int>>()
    File(filePath).useLines { lines ->
        lines.forEach { line ->
            listOfList.addLast(line.split(" ").map { it.toInt() })
        }
    }

    var safe = 0

    listOfList.forEach { list ->
        val isIncreasing = list.zipWithNext().all { (a, b) -> b - a in 1..3 }
        val isDecreasing = list.zipWithNext().all { (a, b) -> a - b in 1..3 }
        if (isIncreasing || isDecreasing) {
            safe++
        }
    }
    println("result day2 - part1: $safe")

}