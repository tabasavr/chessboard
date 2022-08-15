package dev.rsbat.chessboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

/**
 * Chess board composable
 * @param boardData Description of pieces on the board. First array corresponds to
 * the first row
 * @param modifier Modifier used to adjust the layout algorithm or draw decoration
 * content (ex. background)
 * @param lightColor Background color of light squares. Default is beige/pale yellow green
 * @param darkColor Background color of dark squares. Default is
 * coyote brown/moderate yellowish brown
 */
@Composable
fun Board(
    boardData: Array<Array<Piece>>,
    modifier: Modifier = Modifier,
    lightColor: Color = Color(0xfff5f5dc),
    darkColor: Color = Color(0xff81613C),
) {
    Column(modifier = modifier) {
        for (rowIdx in 7 downTo 0) {
            Row {
                for (colIdx in 0 until 8) {
                    val isLightSquare = (rowIdx + colIdx) % 2 == 0
                    val squareColor = if (isLightSquare) lightColor else darkColor
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .background(squareColor)
                            .let { if (BuildConfig.DEBUG) {
                                it.testTag("row $rowIdx col $colIdx")
                            } else { it } }
                    ) {
                        val piece = boardData[rowIdx][colIdx]
                        Image(
                            painter = painterResource(id = piece.drawableRes),
                            contentDescription = stringResource(piece.descriptionRes),
                            modifier = Modifier.fillMaxSize(),
                            alignment = Alignment.Center,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewEmptyBoard() {
    Board(boardData = Array(8) { Array(8) { Piece.BishopBlack } })
}
