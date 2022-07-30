package dev.rsbat.chessboard

import androidx.annotation.DrawableRes
import dev.rsbat.chessboard.R

enum class Piece(@DrawableRes val drawableRes: Int) {
    None(R.drawable.ic_chess_none),

    BishopWhite(R.drawable.ic_chess_blt45),
    KingWhite(R.drawable.ic_chess_klt45),
    KnightWhite(R.drawable.ic_chess_nlt45),
    PawnWhite(R.drawable.ic_chess_plt45),
    QueenWhite(R.drawable.ic_chess_qlt45),
    RookWhite(R.drawable.ic_chess_rlt45),

    BishopBlack(R.drawable.ic_chess_bdt45),
    KingBlack(R.drawable.ic_chess_kdt45),
    KnightBlack(R.drawable.ic_chess_ndt45),
    PawnBlack(R.drawable.ic_chess_pdt45),
    QueenBlack(R.drawable.ic_chess_qdt45),
    RookBlack(R.drawable.ic_chess_rdt45),
}
