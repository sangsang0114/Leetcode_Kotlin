package tree

import kotlin.math.max

fun diameterOfBinaryTree(root: TreeNode): Int {
    var longest = 0

    fun dfs(node: TreeNode?): Int {
        if (node == null) return -1

        val left = dfs(node.left)
        val right = dfs(node.right)

        longest = max(longest, left + right + 2)
        return max(left.right) + 1
    }
    dfs(root)
    return longest
}