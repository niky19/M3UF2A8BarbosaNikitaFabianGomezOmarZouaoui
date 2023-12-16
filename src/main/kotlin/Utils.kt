import java.util.*
import kotlin.random.Random

//Comprobación de input de tipo Int
fun checkInt(sc: Scanner): Int {
    while (true) {
        println("Introdueix un enter:")
        if (sc.hasNextInt()) {
            return sc.nextInt()
        } else {
            println("No és un enter. Introdueix un enter:")
            sc.next()
        }
    }
}
//Obtener un int en un rango dado
fun getIntInRange(startInt: Int, endInt: Int, sc: Scanner): Int {
    while (true) {
        if (sc.hasNextInt()) {
            val userNumber = sc.nextInt()
            if(userNumber in startInt..endInt){
                return userNumber
            }
            println("Enter no valid, no está en el range")
        } else {
            println("No és un enter. Introdueix un enter:")
            sc.next()
        }
    }
}

fun setUpPieces(): List<Piece> {
    val pieceO = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "\uD83D\uDFE9", 0, 5)
    val pieceL = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "\uD83D\uDFE6", 0, 5)
    val pieceJ = Piece('J', listOf(listOf(1, 0, 0), listOf(1, 1, 1)), "\uD83D\uDFE7", 0, 5)
    val pieceI = Piece('I', listOf(listOf(1), listOf(1), listOf(1), listOf(1)), "\uD83D\uDFE8", 0, 5)
    val piecesList = listOf(pieceO, pieceL, pieceJ, pieceI)
    return piecesList
}

fun getRandomPiece(): Piece {
    val pieces = setUpPieces()
    val random = Random.nextInt(0, pieces.size)
    return pieces[random]
}

