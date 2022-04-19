package leetcode

/**
 * Created By Abir Hasan on 19-April-22
 * Problem: Contains Duplicate
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/maximum-subarray/
 */

fun maxSubArray(nums: IntArray): Int {
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

fun main() {
    val res = maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    //val res = maxSubArray(intArrayOf(-2, 1))
    println(res)
}