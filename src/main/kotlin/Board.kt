/**
 *          Data class representing a game board.
 * Has functions to show the board, place a piece, get the position of a piece, and remove completed lines.
 * @authors Nikita Barbosa, Omar Zouaoui, Fabián Gómez
 * @property height The height of the board.
 * @property width The width of the board.
 */


data class Board(var height: Int, var width: Int) {
    var score = 0
    var isGameOver = false
    var board: MutableList<MutableList<Int>> =
        MutableList(height) { MutableList(width) { 0 } } // 2D list representing the game board. Initialized with zeros.

    /**
     *      Iterates over the board matrix.
     * Prints the current state of the board to the console.
     * Filled cells are represented by a square emoji, empty cells by a black square emoji.
     */
    fun showBoard() {
        for (i in 0 until height) {
            for (j in 0 until width) {
                val currentPosition = board[i][j]
                if (currentPosition == 1) {
                    val currentPiece = findPieceByPosition(j, i)
                    print(currentPiece?.color ?: "⬛")
                } else {
                    print("⬛")
                }
            }
            println()
        }
        println()
    }

    private fun findPieceByPosition(x: Int, y: Int): Piece? {
        for (piece in piecesOnBoard) {
            if (y in piece.positionY..<piece.positionY + piece.shape.size &&
                x in piece.positionX..<piece.positionX + piece.shape[0].size
            ) {
                return piece
            }
        }
        return null
    }


    /**
     *      Places a piece on the board.
     * Iterates over the piece's shape matrix.
     * The piece's Y position is determined by the `getPiecePositionY` function.
     * If the piece cannot be placed (i.e., `getPiecePositionY` returns -1), the game is marked as over.
     *
     * @param piece The piece to be placed.
     */
    fun placePiece(piece: Piece) {
        piece.positionY = getPiecePositionY(piece)
        if (piece.positionY != -1) {
            for (i in 0..<piece.shape.size) {
                for (j in 0 until piece.shape[i].size) {
                    board[piece.positionY + i][piece.positionX + j] = piece.shape[i][j]
                }
            }
            piecesOnBoard.add(piece)
        } else {
            isGameOver = true
        }
    }
    var piecesOnBoard: MutableList<Piece> = mutableListOf()
    /**
     *      Determines the Y position where a piece can be placed.
     * The function checks each cell of the board from top to bottom, left to right.
     * If it finds a filled cell that overlaps with the piece's X position, it returns the row above.
     * If no filled cell is found, it returns the bottom row of the board.
     *
     * @param piece The piece to be placed.
     * @return The Y position where the piece can be placed, or -1 if it cannot be placed.
     */
    private fun getPiecePositionY(piece: Piece): Int {
        for (i in board.indices) {
            for (j in 0..<board[i].size) {
                if (j in piece.positionX..<piece.positionX + piece.shape[piece.shape.lastIndex].size) {
                    if (board[i][j] == 1) {
                        if (i - piece.shape.size <= 0) {
                            return -1
                        }
                        return i - piece.shape.size
                    }
                }
            }
        }
        return board.size - piece.shape.size
    }

    /**
     *      Removes completed lines from the board.
     * A line is considered completed if all its cells are filled.
     * When a line is removed, a new empty line is added at the top of the board.
     */
    fun removeCompletedLines() {
        var isLineCompleted = true
        for (columnIndex in 0..<board.size) {
            for (rowIndex in 0..<board[columnIndex].size) {
                val currentBoardPosition = board[columnIndex][rowIndex]
                if (currentBoardPosition == 0) {
                    isLineCompleted = false
                }
            }
            if (isLineCompleted) {
                board.removeAt(columnIndex)
                board.add(0, MutableList(width) { 0 })
                score++
            }
            isLineCompleted = true
        }
    }
}