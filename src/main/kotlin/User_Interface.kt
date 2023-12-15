// en este archivo van las funciones relacionadas con la interfaz e interracción del usuario

fun mostrarTablero(tablero: Array<Array<String>>) {
    for (fila in tablero) {
        for (casilla in fila) {
            print("$casilla ")
        }
        println()
    }
}

fun main() {
    val anchoTablero = 10
    val altoTablero = 20
    val tablero = Array(altoTablero) { Array(anchoTablero) { "." } }


    val pieza = arrayOf(
        arrayOf("X", "X"),
        arrayOf("X", "X")
    )


    colocarPiezaEnTablero(tablero, pieza, 2, 3)


    mostrarTablero(tablero)
}

fun colocarPiezaEnTablero(tablero: Array<Array<String>>, pieza: Array<Array<String>>, x: Int, y: Int) {
    for (i in pieza.indices) {
        for (j in pieza[i].indices) {
            if (pieza[i][j] == "X") {
                tablero[y + i][x + j] = "X"
            }
        }
    }
}
