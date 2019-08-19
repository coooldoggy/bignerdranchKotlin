package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Tavernyl's Folly"
var playerGold = 10
var playerSilver = 10
/**
 * listOf: 읽기 전용 list
 */
//val com.bignerdranch.nyethack.getPatornList = listOf("Eli", "Mordoc", "Sophie")
val patornList = mutableListOf("Eli", "Mordoc", "Sophie")
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val uniquePatrons = mutableSetOf<String>()
//val com.bignerdranch.nyethack.getPatronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val patronGold = mutableMapOf<String, Double>()

fun main() {
//    var beverage = readLine()?.let {
//        if (it.isNotBlank()){
//            it.capitalize()
//        }else{
//            "맥주"
//        }
//    }
    //not null check
//    var beverage = readLine()!!.capitalize()
//    var beverage = readLine()
//
//    if (beverage != null){
//        beverage = beverage.capitalize()
//    }else{
//        println("beverage 가 null입니다.")
//    }
//
////    beverage = null
//    val beverageServed: String = beverage ?: "맥주"
//    println(beverageServed)
//    com.bignerdranch.nyethack.placeOrder("shandy,Dragon's Breath,5.91")
//    com.bignerdranch.nyethack.placeOrder("elixir,Shirley's Temple,4.12")

//    com.bignerdranch.nyethack.getPatornList.remove("Eli")
//    com.bignerdranch.nyethack.getPatornList.add("Alex")
//    com.bignerdranch.nyethack.getPatornList.add(0, "Alex")
//    com.bignerdranch.nyethack.getPatornList[0] = "Alexis"
//
//
//    println(com.bignerdranch.nyethack.getPatornList)
//
//    for (patron in com.bignerdranch.nyethack.getPatornList) {
//        println("좋은 밤입니다, $patron 님")
//    }
//
//    com.bignerdranch.nyethack.getPatornList.forEach { patron ->
//        println("좋은 밤입니다, $patron 님")
//    }

//    com.bignerdranch.nyethack.getPatornList.forEachIndexed{ index, patron ->
//        println("좋은 밤입니다, $patron 님 - 당신은 #${index + 1} 번째입니다.")
//        com.bignerdranch.nyethack.placeOrder(patron, com.bignerdranch.nyethack.getMenuList.shuffled().first())
//    }
//
//    com.bignerdranch.nyethack.getMenuList.forEachIndexed{index, data ->
//        println("$index : $data")
//    }

    (0..9).forEach{
        val first = patornList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    println(uniquePatrons)

    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9){
        placeOrder(
            uniquePatrons.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
    }

    displayPatronBalances()


//    println(com.bignerdranch.nyethack.getPatronGold)
//    println(com.bignerdranch.nyethack.getPatronGold["Eli"])
//    println(com.bignerdranch.nyethack.getPatronGold["Mordoc"])
//    println(com.bignerdranch.nyethack.getPatronGold["Sophie"])


    /**
     * 읽기 전용 list로 변경하기
     */
    val readOnlyPatronLsit = patornList.toList()



    println(patornList.getOrElse(4) {
        "Unknown Patron"
    })
    if (patornList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("술집주인이 말한다: 네, 모두 있어요.")
    } else {
        println("술집주인이 말한다: 아니오, 나간 사람도 있습니다.")
    }
}

//fun com.bignerdranch.nyethack.performPurchase(price: Double) {
//    com.bignerdranch.nyethack.displayBalance()
//    val totalPurse = com.bignerdranch.nyethack.getPlayerGold + (com.bignerdranch.nyethack.getPlayerSilver / 100.0)
//    println("지갑 전체 금액: 금화 $totalPurse")
//    println("금화 $price 로 술을 구입함")
//    val remainingBalance = totalPurse - price
//    println("남은 잔액: ${"%.2f".format(remainingBalance)}")
//
//    val remainingGold = remainingBalance.toInt()
//    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//    com.bignerdranch.nyethack.getPlayerGold = remainingGold
//    com.bignerdranch.nyethack.getPlayerSilver = remainingSilver
//    com.bignerdranch.nyethack.displayBalance()
//}

fun performPurchase(price: Double,patronName: String){
    val totalPurchase = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurchase - price
}

private fun displayBalance() {
    println("플레이어의 지갑 잔액: 금화: $playerGold 개, 은화: $playerSilver 개")
}

private fun displayPatronBalances(){
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName 은 $tavernMaster 에게 주문한다.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]
    val (type, name, price) = menuData.split(',')
    val message = "$patronName 은 금화 $price 로 $name ($type)를 구입한다."
    println(message)

    performPurchase(price.toDouble(), patronName)

//    val phrase = "와, $name 진짜 좋구나!"
//    println("마드리같이 감탄한다: ${com.bignerdranch.nyethack.toDragonSpeak(phrase)}")

    val phrase = if (name == "Dragon's Breath") {
        "$patronName 이 감탄한다: ${toDragonSpeak("와, $name 진짜 좋구나!")}"
    } else {
        "$patronName 이 말한다: 감사합니다 $name"
    }

    println(phrase)

}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
    }
