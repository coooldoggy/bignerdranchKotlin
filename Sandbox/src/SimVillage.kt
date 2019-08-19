fun main() {

    runSimulation()



    /**
     * 함수 참조
     */
//    runSimulation("김선달", ::printConstructionCost) { playerName, numBuildings ->
//        val currentYear = 2019
//        println("$numBuildings 채의 건물이 추가됨")
//        "SimVillage 방문을 환영합니다!,  $playerName 님! (copyright $currentYear)"
//    }

    /**
     * 단축문법으로 람다 전달
     */
//    runSimulation("김선달") { playerName, numBuildings ->
//        val currentYear = 2019
//        println("$numBuildings 채의 건물이 추가됨")
//        "SimVillage 방문을 환영합니다!,  $playerName 님! (copyright $currentYear)"
//    }

    /**
     * 타입 추론
     */
//    val greetingFunction = { playerName: String, numBuildings: Int ->
//        val currentYear = 2019
//        println("$numBuildings 채의 건물이 추가됨")
//        "SimVillage 방문을 환영합니다!,  $playerName 님! (copyright $currentYear)"
//    }
//    runSimulation("김선달", greetingFunction)

    /**
     * 함수의 인자가 2개일때
     */
//    val greetingFunction: (String, Int) -> String = {playerName, numBuildings->
//        val currentYear = 2019
//        println("$numBuildings 채의 건물이 추가됨")
//        "SimVillage 방문을 환영합니다!, $playerName 님! (copyright $currentYear)"
//    }
//    print(greetingFunction("김선달", 2))

    /**
     * 함수의 인자가 하나일때 it 사용
     */
//    val greetingFunction: (String) -> String = {
//        val currentYear = 2019
//        "SimVillage 방문을 환영합니다!, $it 님! (copyright $currentYear)"
//    }
//    print(greetingFunction("김선달"))

    /**
     * 함수 인자 바로 받기
     */
//    val greetingFunction: (String) -> String = {
//        playername ->
//        val currentYear = 2019
//        "SimVillage 방문을 환영합니다!, $playername 님! (copyright $currentYear)"
//    }
//    print(greetingFunction("김선달"))

//    val greetingFunction: () -> String = {
//        val currentYear = 2019
//        "SimVillage 방문을 환영합니다!, 촌장님! (copyright $currentYear)"
//    }
//    print(greetingFunction())
}

/**
 * 함수를 반환하는 함수
 */
 fun runSimulation() {
    val greetingFunction = configureGreetingFuction()
    println(greetingFunction("김선달"))
}

/**
 * 함수를 반환하는 함수
 */
fun configureGreetingFuction(): (String) -> String{
    val structureType = "병원"
    var numBuildings = 5
    return {
        playerName: String ->
        val currentYear = 2019
        numBuildings += 1
        println("$numBuildings 채의 $structureType 이 추가됨")
        "SimVilliage 방문을 환영합니다, $playerName! (copyright $currentYear)"
    }
}




/**
 * 함수 참조
 */
//inline fun runSimulation(playerName: String,
//                         costPrinter: (Int) -> Unit,
//                         greetingFunction: (String, Int) -> String) {
//    //1,2,3 중 하나를 무작위로 선택한다.
//    val numBuildings = (1..3).shuffled().last()
//    costPrinter(numBuildings)
//    println(greetingFunction(playerName, numBuildings))
//}

/**
 * 함수를 인자로 받는 함수 정의
 */
//inline fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
//    //1,2,3 중 하나를 무작위로 선택한다.
//    val numBuildings = (1..3).shuffled().last()
//    println(greetingFunction(playerName, numBuildings))
//}

fun printConstructionCost(numBuildings: Int){
    val cost = 500
    println("건축비용: ${cost * numBuildings}")
}