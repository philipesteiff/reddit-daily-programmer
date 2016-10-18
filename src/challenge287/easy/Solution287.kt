package challenge287.easy

/**
 * Created by philipe on 15/10/16.
 */

class Solution287 {

    fun largestDigit(number: Int): Int = splitNumber(number).let {
        return it
                .sorted()
                .foldRightIndexed(0) { index, next, accumulator ->
                    accumulator + next * (Math.pow(10.0, index.toDouble())).toInt()
                }
    }

    private fun splitNumber(number: Int) = listOf(
            number % 10,
            (number % 100) / 10,
            (number % 1000) / 100,
            number / 1000
    )

    private fun countKaprekar() {

    }
}
