package leetcode.sudoku.solver

class NavieDFS1 : AbsNavieDFS() {


    private val rows = IntArray(9) { 0 }
    private val cols = IntArray(9) { 0 }
    private val blocks = Array(3) { IntArray(3) { 0 } }

    override fun acceptValue(board: Array<CharArray>, i: Int, j: Int, value: Int) {
        val mask = 1.shl(value)

        val bi = i / 3
        val bj = j / 3

        this.rows[i] = this.rows[i].or(mask)
        this.cols[j] = this.cols[j].or(mask)
        this.blocks[bi][bj] = this.blocks[bi][bj].or(mask)

        board[i][j] = (value + '0'.toInt()).toChar()
    }

    override fun rejectValue(board: Array<CharArray>, i: Int, j: Int, value: Int) {
        val mask = 1.shl(value).inv()

        val bi = i / 3
        val bj = j / 3

        this.rows[i] = this.rows[i].and(mask)
        this.cols[j] = this.cols[j].and(mask)
        this.blocks[bi][bj] = this.blocks[bi][bj].and(mask)

        board[i][j] = '.'
    }

    override fun checkValid(i: Int, j: Int, value: Int) = 1.shl(value).let {
        this.rows[i].and(it) == 0 && this.cols[j].and(it) == 0 && this.blocks[i / 3][j / 3].and(it) == 0
    }
}