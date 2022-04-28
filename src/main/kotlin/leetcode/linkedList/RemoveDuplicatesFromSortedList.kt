package leetcode.linkedList

/**
 * Created By Abir Hasan on 28-April-22
 * Problem: Remove Duplicates from Sorted List
 * Category: Linked List
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) return head

    var out = head
    var temp = head
    var prev = head

    while (temp != null) {
        if (temp == out && temp.value == temp.next?.value) {
            out = temp.next
            prev = out
            temp = out
        } else if (temp.value == temp.next?.value) {
            prev?.next = temp.next
            temp = temp.next
        } else {
            prev = temp
            temp = temp.next
        }
    }
    return out
}