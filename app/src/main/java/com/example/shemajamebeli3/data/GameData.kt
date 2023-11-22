package com.example.shemajamebeli3.data

import com.example.shemajamebeli3.GameType
import com.example.shemajamebeli3.XO

data class GameData(val gameType: GameType) {
    companion object {
        fun generateGameData(gameType: GameType): List<XO> {
            return when (gameType) {
                GameType.GAME9 -> List(9) { index -> XO(index, false, xPlayer = false) }
                GameType.GAME16 -> List(16) { index -> XO(index, false, xPlayer = false) }
                GameType.GAME25 -> List(25) { index -> XO(index, false, xPlayer = false) }
            }
        }
    }

}
