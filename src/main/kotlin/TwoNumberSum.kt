/**
 * Created By Abir Hasan on 29-Sep-21
 *
 */


fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    for ((i, value) in array.withIndex()) {
        for (j in (i + 1) until array.size) {
            val sum = value + array[j]
            if (sum == targetSum) {
                return listOf(value, array[j])
            }
        }
    }
    return listOf<Int>()
}


fun main() {
    //val list: List<Int> = twoNumberSum(arrayListOf(3, 5, -4, 8, 11, 1, -1, 6), 10)
    val list: List<Int> = twoNumberSum(arrayListOf(4, 6), 10)
    println(list)
}