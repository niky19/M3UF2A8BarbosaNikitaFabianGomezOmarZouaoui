import java.util.Scanner
import kotlin.random.Random

class Piece(val name: Char, val shape: List<List<Int>>, val color: String, var positionY: Int, var positionX: Int) {

    fun movePositionX(newPositionX: Int) {
        positionX = newPositionX
    }

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

    fun getHorizontalSpace(): Int {
        var maxHorizontalSpace = 0
        for (i in 0 until shape.size) {
            if (shape[i].sum() > maxHorizontalSpace) {
                maxHorizontalSpace = shape[i].sum()
            }
        }
        return maxHorizontalSpace
    }
}

