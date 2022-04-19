package leetcode

/**
 * Created By Abir Hasan on 19-April-22
 * Problem: Contains Duplicate
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/contains-duplicate/
 */

fun containsDuplicate(nums: IntArray): Boolean {
    val itemSet = mutableSetOf<Int>()
    nums.forEach {
        if (itemSet.contains(it))
            return true
        else
            itemSet.add(it)
    }
    return false
}

fun main() {
    //val result = containsDuplicate(intArrayOf(1,1,1,3,3,4,3,2,4,2))
    val result = containsDuplicate(intArrayOf(1, 2, 3, 4))
    println(result)
}