package leetcode.struct

class BinarySearchTree {

    private var root: TreeNode? = null

    fun insert(value: Int) {
        val root = this.root
        if (root == null) {
            this.root = TreeNode(value)
        } else {
            insert(root, value)
        }
    }

    fun inorder() = inorder(this.root)

    companion object {
        fun insert(parent: TreeNode, value: Int) {
            if (parent.`val` == value) {
                return
            } else if (parent.`val` > value) {
                val left = parent.left
                if (left == null) {
                    parent.left = TreeNode(value)
                } else {
                    insert(left, value)
                }
            } else {
                val right = parent.right
                if (right == null) {
                    parent.right = TreeNode(value)
                } else {
                    insert(right, value)
                }
            }
        }
    }
}

