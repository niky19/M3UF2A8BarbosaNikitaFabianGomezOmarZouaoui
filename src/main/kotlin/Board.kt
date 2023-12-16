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

    fun showBoard() {
        for (i in 0..<height) {
            for (j in 0..<width) {
                val currengPosition = board[i][j]
                if (currengPosition == 1) {
                    print("\uD83D\uDFE5")
                } else {
                    print("⬛")
                }
            }
            println()
        }
        println()
    }


    //Cuando nos llegue la pieza la posicion X e Y seran las correctas
    fun placePiece(piece: Piece) {
        piece.positionY = getPiecePositionY(piece)
        if (piece.positionY != -1){


        for (i in 0..<piece.shape.size) {
            for (j in 0..<piece.shape[i].size) {
                board[piece.positionY + i][piece.positionX + j] = piece.shape[i][j]
            }
        }
        } else {
            isGameOver = true
        }
    }



    //Comprueba si se puede mover, comparando cada índice de la pieza con los índices adyacentes del tablero
    fun getPiecePositionY(piece: Piece): Int {
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
            }
            isLineCompleted = true
        }

    }

}