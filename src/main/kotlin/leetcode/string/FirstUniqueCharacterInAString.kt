package leetcode.string

/**
 * Created By Abir Hasan on 24-April-22
 * Problem: First unique character in a string
 * Category: String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/first-unique-character-in-a-string/
 */

fun firstUniqChar(s: String): Int {
    val chars = s.toCharArray()
    var index = chars.size
    val charMap = hashMapOf<Char, Int>()
    for (i in chars.indices) {
        if (charMap.containsKey(chars[i])) {
            charMap[chars[i]] = -1
        } else {
            charMap[chars[i]] = i
        }
    }
    charMap.forEach {
        if (it.value != -1 && it.value < index)
            index = it.value
    }
    return if (index == chars.size) return -1 else index
}

fun main() {
    val res = firstUniqChar("leetcode")
    //val res = firstUniqChar("aabb")
    println("index: $res")
}