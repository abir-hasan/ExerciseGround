package leetcode.linkedList

/**
 * Created By Abir Hasan on 28-April-22
 * Problem: Reverse Linked List
 * Category: Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/reverse-linked-list/
 */

fun reverseList(head: ListNode?): ListNode? {
    val items = mutableListOf<ListNode>()
    var temp = head
    while (temp != null) {
        items.add(temp)
        temp = temp.next
    }
    var out: ListNode? = null
    var prev: ListNode? = null
    for (i in items.size - 1 downTo 0) {
        println("${items[i].value}")
        if (i == items.size - 1) {
            println("if")
            out = items[i]
            prev = out
        } else if (i > 0) {
            println("else if: ${prev?.value} -> ${items[i].value}")
            prev?.next = items[i]
            prev = items[i]
        } else {
            println("else")
            prev?.next = items[i]
            items[i].next = null
        }
    }
    return out
}