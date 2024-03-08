package tree

import kotlin.math.max


fun longetsUnivaluePath(root: TreeNode?): Int {
    var result = 0

    fun dfs(node: TreeNode?): Int {
        if (node == null) return 0

        var left = dfs(node.left)
        var right = dfs(node.right)

        if (node.left != null && node.left.`val` == node.`val`)
            ++left
        else
            left = 0

        if (node.right != null && node.right.`val` == node.`val`)
            ++right
        else
            right = 0
        return max(left, right)
    }
    dfs(root)
    return result
}