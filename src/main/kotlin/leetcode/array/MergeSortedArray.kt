package leetcode.array

/**
 * Created By Abir Hasan on 20-April-22
 * Problem: Merge Sorted Arrays
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-sorted-array/
 */

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    for(i in 0 until n) {
        nums1[i+m] = nums2[i]
    }
    nums1.sort()
    //nums1.forEach { print(it) }
}

fun main() {
    merge(
        intArrayOf(1,2,3,0,0,0),3, intArrayOf(2,5,4),3
    )
    /*merge(
        intArrayOf(1),1, intArrayOf(0),0
    )*/
    /*merge(
        intArrayOf(4,0,0,0,0,0),1, intArrayOf(1,2,3,5,6),5
    )*/
}