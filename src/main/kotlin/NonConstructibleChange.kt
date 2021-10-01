/**
 * Created By Abir Hasan on 01-Oct-21
 * Problem: Non-Constructable Change
 * Category: Arrays
 */


@Suppress("SpellCheckingInspection")
fun nonConstructibleChange(coins: MutableList<Int>): Int {
    if (coins.size == 0) return 1
    val sortedList = coins.sorted()
    var minPossibleChange = 0
    for (change in sortedList) {
        if (change > (minPossibleChange + 1)) {
            return minPossibleChange + 1
        } else {
            minPossibleChange += change
        }
    }
    return minPossibleChange + 1
}