/**
 * Created By Abir Hasan on 29-Sep-21
 * Problem: Sorted Squared Array
 * Category: Arrays
 */

fun sortedSquaredArray(array: List<Int>): List<Int> {
    // Write your code here.
    return array.map { it * it }.sorted()
}

fun main() {
    println(sortedSquaredArray(listOf(1, 2, 3, 8, 5)))
    println(sortedSquaredArray(listOf(-2, -1)))
}