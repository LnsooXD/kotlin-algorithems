package leetcode.struct

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    override fun toString(): String {
        return this.`val`.toString()
    }
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

fun bfs(tree: TreeNode?): Array<TreeNode> {
    if (tree == null) {
        return emptyArray()
    }

    val queue: Queue<TreeNode> = LinkedList(listOf(tree))
    val visited = mutableListOf<TreeNode>()

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        visited.add(node)

        node.left?.run { queue.offer(this) }
        node.right?.run { queue.offer(this) }
    }
    return visited.toTypedArray()
}

fun bfsFillWithNulls(tree: TreeNode?): Array<TreeNode?> {
    if (tree == null) {
        return emptyArray()
    }

    val queue: Queue<TreeNode?> = LinkedList(listOf(tree))
    val visited = mutableListOf<TreeNode?>()

    var count = 0
    var layerCount = 2
    var nullCount = 0

    val counting = { it: TreeNode? ->
        queue.offer(it)
        count++
        if (it == null) {
            nullCount++
        }
    }

    while (queue.isNotEmpty()) {
        val node = queue.poll()
        visited.add(node)

        node?.left.also(counting)
        node?.right.also(counting)

        if (count >= layerCount) {
            if (nullCount >= count) {
                break
            }
            count = 0
            layerCount += layerCount
        }
    }

    return visited.toTypedArray()
}


fun dfs(tree: TreeNode?): Array<TreeNode> {
    if (tree == null) {
        return emptyArray()
    }

    val stack = Stack<TreeNode>()
    val visited = mutableListOf<TreeNode>()

    stack.push(tree)

    while (stack.isNotEmpty()) {
        val node = stack.pop()
        visited.add(node)

        node.right?.apply { stack.push(this) }
        node.left?.apply { stack.push(this) }

    }
    return visited.toTypedArray()
}

fun dfsr(tree: TreeNode?): Array<TreeNode> {
    if (tree == null) {
        return emptyArray()
    }
    val visited = mutableListOf<TreeNode>()
    dfsr(tree, visited)
    return visited.toTypedArray()
}

private fun dfsr(tree: TreeNode, visited: MutableList<TreeNode>) {
    visited.add(tree)
    tree.left?.apply { dfsr(this, visited) }
    tree.right?.apply { dfsr(this, visited) }
}

fun inorder(tree: TreeNode?): IntArray {
    if (tree == null) {
        return intArrayOf()
    }
    val list = mutableListOf<Int>()
    inorder(tree, list)
    return list.toIntArray()
}

fun preorder(tree: TreeNode?): IntArray {
    if (tree == null) {
        return intArrayOf()
    }
    val list = mutableListOf<Int>()
    preorder(tree, list)
    return list.toIntArray()
}

fun postorder(tree: TreeNode?): IntArray {
    if (tree == null) {
        return intArrayOf()
    }
    val list = mutableListOf<Int>()
    postorder(tree, list)
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

private fun preorder(tree: TreeNode?, list: MutableList<Int>) {
    if (tree == null) {
        return
    }
    list.add(tree.`val`)
    preorder(tree.left, list)
    preorder(tree.right, list)
}


private fun postorder(tree: TreeNode?, list: MutableList<Int>) {
    if (tree == null) {
        return
    }
    postorder(tree.left, list)
    postorder(tree.right, list)
    list.add(tree.`val`)
}


