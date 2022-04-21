package leetcode

/**
 * Created By Abir Hasan on 21-April-22
 * Problem: Intersection of Two Arrays
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */

fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
    val resultList = mutableListOf<Int>()
    val trackMap = mutableMapOf<Int, Int>()
    for (i in nums1.indices) {
        trackMap[i] = nums1[i]
    }
    for (i in nums2.indices) {
        val currentValue = nums2[i]
        if (trackMap.containsValue(currentValue)) {
            resultList.add(currentValue)
            val keyForValue = trackMap.filterValues { value -> value == currentValue }.keys.first()
            trackMap.remove(keyForValue)
        }
    }
    return resultList.toIntArray()
}

fun main() {
    val result = intersect(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
    result.forEach { println(it) }
}