package leetcode.linkedList

/**
 * Created By Abir Hasan on 27-April-22
 * Problem: Remove Linked List Element
 * Category: Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-linked-list-elements/
 */

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    // Base Case
    if (head == null) return head

    var out = head // Output Head
    var temp = head // Rotate temp to move forward with the list
    var prev = head // Keep track of the previous item to remove an item in between

    while (temp != null) {
        if (temp == out && temp.value == `val`) {
            prev = temp
            temp = temp.next
            out = temp
        } else if (temp.value == `val`) {
            prev?.next = temp.next
            temp = temp.next
        } else {
            prev = temp
            temp = temp.next
        }
    }
    return out
}