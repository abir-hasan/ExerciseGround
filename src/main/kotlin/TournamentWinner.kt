/**
 * Created By Abir Hasan on 30-Sep-21
 * Problem: Tournament Winner
 * Category: Arrays
 */

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val map = HashMap<String, Int>()

    for ((i, competition) in competitions.withIndex()) {
        val comResult = results[i]
        if (comResult == 0) {
            val awayTeam: String = competition[1]
            if (map.containsKey(awayTeam)) {
                val score: Int = map[awayTeam]!!
                map[awayTeam] = score + 3
            } else {
                map[awayTeam] = 3
            }
        } else {
            val homeTeam: String = competition[0]
            if (map.containsKey(homeTeam)) {
                val score: Int = map[homeTeam]!!
                map[homeTeam] = score + 3
            } else {
                map[homeTeam] = 3
            }
        }
    }

    var maxValue = -1
    var winner = ""
    for ((teamName, score) in map.entries) {
        if (score > maxValue) {
            winner = teamName
            maxValue = score
        }
    }
    return winner
}