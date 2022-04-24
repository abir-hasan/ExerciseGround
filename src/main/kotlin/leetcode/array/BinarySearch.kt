package leetcode.array

/**
 * Created By Abir Hasan on 24-April-22
 * Problem: Binary Search
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-search/
 */

// To better visualize, see the array diagram in : https://www.geeksforgeeks.org/binary-search/
fun search(nums: IntArray, target: Int): Int {
    var firstIndex = 0
    var lastIndex = nums.size - 1
    // O(log n) solution
    for (i in 0..nums.size / 2) {
        val midIndex = (firstIndex + lastIndex) / 2
        if (target == nums[midIndex]) {
            return midIndex
        } else if (target < nums[midIndex]) {
            lastIndex = midIndex - 1
        } else {
            firstIndex = midIndex + 1
        }
    }
    return -1
}

fun main() {
    val res = search(intArrayOf(-1, 0, 3, 5, 9, 12), 9)
    println("index: $res")
}