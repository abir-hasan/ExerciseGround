package leetcode

/**
 * Created By Abir Hasan on 19-April-22
 * Problem: Maximum SubArray [ The Largest Sum Contiguous SubArray ]
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-subarray/
 */

fun maxSubArray(nums: IntArray): Int {
    // First attempt with TLE
    var maxSum = 0
    for (i in nums.indices) {
        maxSum = if (i == 0) nums[0] else if (maxSum < nums[i]) nums[i] else maxSum
        val initialValue = nums[i]
        var maxSize = nums.size
        for (k in maxSize downTo 0) {
            if (k <= (i + 1))
                break
            val subArray = nums.toList().subList(i + 1, k).toTypedArray()
            var tempArraySum = 0
            subArray.forEach { subItem ->
                tempArraySum += subItem
            }
            maxSize -= 1
            tempArraySum += initialValue
            if (tempArraySum > maxSum)
                maxSum = tempArraySum
        }
    }
    return maxSum
}

/**
 * Explanation of Kadane's Algorithm: https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * Time Complexity - O(n)
 */
fun maxSubArrayKadensAlgorithm(nums: IntArray): Int {
    var maxSoFar = Int.MIN_VALUE
    var maxEndingHere = 0
    nums.forEach {
        maxEndingHere += it
        if (maxSoFar < maxEndingHere)
            maxSoFar = maxEndingHere
        if (maxEndingHere < 0)
            maxEndingHere = 0
    }
    return maxSoFar
}

fun main() {
    //val res = maxSubArrayKadensAlgorithm(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    val res = maxSubArrayKadensAlgorithm(intArrayOf(-2, -1))
    println(res)
}