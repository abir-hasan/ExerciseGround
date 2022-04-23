package leetcode

/**
 * Created By Abir Hasan on 23-April-22
 * Problem: Pascal's Triangle
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/pascals-triangle/
 */

fun generate(numRows: Int): List<List<Int>> {
    var tempList = arrayListOf<Int>()
    val pascalsList = arrayListOf<List<Int>>()
    for (i in 0 until numRows) {
        val list = arrayListOf<Int>()
        // If it's the first item in the list then it can only have one in it
        if (i == 0) {
            list.add(1)
        } else {
            // This loops needs to run from 0 to at least previous list's last index
            for (j in 0 until i + 1) {
                // From second row of pascals triangle, it's first and last element in the list is 1
                // Other elements can be found from the previous rows two adjacent items sum
                if (j == 0 || j == i) {
                    list.add(1)
                } else {
                    val item = tempList[j - 1] + tempList[j]
                    list.add(item)
                }
            }
        }
        tempList = list
        pascalsList.add(list)
    }
    return pascalsList
}

fun main() {
    val res = generate(5)
    println(res)
}