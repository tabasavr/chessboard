package dev.rsbat.chessboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview

private const val ROW_COUNT = 8
private const val COL_COUNT = 8

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
@Suppress("FunctionNaming")
@Composable
fun Board(
    boardData: Array<Array<Piece>>,
    modifier: Modifier = Modifier,
    @Suppress("MagicNumber")
    lightColor: Color = Color(0xfff5f5dc),
    @Suppress("MagicNumber")
    darkColor: Color = Color(0xff81613C),
) {
    var foo: String? = null
    foo!!
    Column(modifier = modifier) {
        for (rowIdx in (0 until ROW_COUNT).reversed()) {
            Row {
                for (colIdx in 0 until COL_COUNT) {
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

@Suppress("FunctionNaming")
@Composable
@Preview
fun PreviewEmptyBoard() {
    Board(boardData = Array(ROW_COUNT) { Array(COL_COUNT) { Piece.BishopBlack } })
}
