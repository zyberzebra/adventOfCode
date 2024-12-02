package zebra.zyber

import java.io.File

fun main() {
    val filePath = "src/main/resources/day2.txt"
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
}