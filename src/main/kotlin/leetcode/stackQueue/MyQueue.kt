package leetcode.stackQueue

/**
 * Created By Abir Hasan on 28-April-22
 * Problem: Implement Queue using Stacks
 * Category: Stack-Queue
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/implement-queue-using-stacks/
 */

class MyQueue() {

    private val myQueueList = mutableListOf<Int>()

    fun push(x: Int) {
        myQueueList.add(x)
    }

    fun pop(): Int {
        val item = myQueueList[0]
        myQueueList.removeAt(0)
        return item
    }

    fun peek(): Int {
        return myQueueList[0]
    }

    fun empty(): Boolean {
        return myQueueList.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */

fun main(args: Array<String>) {
    val obj = MyQueue()
    obj.push(1)
    obj.push(2)
    var peek = obj.peek()
    var pop = obj.pop()
    var pop2 = obj.pop()
    var empty = obj.empty()
    println("peek: $peek pop2: $pop2 empty: $empty")
}