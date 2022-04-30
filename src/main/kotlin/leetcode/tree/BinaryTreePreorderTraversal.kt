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

    /**
     * Preorder (Root, Left, Right)
     */
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

    fun preorderTraversalV2(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val items = mutableListOf<TreeNode>() // Stack
        var curr: TreeNode? = root
        while (items.isNotEmpty() || curr != null) {
            println("stack-> $items")
            if (curr != null) {
                values.add(curr.value)
                items.add(curr)
                curr = curr.left
            } else {
                curr = items[items.size - 1]
                items.removeAt(items.size - 1)
                curr = curr.right
            }
        }
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

    val obj = BinaryTreePreorderTraversal()
    val nodes = obj.preorderTraversal(node1)
    println("Final Output -> $nodes")
}