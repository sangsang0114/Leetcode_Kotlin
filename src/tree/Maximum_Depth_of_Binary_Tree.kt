package tree

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0

    val queue: Queue<TreeNode> = LinkedList()

    queue.add(root)
    var depth = 0

    while (!queue.isEmpty()) {
        ++depth
        val q_size = queue.size

        for (i in 0 until q_size) {
            val current = queue.poll()

            if (current.left != null) queue.add(current.left)
            if (current.right != null) queue.add(current.right)
        }
    }
    return depth
}