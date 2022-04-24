package leetcode.array

/**
 * Created By Abir Hasan on 21-April-22
 * Problem: Best time to buy and sell stock
 * Category: Arrays
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */

fun maxProfit(prices: IntArray): Int {
    if (prices.size < 2) return 0 // If there is only one item then we can't make any profit

    var maxAmount = 0
    var minAmount = Int.MAX_VALUE
    var maxProfit = Int.MIN_VALUE

    for (i in prices.indices) {
        val current = prices[i]

        if (maxAmount <= current) {
            maxAmount = current
        }
        // Make sure to check minimum amount till the last index -1
        // Cause if we find a new minimum amount on the last index we won't be able to maximize the profit.
        if (current < minAmount && i != prices.size - 1) {
            minAmount = current
            // Resetting the Max amount. As we found a new min amount
            maxAmount = current
        }
        // Calculate current day profit
        val tempProfit = maxAmount - minAmount
        // Keep it if it's bigger than previous max
        if (tempProfit > maxProfit)
            maxProfit = tempProfit
    }
    return maxProfit
}

fun main() {
    //val result = maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
    //val result = maxProfit(intArrayOf(1))
    val result = maxProfit(intArrayOf(1, 2, 1, 0, 2, 0))
    println(result)
}