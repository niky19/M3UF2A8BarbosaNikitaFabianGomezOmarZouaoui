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
    var board: MutableList<MutableList<Int>> = MutableList(height) { MutableList(width) { 0 } }
    fun showBoard() {
        for (i in 0..<height) {
            for (j in 0..<width) {
                print(board[i][j])
            }
            println()
        }
        println()
    }

    fun setUpPieces(): List<Piece> {
        val pieceO = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 5)
        val pieceL = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "blue", 0, 5)
        val pieceJ = Piece('J', listOf(listOf(1, 0, 0), listOf(1, 1, 1)), "green", 0, 5)
        val pieceI = Piece('I', listOf(listOf(1), listOf(1), listOf(1), listOf(1)), "yellow", 0, 5)
        val piecesList = listOf(pieceO, pieceL, pieceJ, pieceI)
        return piecesList
    }

    fun getRandomPiece(): Piece {
        val pieces = setUpPieces()
        val random = Random.nextInt(0, pieces.size)
        return pieces[random]
    }

    //Cuando nos llegue la pieza la posicion X e Y seran las correctas
    fun placePiece(piece: Piece) {
    for (i in 0..<piece.shape.size) {
        for (j in 0..<piece.shape[i].size) {
            board[piece.positionY + i][piece.positionX + j] = piece.shape[i][j]
        }
    }
}
//   fun placePiece(piece: Piece) {
//    for (i in 0 until piece.shape.size) {
//        for (j in 0 until piece.shape[i].size) {
//            if (piece.positionY + i in 0 until height && piece.positionX + j in 0 until width) {
//                if (board[piece.positionY + i][piece.positionX + j] == 0) {
//                    board[piece.positionY + i][piece.positionX + j] = piece.shape[i][j]
//                } else {
//                    piece.positionY -= 1
//                    placePiece(piece)
//                    return
//                }
//            }
//        }
//    }
//}


    fun moveRight(piece: Piece) {
        piece.positionX += 1
    }

    fun moveLeft(piece: Piece) {
        piece.positionX -= 1
    }

    //Comprueba si se puede mover, comparando cada índice de la pieza con los índices adyacentes del tablero
    fun getPiecePositionY(piece: Piece): Int {
        for (i in board.indices) {
            for (j in 0..<board[i].size) {
                if (j in piece.positionX..piece.positionX + piece.shape[piece.shape.lastIndex].size) {
                    if (board[i][j] == 1) {
                        if (i - piece.shape.size < 0) {
                            return -1
                        }
                        return  i - piece.shape.size
                    }
                }
            }
        }
        return board.size - piece.shape.size
    }
//fun getPiecePositionY(piece: Piece): Int {
//    for (i in board.size - 1 downTo 0) {
//        for (j in piece.positionX until piece.positionX + piece.shape[0].size) {
//            if (j in 0 until width && board[i][j] == 1) {
//                return i - piece.shape.size + 2
//            }
//        }
//    }
//    return height - piece.shape.size
//}


    fun isLineComplete(): Boolean {
        //TODO: comprobar si hay una linea completa y eliminarla si la hay
        return true
    }

}


fun main() {
    val board = Board(9, 5)
    board.showBoard()
    val piece = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 0)
    val anotherPiece = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "blue", 0, 0)
    println(piece.shape)
    piece.positionY = board.getPiecePositionY(piece)
    println("La pieza esta en la posicion ${piece.positionY}")
    board.placePiece(piece)
    board.showBoard()

    println("La pieza esta en la posicion ${piece.positionY}")
    println(anotherPiece.shape)
    anotherPiece.positionY = board.getPiecePositionY(anotherPiece)
    println("La pieza2 esta en la posicion ${anotherPiece.positionY}")
    board.placePiece(anotherPiece)
    board.showBoard()
}