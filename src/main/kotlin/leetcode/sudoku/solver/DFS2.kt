package leetcode.sudoku.solver

class DFS2 : AbsDFS() {

    private val rows = IntArray(3) { 0 }
    private val cols = IntArray(3) { 0 }
    private val blocks = IntArray(3) { 0 }

    override fun acceptValue(board: Array<CharArray>, i: Int, j: Int, value: Int) {
        val mask = 1.shl(value)

        val bi = i / 3
        val bj = j / 3

        this.rows[bi] = this.rows[bi].or(mask.shl((i % 3) * 10))
        this.cols[bj] = this.cols[bj].or(mask.shl((j % 3) * 10))
        this.blocks[bi] = this.blocks[bi].or(mask.shl(bj * 10))

        board[i][j] = (value + '0'.toInt()).toChar()
    }

    override fun rejectValue(board: Array<CharArray>, i: Int, j: Int, value: Int) {
        val mask = 1.shl(value)

        val bi = i / 3
        val bj = j / 3

        this.rows[bi] = this.rows[bi].and(mask.shl((i % 3) * 10).inv())
        this.cols[bj] = this.cols[bj].and(mask.shl((j % 3) * 10).inv())
        this.blocks[bi] = this.blocks[bi].and(mask.shl(bj * 10).inv())

        board[i][j] = '.'
    }

    override fun checkValid(i: Int, j: Int, value: Int) = 1.shl(value).let {
        val bi = i / 3
        val bj = j / 3

        this.rows[bi].and(it.shl((i % 3) * 10)) == 0 &&
                this.cols[bj].and(it.shl((j % 3) * 10)) == 0 &&
                this.blocks[bi].and(it.shl(bj * 10)) == 0
    }
}