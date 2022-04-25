package leetcode.string

/**
 * Created By Abir Hasan on 25-April-22
 * Problem: Ransom Note
 * Category: String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/ransom-note/
 */

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val noteCharArray = ransomNote.toCharArray()
    val magazineArray = magazine.toCharArray()
    val magMap = hashMapOf<Char, Int>()
    val noteMap = hashMapOf<Char, Int>()

    // Map the second/magazine string chars
    for ((i, v) in magazineArray.withIndex()) {
        if (magMap.containsKey(v)) {
            val count = magMap[v]
            magMap[v] = count!! + 1
        } else {
            magMap[v] = 1
        }
    }

    // Map the first/Note string chars
    for ((i, v) in noteCharArray.withIndex()) {
        if (noteMap.containsKey(v)) {
            val count = noteMap[v]
            noteMap[v] = count!! + 1
        } else {
            noteMap[v] = 1
        }
    }

    // Check if each note char exists in the magazine map
    // also the char count is equal or greater
    // Otherwise return false
    noteMap.forEach {
        if (!magMap.containsKey(it.key) || magMap[it.key]!! < it.value)
            return false
    }
    return true
}

fun main() {
    val res = canConstruct("aa", "aab") // true
    //val res = canConstruct("a","b") // false
    println(res)
}