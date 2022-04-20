package leetcode

/**
 * Created By Abir Hasan on 20-April-22
 * Problem: Two Sum
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/two-sum/
 */

fun twoSum(nums: IntArray, target: Int): IntArray {
    val targetMap = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        if (targetMap.containsKey(nums[i])) {
            return intArrayOf(i, targetMap[nums[i]] ?: 0)
        }
        val valueNeeded = target - nums[i]
        targetMap[valueNeeded] = i
    }
    return intArrayOf()
}

fun twoSumV2(nums: IntArray, target: Int): IntArray {
    // O(n²) Example
    for (i in nums.indices) {
        for (j in (i + 1) until nums.size) {
            if ((nums[i] + nums[j]) == target) {
                return intArrayOf(i, j)
            }
        }
    }
    return intArrayOf()
}

