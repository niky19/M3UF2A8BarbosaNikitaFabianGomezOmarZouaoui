import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BoardTest {



    @Test
    fun `removeCompletedLines should increase the score for each completed line`() {
        val board = Board(5, 4)

        // Fill three lines at the bottom
        repeat(3) { i ->
            repeat(4) { j ->
                board.board[4 - i][j] = 1
            }
        }

        board.removeCompletedLines()

        assertEquals(3, board.score)
    }

    @Test
    fun `removeCompletedLines should not increase the score if no lines are completed`() {
        val board = Board(5, 4)

        // Add a completed line in the middle
        repeat(4) { j ->
            board.board[2][j] = 1
        }

        board.removeCompletedLines()

        assertEquals(0, board.score)
    }
}
