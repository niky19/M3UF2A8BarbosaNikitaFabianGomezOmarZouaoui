import kotlin.random.Random

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
                        return board.size - j - piece.shape[piece.shape.lastIndex].size
                    }
                }
            }
        }
        return board.size - piece.shape[piece.shape.lastIndex].size
    }


    fun isLineComplete(): Boolean {
        //TODO: comprobar si hay una linea completa y eliminarla si la hay
        return true
    }

}


fun main() {
    val board = Board(5, 5)
    board.showBoard()
    val piece = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 0)
    println(piece.shape)

    piece.positionY = board.getPiecePositionY(piece)

    println("La pieza esta en la posicion ${piece.positionY}")

    board.placePiece(piece)
    board.showBoard()

    println("La pieza esta en la posicion ${piece.positionY}")
}