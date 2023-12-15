import kotlin.random.Random

fun main() {
    val myBoard = Board(9, 12)
    var myPiece : Piece = getRandomPiece()
    for(i in 0..4){
        val newPositionY =  myBoard.getPiecePositionY(myPiece)
        if(newPositionY == -1){
            println("Game Over")
            return
        }
        myPiece.positionY = newPositionY
        myBoard.placePiece(myPiece)
        myPiece = getRandomPiece()
    }
    myBoard.showBoard()
}

fun getRandomPiece(): Piece {
    val pieces = setUpPieces()
    val random = Random.nextInt(0, pieces.size)
    return pieces[random]
}

fun setUpPieces(): List<Piece> {
    val pieceO = Piece('O', listOf(listOf(1, 1), listOf(1, 1)), "red", 0, 5)
    val pieceL = Piece('L', listOf(listOf(1, 0), listOf(1, 0), listOf(1, 1)), "blue", 0, 5)
    val pieceJ = Piece('J', listOf(listOf(1, 0, 0), listOf(1, 1, 1)), "green", 0, 5)
    val pieceI = Piece('I', listOf(listOf(1), listOf(1), listOf(1), listOf(1)), "yellow", 0, 5)
    val piecesList = listOf(pieceO, pieceL, pieceJ, pieceI)
    return piecesList
}