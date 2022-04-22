package leetcode

/**
 * Created By Abir Hasan on 22-April-22
 * Problem: Reshape The Matrix
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reshape-the-matrix/
 */

fun matrixReshape(mat: Array<IntArray>, r: Int, c: Int): Array<IntArray> {
    val m = mat.size
    val n = mat[0].size
    val totalItem = m * n
    // If the new shape is not possible then return the original matrix
    if (totalItem != (r * c)) return mat

    // Create thew new shaped Array to return
    val reshapedMatrix = Array(r) { IntArray(c) }

    var tempArray = arrayListOf<Int>()
    var count = 1
    var reshapedRowCount = 0
    for (element in mat) {
        for (j in element.indices) {
            if (count % c == 0) {
                tempArray.add(element[j])
                reshapedMatrix.set(reshapedRowCount, tempArray.toIntArray())
                reshapedRowCount += 1
                tempArray = arrayListOf()
            } else {
                tempArray.add(element[j])
            }
            count += 1
        }
    }
    return reshapedMatrix
}

fun main() {
    val res = matrixReshape(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
        4,
        1
    )
    /*val res = matrixReshape(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
        1,
        4
    )*/

    // This case will return the original matrix
    /*val res = matrixReshape(
        arrayOf(intArrayOf(1, 2), intArrayOf(3, 4)),
        2,
        4
    )*/
    res.forEach {
        println()
        it.forEach(::print)
    }
}