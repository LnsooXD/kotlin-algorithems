package leetcode.struct

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun treeOf(vararg elements: Int?): TreeNode? = if (elements.isNotEmpty() || elements[0] == null) {
    nodeOf(elements, 0)
} else null

fun nodeOf(elements: Array<out Int?>, index: Int): TreeNode? = if (index < elements.size) {
    elements[index]?.let {
        val node = TreeNode(it)
        node.left = nodeOf(elements, index + index + 1)
        node.right = nodeOf(elements, index + index + 2)
        node
    }
} else null

fun inorder(tree: TreeNode?): IntArray {
    if (tree == null) {
        return intArrayOf()
    }

    val left = inorder(tree.left)
    val right = inorder(tree.right)

    val size = left.size + 1 + right.size
    val res = IntArray(size)

    System.arraycopy(left, 0, res, 0, left.size)
    res[left.size] = tree.`val`
    System.arraycopy(right, 0, res, left.size + 1, right.size)
    return res
}

