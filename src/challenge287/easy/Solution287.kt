package challenge287.easy

/**
 * Created by philipe on 15/10/16.
 */

class Solution287 {

    fun descendingDigits(number: Int): Int = splitNumber(number).let {
        return it
                .sorted()
                .numberToPowerOfIndex()
    }

    fun ascendantDigits(number: Int): Int = splitNumber(number).let {
        return it
                .sortedDescending()
                .numberToPowerOfIndex()

    }

    fun List<Int>.numberToPowerOfIndex() = this.foldRightIndexed(0) { index, next, accumulator ->
        accumulator + next * Math.pow(10.0, index.toDouble()).toInt()
    }


    private fun splitNumber(number: Int) = listOf(
            number % 10,
            (number % 100) / 10,
            (number % 1000) / 100,
            number / 1000
    )

    fun kaprekarIterations(number: Int): Int {
        var count = 0
        var result = number

        while (result != 6174) {
            result = kaprekar(result)
            count++
        }
        return count
    }

    private fun kaprekar(number: Int) = (descendingDigits(number) - ascendantDigits(number))
}
