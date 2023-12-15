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
        var pieceO = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 5)
        var pieceL = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "blue", 0, 5)
        var pieceJ = Piece('J', listOf(listOf(1, 0, 0), listOf(1, 1, 1)), "green", 0, 5)
        var pieceI = Piece('I', listOf(listOf(1), listOf(1), listOf(1), listOf(1)), "yellow", 0, 5)
        var piecesList = listOf(pieceO, pieceL, pieceJ, pieceI)
        return piecesList
    }

    fun getRandomPiece(): Piece {
        val pieces = setUpPieces()
        var random = Random.nextInt(0, pieces.size)
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
      var  myPositionY : Int
        for (i in board.indices) {
            for (j in 0..board[i].size) {
                if(j in piece.positionX..piece.positionX+ piece.shape.lastIndex){
                    myPositionY = j - piece.positionX
                    if(board[i][myPositionY] == 1){
                        return j+1
                    }
                }
            }
        }
        return 0
    }



    fun isLineComplete(): Boolean {
        //TODO: comprobar si hay una linea completa y eliminarla si la hay
        return true
    }

}
fun getPiecePositionY(piece: Piece) {
    //TODO: hacer una funcion que calcule la altura de mi pieza (dado una X tienes que ver donde esta el limite que la puedes poner(la primera q choqe o el final del tablero)
//flujo : mover derecha/izq haciendo la comprobacion y despues encontrar la posicion de la Y de la pieza, despues ponerla y revisar si hay q el;iminar alguna linea

}


fun main() {
    val myBoard = Board(9, 12)
    myBoard.showBoard()
    var piece = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 5)
    println(piece)
    println(myBoard.getPiecePositionY(piece))

}