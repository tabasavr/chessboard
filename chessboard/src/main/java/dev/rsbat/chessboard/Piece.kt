package dev.rsbat.chessboard

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * Enum used for defining the board
 * @param drawableRes piece icon resource
 * @param descriptionRes text description resource
 */
enum class Piece(@DrawableRes val drawableRes: Int, @StringRes val descriptionRes: Int) {
    /** No piece **/
    None(R.drawable.ic_chess_none, R.string.piece_none),

    /** White bishop **/
    BishopWhite(R.drawable.ic_chess_blt45, R.string.piece_white_bishop),
    /** White king **/
    KingWhite(R.drawable.ic_chess_klt45, R.string.piece_white_king),
    /** White knight **/
    KnightWhite(R.drawable.ic_chess_nlt45, R.string.piece_white_knight),
    /** White pawn **/
    PawnWhite(R.drawable.ic_chess_plt45, R.string.piece_white_pawn),
    /** White queen **/
    QueenWhite(R.drawable.ic_chess_qlt45, R.string.piece_white_queen),
    /** White rook **/
    RookWhite(R.drawable.ic_chess_rlt45, R.string.piece_white_rook),

    /** Black bishop **/
    BishopBlack(R.drawable.ic_chess_bdt45, R.string.piece_black_bishop),
    /** Black king **/
    KingBlack(R.drawable.ic_chess_kdt45, R.string.piece_black_king),
    /** Black knight **/
    KnightBlack(R.drawable.ic_chess_ndt45, R.string.piece_black_knight),
    /** Black pawn **/
    PawnBlack(R.drawable.ic_chess_pdt45, R.string.piece_black_pawn),
    /** Black queen **/
    QueenBlack(R.drawable.ic_chess_qdt45, R.string.piece_black_queen),
    /** Black rook **/
    RookBlack(R.drawable.ic_chess_rdt45, R.string.piece_black_rook),
}
