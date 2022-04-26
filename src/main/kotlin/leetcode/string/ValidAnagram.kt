@file:Suppress("KotlinConstantConditions")

package leetcode.string

/**
 * Created By Abir Hasan on 26-April-22
 * Problem: Valid Anagram
 * Category: String
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/valid-anagram/
 */

fun isAnagram(s: String, t: String): Boolean {
    val noteCharArray = s.toCharArray()
    val magazineArray = t.toCharArray()
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

    // If two maps don't have the same chars map size
    // then they are definitely not anagram
    if (noteMap.size != magMap.size) {
        return false
    }

    // Check if each note char exists in the magazine map
    // also the char count is equal
    // Otherwise return false
    noteMap.forEach {
        if (!magMap.containsKey(it.key) || magMap[it.key]!! != it.value)
            return false
    }
    return true
}

fun main() {
    val res = isAnagram("anagram", "nagaram") // true
    //val res = isAnagram("aa", "aab") // false
    //val res = isAnagram("rat","car") // false
    println(res)
}