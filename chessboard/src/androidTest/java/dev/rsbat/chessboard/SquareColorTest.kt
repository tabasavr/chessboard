package dev.rsbat.chessboard

import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toPixelMap
import androidx.compose.ui.test.captureToImage
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import org.junit.Assert.assertEquals

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class SquareColorTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    private val emptyBoard = Array(8) { Array(8) { Piece.None } }

    private val lightSquares = listOf(
        0 to 0, 0 to 2, 0 to 4, 0 to 6,
        1 to 1, 1 to 3, 1 to 5, 1 to 7,
        2 to 0, 2 to 2, 2 to 4, 2 to 6,
        3 to 1, 3 to 3, 3 to 5, 3 to 7,
        4 to 0, 4 to 2, 4 to 4, 4 to 6,
        5 to 1, 5 to 3, 5 to 5, 5 to 7,
        6 to 0, 6 to 2, 6 to 4, 6 to 6,
        7 to 1, 7 to 3, 7 to 5, 7 to 7,
    )

    private val darkSquares = listOf(
        0 to 1, 0 to 3, 0 to 5, 0 to 7,
        1 to 0, 1 to 2, 1 to 4, 1 to 6,
        2 to 1, 2 to 3, 2 to 5, 2 to 7,
        3 to 0, 3 to 2, 3 to 4, 3 to 6,
        4 to 1, 4 to 3, 4 to 5, 4 to 7,
        5 to 0, 5 to 2, 5 to 4, 5 to 6,
        6 to 1, 6 to 3, 6 to 5, 6 to 7,
        7 to 0, 7 to 2, 7 to 4, 7 to 6,
    )

    @Test
    @SdkSuppress(minSdkVersion = 26)
    fun lightSquaresDefaultColoredCorrectly() {
        composeTestRule.setContent {
            Board(boardData = emptyBoard)
        }

        val expectedColor = Color(0xfff5f5dc)
        checkColors(lightSquares, expectedColor)
    }

    @Test
    @SdkSuppress(minSdkVersion = 26)
    fun lightSquaresCustomColoredCorrectly() {
        val expectedColor = Color(0xFFBB00FF)

        composeTestRule.setContent {
            Board(boardData = emptyBoard, lightColor = expectedColor)
        }

        checkColors(lightSquares, expectedColor)
    }

    @Test
    @SdkSuppress(minSdkVersion = 26)
    fun darkSquaresDefaultColoredCorrectly() {
        composeTestRule.setContent {
            Board(boardData = emptyBoard)
        }

        val expectedColor = Color(0xff81613C)
        checkColors(darkSquares, expectedColor)
    }

    @Test
    @SdkSuppress(minSdkVersion = 26)
    fun darkSquaresCustomColoredCorrectly() {
        val expectedColor = Color(0xFFBB00FF)

        composeTestRule.setContent {
            Board(boardData = emptyBoard, darkColor = expectedColor)
        }

        checkColors(darkSquares, expectedColor)
    }

    @RequiresApi(26)
    private fun checkColors(positions: List<Pair<Int, Int>>, color: Color) {
        for ((row, col) in positions) {
            val square = composeTestRule.onNodeWithTag("row $row col $col").captureToImage()
            val screenshotColor = square.toPixelMap()[square.width / 2, square.height / 2]
            assertEquals("Square $row $col", color, screenshotColor)
        }
    }
}
