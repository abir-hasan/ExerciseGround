package leetcode.tree

/**
 * Created By Abir Hasan on 29-April-22
 * Problem: Binary Tree Pre-Order Traversal
 * Category: Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-preorder-traversal/
 */

class BinaryTreePreorderTraversal {

    private val values = mutableListOf<Int>()

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val curr = root?.value
        println("value -> $curr")
        if (root != null) {
            values.add(root.value)
            println("LEFT CALL FROM -> $curr")
            preorderTraversal(root.left)
            println("RIGHT CALL FROM -> $curr")
            preorderTraversal(root.right)
        }
        println("END -> $curr")
        return values
    }
}

fun main() {
    val node3 = TreeNode(3)
    val node2 = TreeNode(2)
    node2.left = null
    node2.right = node3
    val node1 = TreeNode(1)
    node1.left = null
    node1.right = node2

    val obj = BinaryTreePreorderTraversal()
    val nodes = obj.preorderTraversal(node1)
    println("Final Output -> $nodes")
}