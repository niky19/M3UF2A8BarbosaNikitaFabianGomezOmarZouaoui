import java.util.*

/**
 *      Class representing the user interface for the game.
 */
class UI {
    // Scanner for user input
    val sc = Scanner(System.`in`)

    /**
     * Starts the game by creating a board and initializing the game.
     */
    fun startGame() {
        val board = createBoard()
        initGame(board)
    }

    /**
     *      Initializes the game.
     * The game continues until the game is over.
     * The user is presented with a menu to choose their next action.
     * After each action, completed lines are removed and the board is displayed.
     *
     * @param board The game board.
     */
    fun initGame(board: Board) {
        while (!board.isGameOver) {
            showMenu()
            // User actions are limited to the range of the available options [1, 3]
            val userNextAction = getIntInRange(1, 3, sc)
            when (userNextAction) {
                1 -> board.showBoard()
                2 -> {
                    placeNextPiece(board)
                    board.showBoard()
                }

                3 -> board.isGameOver = true
            }
            board.removeCompletedLines()

        }
        println(
            """
            ¡Fin del juego!
            Puntuación final: ${board.score}
            Gracias por jugar.
        """.trimIndent()
        )
    }

    /**
     *      Creates a new game board.
     * The user is asked to input the width and height of the board.
     *
     * @return The created game board.
     */
    fun createBoard(): Board {
        println(
            """
            ¡Bienvenido a Tetris!
            Introduce el ancho del tablero:
        """.trimIndent()
        )
        val width = checkInt(sc)
        println("Introduce la altura del tablero:")
        val height = checkInt(sc)
        println(
            """
            Empieza el juego, ¡buena suerte!
        """.trimIndent()
        )
        val board = Board(height, width)
        board.showBoard()
        return board
    }

    /**
     *          Displays the game menu to the user.
     */
    fun showMenu() {
        println(
            """
        Opciones:
        1. Mostrar tablero
        2. Colocar siguiente pieza 
        3. Salir del juego
        """.trimIndent()
        )
    }

    /**
     *      Places the next piece on the board.
     * A random piece is generated and displayed to the user.
     * The user is asked to input the horizontal position of the piece.
     * The piece is then placed on the board.
     *
     * @param board The game board.
     */
    fun placeNextPiece(board: Board) {
    val piece = getRandomPiece()
    piece.showPiece()
    println("Mueve la pieza horizontalmente introduciendo un número entre 1 y ${board.width - piece.getHorizontalSpace() + 1}") // The user is informed of the range of possible positions!
    val maxPosition = board.width - piece.getHorizontalSpace()
    val newPositionX = getIntInRange(1, maxPosition + 1, sc) - 1 // Subtract 1 from user input
    piece.movePositionX(newPositionX)
    board.placePiece(piece)
}
}