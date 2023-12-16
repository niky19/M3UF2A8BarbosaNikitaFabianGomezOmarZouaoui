    import kotlin.random.Random

/*
Tetris:
The program will ask for the
size of the game board and will randomly show a series of pieces that, in this one
simplified version, they will not be able to rotate. We will move these pieces N positions to the right or a
the left and we will drop them. The moment a piece touches the bottom or one of the
pieces already placed, the piece will stop its fall. If you get that one line
horizontal is completely filled, this line will disappear from the table and the pieces (or
remains of pieces) that are on top fall until they touch the bottom or some other piece. The
program ends when some piece reaches the upper limit of the table and therefore no more
we can place none more.
 */

//Esta es la clase del tablero donde pondremos la logica del juego

    data class Board(var height: Int, var width: Int) {
        var isGameOver = false
        var board: MutableList<MutableList<Int>> = MutableList(height) { MutableList(width) { 0 } }
        var piecesOnBoard: MutableList<Piece> = mutableListOf()

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
        // En la clase Board
        fun getPiecePositionY(piece: Piece): Int {
            for (i in board.indices) {
                for (j in 0 until board[i].size) {
                    if (j in piece.positionX until piece.positionX + piece.shape[0].size) {
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

        fun placePiece(piece: Piece) {
            piece.positionY = getPiecePositionY(piece)
            if (piece.positionY != -1) {
                for (i in 0 until piece.shape.size) {
                    for (j in 0 until piece.shape[i].size) {
                        if (piece.shape[i][j] == 1) {
                            board[piece.positionY + i][piece.positionX + j] = 1
                        }
                    }
                }
                piecesOnBoard.add(piece)
            } else {
                isGameOver = true
            }
        }

        fun removeCompletedLines() {
            var isLineCompleted = true
            for (columnIndex in 0 until board.size) {
                for (rowIndex in 0 until board[columnIndex].size) {
                    val currentBoardPosition = board[columnIndex][rowIndex]
                    if (currentBoardPosition == 0) {
                        isLineCompleted = false
                    }
                }
                if (isLineCompleted) {
                    board.removeAt(columnIndex)
                    board.add(0, MutableList(width) { 0 })
                }
                isLineCompleted = true
            }
        }

        private fun findPieceByPosition(x: Int, y: Int): Piece? {
            for (piece in piecesOnBoard) {
                if (y in piece.positionY until piece.positionY + piece.shape.size &&
                    x in piece.positionX until piece.positionX + piece.shape[0].size
                ) {
                    return piece
                }
            }
            return null
        }
    }
