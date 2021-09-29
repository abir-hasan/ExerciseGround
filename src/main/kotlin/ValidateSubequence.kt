/**
 * Created By Abir Hasan on 29-Sep-21
 * Problem: Validate Subsequence
 * Category: Arrays
 */

fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {
    var lastFoundIndex = 0
    var foundItemsCount = 0
    if (sequence.size > array.size) return false
    for (item in sequence) {
        for (j in lastFoundIndex until array.size) {
            if (item == array[j]) {
                lastFoundIndex = j + 1
                foundItemsCount++
                break
            } else if (j == array.size - 1) {
                // Went through the array but didn't find the element
                // It can't be a subsequence of the array
                // Also works without this logic, but it shortens the loop
                return false
            }
        }
    }
    return foundItemsCount == sequence.size
}

fun main() {
    val result = isValidSubsequence(
        listOf(5, 1, 22, 25, 6, -1, 8, 10),
        listOf(5, 1, 22, 22, 6, -1, 8, 10)
    )
    println(result)
}


fun isValidSubsequenceAnotherSolution(array: List<Int>, sequence: List<Int>): Boolean {
    // Write your code here.
    var seqId = 0
    for (value in array) {
        if (seqId == sequence.size) break
        if (sequence[seqId] == value) seqId++
    }
    return seqId == sequence.size
}


