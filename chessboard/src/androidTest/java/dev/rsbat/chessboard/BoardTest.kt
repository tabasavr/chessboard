package dev.rsbat.chessboard

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toPixelMap
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class BoardTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val emptyBoard = Array(8) { Array(8) { Piece.None } }

    @Test
    fun lightSquaresColoredCorrectly() {
        composeTestRule.setContent {
            Board(boardData = emptyBoard)
        }

        val expectedColor = Color(0xfffef5e4)
        val lightSquares = listOf(
            0 to 0, 0 to 2, 0 to 4, 0 to 6,
            1 to 1, 1 to 3, 1 to 5, 1 to 7,
            2 to 0, 2 to 2, 2 to 4, 2 to 6,
            3 to 1, 3 to 3, 3 to 5, 3 to 7,
            4 to 0, 4 to 2, 4 to 4, 4 to 6,
            5 to 1, 5 to 3, 5 to 5, 5 to 7,
            6 to 0, 6 to 2, 6 to 4, 6 to 6,
            7 to 1, 7 to 3, 7 to 5, 7 to 7,
        )
        for ((row, col) in lightSquares) {
            val square = composeTestRule.onNodeWithTag("row $row col $col").captureToImage()
            assertEquals("Square $row $col", expectedColor, square.toPixelMap()[100, 100])
        }
    }

    @Test
    fun darkSquaresColoredCorrectly() {
        composeTestRule.setContent {
            Board(boardData = emptyBoard)
        }

        val expectedColor = Color(0xFF533F26)
        val darkSquares = listOf(
            0 to 1, 0 to 3, 0 to 5, 0 to 7,
            1 to 0, 1 to 2, 1 to 4, 1 to 6,
            2 to 1, 2 to 3, 2 to 5, 2 to 7,
            3 to 0, 3 to 2, 3 to 4, 3 to 6,
            4 to 1, 4 to 3, 4 to 5, 4 to 7,
            5 to 0, 5 to 2, 5 to 4, 5 to 6,
            6 to 1, 6 to 3, 6 to 5, 6 to 7,
            7 to 0, 7 to 2, 7 to 4, 7 to 6,
        )
        for ((row, col) in darkSquares) {
            val cell = composeTestRule.onNodeWithTag("row $row col $col").captureToImage()
            assertEquals("Square $row $col", expectedColor, cell.toPixelMap()[100, 100])
        }
    }
}
