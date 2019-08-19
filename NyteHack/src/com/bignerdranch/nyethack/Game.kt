package com.bignerdranch.nyethack

fun main() {

//    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
//
//    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

//    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
//    println("$name $healthStatus")
    val player = Player("Madrigal", 89, true, false)
    player.castFireball()
    printPlayerStatus(player)


//    val statusString = "player: ${player.name} (HP: $healthPoints)(Aura: $auraColor) -> $healthStatus"
//    com.bignerdranch.nyethack.castFireball()
//    println(statusString)
}

//private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
//    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
//    val auraColor = if (auraVisible) "GREEN" else "NONE"
//    return auraColor
//}

//private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean): String {
//    val healthStatus = when (healthPoints) {
//        100 -> "최상의 상태임"
//        in 90..99 -> "약간의 찰과상만 있음"
//        in 75..89 -> if (isBlessed) {
//            "경미한 상처가 있지만 빨리 치유"
//        } else {
//            "경미한 상처만 있음"
//        }
//        in 15..74 -> "많이 다친 것 같음"
//        else -> "최악의 상태임"
//    }
//    return healthStatus
//}

private fun printPlayerStatus(player: Player){
    println("(Aura: ${player.auraColor()}) " +
            "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name}, ${player.formatHealthStatus()}")
}

private fun castFireball(numFireballs: Int = 2)=
    println("한 덩어리의 파이어볼이 나타난다. (x$numFireballs)")
