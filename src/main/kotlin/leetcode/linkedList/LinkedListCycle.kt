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

/**
 * Time Complexity : O(N)
 * Space Complexity : O(1) // No additional Storage needed for the below solution
 * Floyd's Cycle detection algorithm :
 * It's a classic algo for detecting cycles in a linked list.
 * We use two pointers to traverse the list: The first one is moving one node at the time and
 * the second two nodes at the time. If there is a cycle,
 * sooner or later pointers will meet, and we return true.
 * If the fast pointer reached the end of the list, that means there is no cycle, and we can return false.
 */
fun hasCycleV2(head: ListNode?): Boolean {
    if(head?.next == null)
        return false
    // Fast and Slow Pointers
    var slow : ListNode? = head
    var fast : ListNode? = head

    // Traverse the list to see if there is any cycle
    while(fast?.next != null) {
        slow = slow?.next           // move slow pointer by 1 position
        fast = fast.next?.next      // move slow pointer by 2 position
        println("slow: ${slow?.`val`} fast: ${fast?.`val`}")
        // Cycle found
        if(slow == fast)
            return true
    }
    return false
}