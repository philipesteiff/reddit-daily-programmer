package challenge287.easy

/**
 * Created by philipe on 15/10/16.
 */

class Solution287 {

    val kaprekarConstant: Int = 6174

    fun largestDigit(number: Int) = splitNumber(number).max()

    fun descendingDigits(number: Int) = splitNumber(number)
            .sortedDescending()
            .listToInt()

    fun ascendantDigits(number: Int) = splitNumber(number)
            .sorted()
            .listToInt()

    fun kaprekarIterationCount(number: Int) = when {
        !hasAtLeastTwoDifferentDigits(number) -> 0
        else -> {
            var count = 0
            var result = number

            while (result != kaprekarConstant) {
                result = kaprekar(result)
                count++
            }
            count
        }
    }

    private fun kaprekar(number: Int) = descendingDigits(number) - ascendantDigits(number)

    private fun splitNumber(number: Int) = listOf(
            number % 10,
            (number % 100) / 10,
            (number % 1000) / 100,
            number / 1000
    )

    private fun hasAtLeastTwoDifferentDigits(number: Int) = splitNumber(number)
            .distinct().count() >= 2

    fun List<Int>.listToInt() = this.reduce { total, next -> total * 10 + next }

}
