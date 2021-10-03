/**
 * Created By Abir Hasan on 03-Oct-21
 * Problem: Three Number Sum
 * Category: Arrays
 * L - 2
 */

fun threeNumberSum(array: MutableList<Int>, targetSum: Int): List<List<Int>> {
    // Write your code here
    val finalList = mutableListOf<List<Int>>()
    val sortedArray = array.sorted()
    for ((i, firstItem) in sortedArray.withIndex()) {
        val secondIdx = i + 1
        for (j in secondIdx until sortedArray.size) {
            val thirdIdx = j + 1
            val secondItem = sortedArray[j]
            for (k in thirdIdx until sortedArray.size) {
                val thirdItem = sortedArray[k]
                if ((firstItem + secondItem + thirdItem) == targetSum) {
                    finalList.add(listOf(firstItem, secondItem, thirdItem).sorted())
                }
            }
        }
    }
    return finalList
}