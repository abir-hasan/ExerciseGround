package leetcode.tree

/**
 * Created By Abir Hasan on 30-April-22
 * Problem: Binary Tree In-Order Traversal
 * Category: Tree
 * Difficulty: Easy
 * Link: https://leetcode.com/problems/binary-tree-inorder-traversal/
 *
 */

class BinaryTreeInorderTraversal {

    private val values = mutableListOf<Int>()

    /**
     * Preorder (Left, Root, Right)
     */
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val curr = root?.value
        println("value -> $curr")
        if (root != null) {
            println("LEFT CALL FROM -> $curr")
            inorderTraversal(root.left)
            println("[Add -> $curr]")
            values.add(root.value)
            println("RIGHT CALL FROM -> $curr")
            inorderTraversal(root.right)
        }
        println("END -> $curr")
        return values
    }

    fun inorderTraversalV2(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val items = mutableListOf<TreeNode>() // Stack
        var curr: TreeNode? = root
        while (items.isNotEmpty() || curr != null) {
            println("curr $curr stack-> $items ")
            if (curr != null) {
                items.add(curr)
                curr = curr.left
            } else {
                curr = items[items.size-1]
                values.add(curr.value)
                items.removeAt(items.size-1)
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

    val obj = BinaryTreeInorderTraversal()
    val nodes = obj.inorderTraversal(node1)
    println("Final Output -> $nodes")
}