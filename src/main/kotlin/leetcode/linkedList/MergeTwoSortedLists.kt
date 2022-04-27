package leetcode.linkedList

/**
 * Created By Abir Hasan on 27-April-22
 * Problem: Merge two sorted lists
 * Category: Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/merge-two-sorted-lists/
 */

// Minimum value possible for a node [From given constraints]
private const val MINIMUM_CONSTRAINED_VALUE = -200

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    var tempHead = list1
    var newHead = list2
    var out = list2
    // Base cases
    if (list1 == null) return list2
    if (list2 == null) return list1

    while (tempHead != null) {
        val current = tempHead
        tempHead = tempHead.next

        val currentValue = current.value
        println("curr: $currentValue")
        newHead = out
        while (newHead != null) {
            println("NEW: ${newHead.value}")
            // Check If the first lists item is greater than second arrays x positions number AND
            // less or equal to x+next positions number or x+next is the tail/null
            if (newHead.value <= currentValue && ((currentValue <= (newHead.next?.value
                    ?: MINIMUM_CONSTRAINED_VALUE)) || (newHead.next == null))
            ) {
                val keepNext = newHead.next
                newHead.next = current
                current.next = keepNext
                break
                // If the firsts lists item is less or equal to the second lists head
                // Point it to the second lists item and return current item as the new head
            } else if (newHead.value >= currentValue) {
                current.next = newHead
                out = current
                break
            }
            newHead = newHead.next
        }
        println("${tempHead?.value}")
    }
    return out
}