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
    val list = mutableListOf<Int>()
    inorder(tree, list)
    return list.toIntArray()
}

private fun inorder(tree: TreeNode?, list: MutableList<Int>) {
    if (tree == null) {
        return
    }

    inorder(tree.left, list)
    list.add(tree.`val`)
    inorder(tree.right, list)
}

