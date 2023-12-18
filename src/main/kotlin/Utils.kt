import java.util.*
import kotlin.random.Random

/**
 *      Contains utility functions used in the game.
 * The functions are static and can be called from any class.
 * @authors Nikita Barbosa, Omar Zouaoui, Fabián Gómez.
 */

/**
 *     Checks if the user input is an int.
 * If the input is not an int, the user is asked to input a new value.
 * @param sc Scanner for user input.
 */
// En Utils.kt

fun checkInt(sc: Scanner): Int {
    while (true) {
        if (sc.hasNextInt()) {
            return sc.nextInt()
        } else {
            println("Inválido: no es un número. Introduce un número:")
            sc.next()
        }
    }
}


/**
 *    Checks if the user input is an int within a given range.
 * If the input is not an int or is not within the range, the user is asked to input a new value.
 * @param startInt The lower bound of the range.
 * @param endInt The upper bound of the range.
 */
fun getIntInRange(startInt: Int, endInt: Int, sc: Scanner): Int {
    while (true) {
        if (sc.hasNextInt()) {
            val userNumber = sc.nextInt()
            if (userNumber in startInt..endInt) {
                return userNumber
            }
            println("Inválido: no está en el rango. Introduce un número entre $startInt y $endInt:")
        } else {
            println("Inválido: no es un entero. Introduce un número entre $startInt y $endInt:")
            sc.next()
        }
    }
}

/**
 *          Represents the pieces available in the game using a list of Piece objects.
 * This function is inside Utils and not in the Piece class because it doesn't need to be called from the Piece class.
 * @return A list of Piece objects.
 */
fun setUpPieces(): List<Piece> {
    val pieceO = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "\uD83D\uDFE9", 0, 5)
    val pieceL = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "\uD83D\uDFE6", 0, 5)
    val pieceJ = Piece('J', listOf(listOf(1, 0, 0), listOf(1, 1, 1)), "\uD83D\uDFE7", 0, 5)
    val pieceI = Piece('I', listOf(listOf(1), listOf(1), listOf(1), listOf(1)), "\uD83D\uDFE8", 0, 5)
    val piecesList = listOf(pieceO, pieceL, pieceJ, pieceI)
    return piecesList
}

/**
 *         Generates a random piece from the list of pieces.
 * @return A random piece.
 */
fun getRandomPiece(): Piece {
    val pieces = setUpPieces()
    val random = Random.nextInt(0, pieces.size) //Random number between 0 and the number of pieces in the list
    return pieces[random]
}

