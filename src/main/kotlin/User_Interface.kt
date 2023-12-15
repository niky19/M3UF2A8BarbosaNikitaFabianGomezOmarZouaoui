
fun main() {
    val anchoTablero = 12
    val altoTablero = 9
    val tablero = Board(altoTablero, anchoTablero)

    tablero.showBoard()
    var pieza = tablero.getRandomPiece()
    colocarPiezaEnTablero(tablero, pieza, 5, 3)

    tablero.showBoard()
}

fun colocarPiezaEnTablero(tablero: Board, pieza: Piece, x: Int, y: Int) {
    pieza.positionX=x
    pieza.positionY=y
    tablero.placePiece(pieza)
}

