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

fun intersectV2(nums1: IntArray, nums2: IntArray): IntArray {
    val resultList = mutableListOf<Int>()
    val trackBiggerList = mutableListOf<Int>()
    val trackSmallerList = mutableListOf<Int>()

    val biggerArray: IntArray
    val smallerArray: IntArray
    if (nums1.size >= nums2.size) {
        biggerArray = nums1
        smallerArray = nums2
    } else {
        biggerArray = nums2
        smallerArray = nums1
    }

    for (i in biggerArray.indices) {
        val one = biggerArray[i]
        if (trackSmallerList.contains(one)) {
            resultList.add(one)
            trackSmallerList.remove(one)
        } else {
            trackBiggerList.add(one)
        }
        if (i < smallerArray.size) {
            val two = smallerArray[i]
            if (trackBiggerList.contains(two)) {
                resultList.add(two)
                trackBiggerList.remove(two)
            } else {
                trackSmallerList.add(two)
            }
        }
    }
    return resultList.toIntArray()
}

fun main() {
    val result = intersectV2(
        intArrayOf(54,93,21,73,84,60,18,62,59,89,83,89,25,39,41,55,78,27,65,82,94,61,12,38,76,5,35,6,51,48,61,0,47,60,84,9,13,28,38,21,55,37,4,67,64,86,45,33,41),
        intArrayOf(17,17,87,98,18,53,2,69,74,73,20,85,59,89,84,91,84,34,44,48,20,42,68,84,8,54,66,62,69,52,67,27,87,49,92,14,92,53,22,90,60,14,8,71,0,61,94,1,22,84,10,55,55,60,98,76,27,35,84,28,4,2,9,44,86,12,17,89,35,68,17,41,21,65,59,86,42,53,0,33,80,20)
    )
    //val result = intersectV2(intArrayOf(4, 9, 5), intArrayOf(9, 4, 9, 8, 4))
    //val result = intersectV2(intArrayOf(1,2,2,1), intArrayOf(2,2))
    result.forEach { print("$it ") }
}