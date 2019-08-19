package com.bignerdranch.nyethack

import java.io.File

fun main() {

}

class Player(_name: String, var healthPoints: Int = 100, val isBlessed: Boolean, private val isImmortal: Boolean) {
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }

    val hometown by lazy { selectHometown() }

    /**
     * 초기화 블럭
     */
    init {
        require(healthPoints > 0, {"healthPoints는 0보다 커야 합니다."})
        require(name.isNotBlank(), {"플레이어는 이름이 있어야 합니다."})
    }


    /**
     * 보조 생성자
     */
    constructor(name: String) : this(name,
//        healthPoints = 100,
        isBlessed = true,
        isImmortal = false){
        if (name.toLowerCase() == "kar") healthPoints = 40
    }

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun formatHealthStatus(): String {
        val healthStatus = when (healthPoints) {
            100 -> "최상의 상태임"
            in 90..99 -> "약간의 찰과상만 있음"
            in 75..89 -> if (isBlessed) {
                "경미한 상처가 있지만 빨리 치유"
            } else {
                "경미한 상처만 있음"
            }
            in 15..74 -> "많이 다친 것 같음"
            else -> "최악의 상태임"
        }
        return healthStatus
    }

    fun castFireball(numFireballs: Int = 2) = println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")
        .shuffled()
        .first()
}
