package leetcode.array

/**
 * Created By Abir Hasan on 23-April-22
 * Problem: Search a 2D Matrix
 * Category: Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/search-a-2d-matrix/
 */

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    var searchRow = 0
    for (i in matrix.indices) {
        val currentRow = matrix[i]
        val lastItem = currentRow[currentRow.size - 1]
        if (target <= lastItem) {
            if (target == lastItem) return true
            searchRow = i
            break
        }
    }
    val search = matrix[searchRow]
    for (i in search.indices) {
        if (search[i] == target)
            return true
    }
    return false
}

fun main() {
    //val res = searchMatrix(arrayOf(intArrayOf(1)), 1)
    //val res = searchMatrix(arrayOf(intArrayOf(1), intArrayOf(3)), 3)
    val res = searchMatrix(
        arrayOf(
            intArrayOf(1, 3, 5, 7), intArrayOf(10, 11, 16, 20), intArrayOf(23, 30, 34, 60)
        ), 13
    )
    println(res)
}