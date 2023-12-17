/**
 *      Class representing a game piece.
 * @authors Nikita Barbosa, Omar Zouaoui, Fabián Gómez
 * @property name The name of the piece.
 * @property shape The shape of the piece represented as a 2D list.
 * @property color The color of the piece.
 * @property positionY The Y position of the piece on the board.
 * @property positionX The X position of the piece on the board.
 *
 */
class Piece(val name: Char, val shape: List<List<Int>>, val color: String, var positionY: Int, var positionX: Int) {

    /**
     *      Moves the piece horizontally.
     *
     * @param newPositionX The new X position of the piece.
     */
    fun movePositionX(newPositionX: Int) {
        positionX = newPositionX
    }

    /**
     *      Prints the current state of the piece to the console.
     * Iterates over the piece's shape matrix.
     * Filled cells are represented by the piece's color.
     */
    fun showPiece() {
        for (i in 0 until shape.size) {
            for (j in 0 until shape[i].size) {
                if (shape[i][j] == 1) {
                    print(color)
                }
            }
            println()
        }
        println()
    }

    /**
     *      Determines the horizontal space occupied by the piece.
     * The function checks each row of the piece's shape and returns the maximum sum of the row's cells.
     *
     * @return The horizontal space occupied by the piece.
     */
    fun getHorizontalSpace(): Int {
        var maxHorizontalSpace = 0
        for (i in 0..<shape.size) {
            if (shape[i].sum() > maxHorizontalSpace) {
                maxHorizontalSpace = shape[i].sum()
            }
        }
        return maxHorizontalSpace
    }
}