package leetcode.sudoku.solver

import leetcode.valid.sudoku.ThreeLoops
import leetcode.valid.sudoku.ValidSudoku
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SudokuSolverTest {

    private val checker: ValidSudoku = ThreeLoops()

    @Test
    fun testDFS1() {
        this.test(NavieDFS1())
    }

    @Test
    fun testDFS2() {
        this.test(NavieDFS2())
    }

    @Test
    fun testRoughDFS() {
        this.test(RoughDFS())
    }

    @Test
    fun testSolvingEmpty() {
        val solver: SudokuSolver = NavieDFS2()
        val board = Array(9) { CharArray(9) { '.' } }
        solver.solveSudoku(board)
        board.forEach {
            println(it.toList())
        }
    }

    private fun test(solver: SudokuSolver) {
        val board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        val expected =
            arrayOf(
                charArrayOf('5', '3', '4', '6', '7', '8', '9', '1', '2'),
                charArrayOf('6', '7', '2', '1', '9', '5', '3', '4', '8'),
                charArrayOf('1', '9', '8', '3', '4', '2', '5', '6', '7'),
                charArrayOf('8', '5', '9', '7', '6', '1', '4', '2', '3'),
                charArrayOf('4', '2', '6', '8', '5', '3', '7', '9', '1'),
                charArrayOf('7', '1', '3', '9', '2', '4', '8', '5', '6'),
                charArrayOf('9', '6', '1', '5', '3', '7', '2', '8', '4'),
                charArrayOf('2', '8', '7', '4', '1', '9', '6', '3', '5'),
                charArrayOf('3', '4', '5', '2', '8', '6', '1', '7', '9')
            )

        this.test(solver, board, expected)
    }

    private fun test(solver: SudokuSolver, board: Array<CharArray>, expected: Array<CharArray>) {
        solver.solveSudoku(board)
        println()
        board.forEach {
            println(it.toList())
        }
        assertThat(this.checker.isValidSudoku(board)).isTrue()
        assertThat(board).isEqualTo(expected)
    }
}

