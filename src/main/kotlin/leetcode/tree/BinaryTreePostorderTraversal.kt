package leetcode.tree

/**
 * Created By Abir Hasan on 30-April-22
 * Problem: Binary Tree Postorder Traversal
 * Category: Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-postorder-traversal/
 *
 */

class BinaryTreePostorderTraversal {

    private val values = mutableListOf<Int>()

    /**
     * Preorder (Left, Right, Root)
     */
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val curr = root?.value
        println("value -> $curr")
        if (root != null) {
            println("LEFT CALL FROM -> $curr")
            postorderTraversal(root.left)
            println("RIGHT CALL FROM -> $curr")
            postorderTraversal(root.right)
            println("[Add -> $curr]")
            values.add(root.value)
        }
        println("END -> $curr")
        return values
    }
}

fun main() {
    val node3 = TreeNode(3)
    val node2 = TreeNode(2)
    node2.left = node3
    node2.right = null
    val node1 = TreeNode(1)
    node1.left = null
    node1.right = node2

    val obj = BinaryTreePostorderTraversal()
    val nodes = obj.postorderTraversal(node1)
    println("Final Output -> $nodes")
}