package leetcode.stackQueue

/**
 * Created By Abir Hasan on 28-April-22
 * Problem: Valid Parentheses
 * Category: Stack-Queue
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-parentheses/
 */

fun isValid(s: String): Boolean {
    val bracketsArray = s.toCharArray()
    val openBracketsList = mutableListOf<Char>()

    for ((i, v) in bracketsArray.withIndex()) {
        val lastIndex = openBracketsList.size - 1
        //println("curr: $v list: $openBracketsList") // this gave output limit exceeded
        when (v) {
            '(' -> {
                openBracketsList.add(v)
            }
            ')' -> {
                if (openBracketsList.size > 0 && openBracketsList[lastIndex] == '(') {
                    openBracketsList.removeAt(lastIndex)
                } else {
                    return false
                }
            }
            '{' -> {
                openBracketsList.add(v)
            }
            '}' -> {
                if (openBracketsList.size > 0 && openBracketsList[lastIndex] == '{') {
                    openBracketsList.removeAt(lastIndex)
                } else {
                    return false
                }
            }
            '[' -> {
                openBracketsList.add(v)
            }
            ']' -> {
                if (openBracketsList.size > 0 && openBracketsList[lastIndex] == '[') {
                    openBracketsList.removeAt(lastIndex)
                } else {
                    return false
                }
            }
        }
    }
    return if (openBracketsList.size > 0) return false else true
}

fun main() {
    //val res = isValid("()[]{}")
    val res = isValid("[{()}]")
    //val res = isValid("()]{}")
    println(res)
}