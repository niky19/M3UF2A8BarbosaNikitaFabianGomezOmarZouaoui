import kotlin.random.Random

//Esta es la clase del tablero donde pondremos la logica del juego
data class Board(var height: Int, var width: Int) {
    var board: List<List<Int>> = List(height) { List(width) { 0 } }
    fun setUpBoard() {
        for (i in 0..<height) {
            for (j in 0..<width) {
                print(board[i][j])
            }
            println()
        }
    }

    fun setUpPieces(): List<Piece> {
        var pieceO = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 0)
        var pieceL = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "blue", 0, 0)
        var pieceJ = Piece('J', listOf(listOf(1, 0, 0), listOf(1, 1, 1)), "green", 0, 0)
        var pieceI = Piece('I', listOf(listOf(1), listOf(1), listOf(1), listOf(1)), "yellow", 0, 0)
        var piecesList = listOf(pieceO, pieceL, pieceJ, pieceI)
        return piecesList
    }

    fun getRandomPiece(pieces: List<Piece>): Piece {
        var random = Random.nextInt(0, pieces.size)
        return pieces[random]
    }

    fun placePiece() {
        val pieces = setUpPieces()
        val piece = getRandomPiece(pieces)
        if (canPlacePiece(piece)) {
            //TODO
        }

    }

    fun moveRight(piece: Piece) {
        piece.positionX += 1
    }

    fun moveLeft(piece: Piece) {
        piece.positionX -= 1
    }

    fun dropDown(piece: Piece) {
        piece.positionY += 1
    }

    fun canPlacePiece(piece: Piece): Boolean {
        //TODO: comprobar que no se sale del tablero y que se puede colocar (no choca con otras piezas)
        return true
    }

    fun canMove(piece: Piece): Boolean {
        //TODO: comprobar que no se sale del tablero y que no choca con otras piezas
        return true
    }

    fun isLineComplete(): Boolean {
        //TODO: comprobar si hay una linea completa y eliminarla si la hay
        return true
    }

}