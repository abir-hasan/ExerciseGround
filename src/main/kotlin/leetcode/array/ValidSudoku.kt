package leetcode.array

/**
 * Created By Abir Hasan on 23-April-22
 * Problem: Valid Sudoku
 * Category: Arrays
 * Difficulty: Medium
 * Link: https://leetcode.com/problems/valid-sudoku/
 */

fun isValidSudoku(board: Array<CharArray>): Boolean {
    val checkerMap = hashMapOf<String, HashSet<Char>>()
    for (i in board.indices) {
        val row = board[i]
        for (j in row.indices) {
            val currentItem = board[i][j]
            if (currentItem == '.') continue
            val rowKey = "r$i"
            val columnKey = "c$j"
            val boxKey = "${i / 3}${j / 3}"
            val rowSet = checkerMap[rowKey] ?: hashSetOf()
            val columnSet = checkerMap[columnKey] ?: hashSetOf()
            val boxSet = checkerMap[boxKey] ?: hashSetOf()
            if (rowSet.contains(currentItem) || columnSet.contains(currentItem) || boxSet.contains(currentItem)) {
                return false
            } else {
                rowSet.add(currentItem)
                columnSet.add(currentItem)
                boxSet.add(currentItem)
                checkerMap[rowKey] = rowSet
                checkerMap[columnKey] = columnSet
                checkerMap[boxKey] = boxSet
            }
        }
    }
    return true
}

fun isValidSudokuV2(board: Array<CharArray>): Boolean {
    val seen: HashSet<String> = hashSetOf()
    for (i in board.indices) {
        for (j in board[i].indices) {
            board[i][j].run {
                if (this != '.') {
                    if (
                        !seen.add("$this seen in row-$i") ||
                        !seen.add("$this seen in column-$j") ||
                        !seen.add("$this seen in box-${i / 3}${j / 3}")
                    )
                        return false
                }
            }
        }
    }
    return true
}

fun main() {
    // Expected True
     val res = isValidSudoku(
         arrayOf(
             charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
             charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
             charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
             charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
             charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
             charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
             charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
             charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
             charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
         )
     )

    // Expected False :  Same as Example 1, except with the 5 in the top left corner being modified to 8.
    // Since there are two 8's in the top left 3x3 sub-box, it is invalid.
    /*val res = isValidSudokuV2(
        arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    )*/
    println(res)
}