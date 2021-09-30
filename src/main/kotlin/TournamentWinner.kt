/**
 * Created By Abir Hasan on 30-Sep-21
 * Problem: Tournament Winner
 * Category: Arrays
 */

fun tournamentWinner(competitions: List<List<String>>, results: List<Int>): String {
    val map = HashMap<String, Int>()

    var maxValue = -1
    var winner = ""

    for ((i, competition) in competitions.withIndex()) {
        val comResult = results[i]
        if (comResult == 0) {
            val awayTeam: String = competition[1]
            if (map.containsKey(awayTeam)) {
                val score: Int = map[awayTeam]!! + 3
                map[awayTeam] = score
                if (score > maxValue) {
                    winner = awayTeam
                    maxValue = score
                }
            } else {
                map[awayTeam] = 3
                if (3 > maxValue) {
                    winner = awayTeam
                    maxValue = 3
                }
            }
        } else {
            val homeTeam: String = competition[0]
            if (map.containsKey(homeTeam)) {
                val score: Int = map[homeTeam]!! + 3
                map[homeTeam] = score
                if (score > maxValue) {
                    winner = homeTeam
                    maxValue = score
                }
            } else {
                map[homeTeam] = 3
                if (3 > maxValue) {
                    winner = homeTeam
                    maxValue = 3
                }
            }
        }
    }
    return winner
}

fun main() {
    val winner = tournamentWinner(
        arrayListOf(
            arrayListOf("HTML", "C#"),
            arrayListOf("C#", "Python"),
            arrayListOf("Python", "HTML")
        ),
        mutableListOf(0, 0, 1)
    )
    println(winner)
}

fun tournamentWinnerAnotherSolution(
    competitions: List<List<String>>,
    results: List<Int>
): String {
    val HOME_TOWN_WON = 1
    val POINTS_ACHIEVED = 3
    var currentBestTeam = ""
    val scores = mutableMapOf(currentBestTeam to 0)

    for (idx in competitions.indices) {
        val competition = competitions[idx]
        val result = results[idx]
        val (homeTeam, awayTeam) = competition

        val winningTeam = if (result == HOME_TOWN_WON) homeTeam else awayTeam

        updateScores(winningTeam, POINTS_ACHIEVED, scores)

        if (scores[winningTeam]!! > scores[currentBestTeam]!!) currentBestTeam = winningTeam
    }
    return currentBestTeam
}

fun updateScores(
    winningTeam: String,
    pointsAchieved: Int,
    scores: MutableMap<String, Int>
) {
    if (winningTeam !in scores) scores[winningTeam] = 0
    scores[winningTeam] = scores[winningTeam]!! + pointsAchieved
}
