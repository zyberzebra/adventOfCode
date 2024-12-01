package zebra.zyber

import java.io.File
import kotlin.math.absoluteValue

fun main() {


//    val list1 = "3,4,2,1,3,3".split(",").map { it.toInt() }.sorted()
//    val list2 = "4,3,5,3,9,3".split(",").map { it.toInt() }.sorted()
//

    val filePath = "src/main/resources/input.txt"

// Initialize two lists for the left and right numbers
    val list1 = mutableListOf<Int>()
    val list2 = mutableListOf<Int>()

// Read the file line by line
    File(filePath).useLines { lines ->
        lines.forEach { line ->
            // Split each line into two numbers and add to respective lists
            val parts = line.split("\\s+".toRegex())
            if (parts.size == 2) {
                list1.add(parts[0].toInt())
                list2.add(parts[1].toInt())
            }
        }
    }

    list1.sort()
    list2.sort()

    var sum = 0
    list1.forEachIndexed({ index, value ->
        val dist = value.minus(list2.get(index)).absoluteValue
        sum += dist
    })
    println("part1" + sum)

    val countedList = list2.groupingBy { it }.eachCount()
    val solutionPart2 = list1.map { countedList.getOrDefault(it, 0) * it }.sum()
    println("part2$solutionPart2")
}