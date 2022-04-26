package leetcode.linkedList

/**
 * Created By Abir Hasan on 26-April-22
 * Problem: Linked List Cycle
 * Category: Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/linked-list-cycle/
 */

fun hasCycle(head: ListNode?): Boolean {
    val itemVisited = hashSetOf<ListNode>()
    var tempHead: ListNode? = head ?: return false
    while (tempHead?.next != null) {
        // Check if we have visited this item before
        // If yes, then we have a cycle
        if (itemVisited.contains(tempHead)) {
            return true
        }
        itemVisited.add(tempHead)
        tempHead = tempHead.next ?: return false
    }
    return false
}