import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class UITest {

    @Test
    fun `showMenu should display the game menu`() {
        val ui = UI()
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        ui.showMenu()

        val output = outputStream.toString()
        assertTrue(output.contains("Opciones"))
        assertTrue(output.contains("Mostrar tablero"))
        assertTrue(output.contains("Colocar siguiente pieza"))
        assertTrue(output.contains("Salir del juego"))

        System.setOut(System.out)
    }

    @Test
    fun `showMenu should handle user input for displaying the board`() {
        val ui = UI()
        val inputStream = ByteArrayInputStream("2".toByteArray())
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        ui.showMenu()

        val output = outputStream.toString()
        assertTrue(output.contains("Mostrar tablero"))

        System.setIn(System.`in`)
        System.setOut(System.out)
    }

    @Test
    fun `showMenu should handle user input for placing a piece`() {
        val ui = UI()
        val inputStream = ByteArrayInputStream("3".toByteArray())
        System.setIn(inputStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        ui.showMenu()

        val output = outputStream.toString()
        assertTrue(output.contains("Colocar siguiente pieza"))

        System.setIn(System.`in`)
        System.setOut(System.out)
    }

    @Test
    fun `createBoard should display good luck message`() {
        val systemIn = System.`in`
        val input = "\n\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        try {
            val ui = UI()
            ui.createBoard()

            val output = outputStream.toString()
            assertTrue(output.contains("Buena suerte"))
        } finally {
            System.setIn(systemIn)
            System.setOut(System.out)
        }
    }

    @Test
    fun `createBoard should handle user input for custom board dimensions`() {
        val systemIn = System.`in`
        val input = "5\n4\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        try {
            val ui = UI()
            ui.createBoard()

            // Additional assertions based on the logic of your application
        } finally {
            System.setIn(systemIn)
        }
    }

    @Test
    fun `createBoard should return a valid Board object`() {
        val input = "5\n4\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val ui = UI()
        val board = ui.createBoard()

        assertNotNull(board)
        assertEquals(5, board.width)
        assertEquals(4, board.height)

        System.setIn(System.`in`)
    }
}
