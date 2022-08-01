package dev.rsbat.chessboard

import androidx.annotation.DrawableRes
import dev.rsbat.chessboard.R

/**
 * Enum used for defining the board
 */
enum class Piece(@DrawableRes val drawableRes: Int) {
    /** No piece **/
    None(R.drawable.ic_chess_none),

    /** White bishop **/
    BishopWhite(R.drawable.ic_chess_blt45),
    /** White king **/
    KingWhite(R.drawable.ic_chess_klt45),
    /** White knight **/
    KnightWhite(R.drawable.ic_chess_nlt45),
    /** White pawn **/
    PawnWhite(R.drawable.ic_chess_plt45),
    /** White queen **/
    QueenWhite(R.drawable.ic_chess_qlt45),
    /** White rook **/
    RookWhite(R.drawable.ic_chess_rlt45),

    /** Black bishop **/
    BishopBlack(R.drawable.ic_chess_bdt45),
    /** Black king **/
    KingBlack(R.drawable.ic_chess_kdt45),
    /** Black knight **/
    KnightBlack(R.drawable.ic_chess_ndt45),
    /** Black pawn **/
    PawnBlack(R.drawable.ic_chess_pdt45),
    /** Black queen **/
    QueenBlack(R.drawable.ic_chess_qdt45),
    /** Black rook **/
    RookBlack(R.drawable.ic_chess_rdt45),
}
