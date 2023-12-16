import java.util.*

//fun main() {
//    val anchoTablero = 12
//    val altoTablero = 9
//    val tablero = Board(altoTablero, anchoTablero)
//
//    println("¡Bienvenido a Tetris!")
//
//    val scanner = Scanner(System.`in`)
//
//    var continuarJuego = true
//
//    do {
//        println("Menú:")
//        println("1. Mostrar Tablero")
//        println("2. Colocar Pieza Aleatoria")
//        println("3. Salir")
//
//        print("Ingresa tu elección: ")
//        val opcion = scanner.nextLine()
//
//        when (opcion) {
//            "1" -> mostrarTablero(tablero)
//            "2" -> colocarPiezaAleatoria(tablero, scanner)
//            "3" -> {
//                println("Gràcies per jugar! Fins aviat!")
//                continuarJuego = false
//            }
//            else -> println("Opción no vàlida. Ingresa un número del 1 al 3")
//        }
//    } while (continuarJuego)
//}

class User_Interface() {
    val sc = Scanner(System.`in`)

    fun startGame() {
        val board = createBoard()
        initGame(board)
    }

    private fun initGame(board: Board) {
        println("El juego ha empezado!")
        while (!board.isGameOver){
            showMenu()
            val userNextAction = getIntInRange(1,3,sc)
            when (userNextAction) {
                1 -> board.showBoard()
                2 -> placeNextPiece(board)
                3 -> board.isGameOver = true
            }
            board.removeCompletedLines()
            board.showBoard()
        }
        println("Gràcies per jugar! Fins aviat!")
    }



    private fun createBoard() : Board{
        println("¡Bienvenido a Tetris!")
        println("Para comenzar elija el ancho del tablero")
        val width = checkInt(sc)
        println("Ahora el alto del tablero")
        val height = checkInt(sc)
        println("Tu tablero ha sido configurado correctamente")
        val board = Board(height, width)
        board.showBoard()
        return board
    }

    private fun showMenu() {
         println("Menú:")
         println("1. Mostrar Tablero")
         println("2. Colocar Pieza Aleatoria")
         println("3. Salir")
    }

    private fun placeNextPiece(board: Board) {
        val piece = getRandomPiece()
        piece.showPiece()
        println("Cuant vols moure la peza en horizontal cap a la dreta?")
        val maxPosition = board.width - piece.getHorizontalSpace()
        val newPositionX = getIntInRange(0,maxPosition, sc)
        piece.movePositionX(newPositionX)
        board.placePiece(piece)
    }
}



