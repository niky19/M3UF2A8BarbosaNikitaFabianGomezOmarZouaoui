import java.util.*

fun main() {
    val anchoTablero = 12
    val altoTablero = 9
    val tablero = Board(altoTablero, anchoTablero)

    println("¡Bienvenido a Tetris!")

    val scanner = Scanner(System.`in`)

    var continuarJuego = true

    do {
        println("Menú:")
        println("1. Mostrar Tablero")
        println("2. Colocar Pieza Aleatoria")
        println("3. Salir")

        print("Ingresa tu elección: ")
        val opcion = scanner.nextLine()

        when (opcion) {
            "1" -> mostrarTablero(tablero)
            "2" -> colocarPiezaAleatoria(tablero, scanner)
            "3" -> {
                println("Gràcies per jugar! Fins aviat!")
                continuarJuego = false
            }
            else -> println("Opción no vàlida. Ingresa un número del 1 al 3")
        }
    } while (continuarJuego)
}

fun mostrarTablero(tablero: Board) {
    println("Tauler actual:")
    tablero.showBoard()
}

fun colocarPiezaAleatoria(tablero: Board, scanner: Scanner) {
    val pieza = tablero.getRandomPiece()

    print("Ingresa la posició X per la peça aleatoria: ")
    val x = scanner.nextLine().toInt()

    print("Ingresa la posició Y per la peça aleatoria: ")
    val y = scanner.nextLine().toInt()

    println("colocant peça a la posició ($x, $y)")
    tablero.placePiece(pieza)
    tablero.showBoard()
}
