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

    fun postorderTraversalV2(root: TreeNode?): List<Int> {
        if (root == null) return listOf()
        val items = mutableListOf<TreeNode>() // Stack
        var curr: TreeNode? = root
        var isRightNodeCalled = false
        while (items.isNotEmpty() || curr != null) {
            println("stack-> $items")
            if (curr != null && !items.contains(curr)) {
                items.add(curr)
                curr = curr.left
                isRightNodeCalled = false
            } else if (items.isNotEmpty() && curr == null && !isRightNodeCalled) {
                curr = items[items.size - 1]
                curr = curr.right
                isRightNodeCalled = true
            } else {
                curr = items[items.size - 1]
                values.add(curr.value)
                items.removeAt(items.size - 1)
                if (items.size > 0)
                    curr = items[items.size - 1]
                else
                    break
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

    val obj = BinaryTreePostorderTraversal()
    val nodes = obj.postorderTraversal(node1)
    println("Final Output -> $nodes")
}