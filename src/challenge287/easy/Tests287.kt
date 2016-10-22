package challenge287.easy

import org.junit.Test

/**
 * Created by philipe on 15/10/16.
 */

/**
link: https://www.reddit.com/r/dailyprogrammer/comments/56tbds/20161010_challenge_287_easy_kaprekars_routine/

Description

Write a function that, given a 4-digit number, returns the largest digit in that number. Numbers between 0 and 999 are counted as 4-digit numbers with leading 0's.
largest_digit(1234) -> 4
largest_digit(3253) -> 5
largest_digit(9800) -> 9
largest_digit(3333) -> 3
largest_digit(120) -> 2
In the last example, given an input of 120, we treat it as the 4-digit number 0120.
Today's challenge is really more of a warmup for the bonuses. If you were able to complete it, I highly recommend giving the bonuses a shot!

Bonus 1

Write a function that, given a 4-digit number, performs the "descending digits" operation. This operation returns a number with the same 4 digits sorted in descending order.
desc_digits(1234) -> 4321
desc_digits(3253) -> 5332
desc_digits(9800) -> 9800
desc_digits(3333) -> 3333
desc_digits(120) -> 2100

Bonus 2

Write a function that counts the number of iterations in Kaprekar's Routine, which is as follows.
Given a 4-digit number that has at least two different digits, take that number's descending digits, and subtract that number's ascending digits. For example, given 6589, you should take 9865 - 5689, which is 4176. Repeat this process with 4176 and you'll get 7641 - 1467, which is 6174.
Once you get to 6174 you'll stay there if you repeat the process. In this case we applied the process 2 times before reaching 6174, so our output for 6589 is 2.
kaprekar(6589) -> 2
kaprekar(5455) -> 5
kaprekar(6174) -> 0
Numbers like 3333 would immediately go to 0 under this routine, but since we require at least two different digits in the input, all numbers will eventually reach 6174, which is known as Kaprekar's Constant. Watch this video if you're still unclear on how Kaprekar's Routine works.
What is the largest number of iterations for Kaprekar's Routine to reach 6174? That is, what's the largest possible output for your kaprekar function, given a valid input? Post the answer along with your solution.
 */

import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.*

class Tests287 {

    @Test
    fun testLargestDigit() {
        with(Solution287()) {
            assertThat(largestDigit(1234), equalTo(4))
            assertThat(largestDigit(3253), equalTo(5))
            assertThat(largestDigit(9800), equalTo(9))
            assertThat(largestDigit(3333), equalTo(3))
            assertThat(largestDigit(120), equalTo(2))
        }
    }

    @Test
    fun testDescendingDigits() {
        with(Solution287()) {
            assertThat(descendingDigits(1234), equalTo(4321))
            assertThat(descendingDigits(3253), equalTo(5332))
            assertThat(descendingDigits(9800), equalTo(9800))
            assertThat(descendingDigits(3333), equalTo(3333))
            assertThat(descendingDigits(120), equalTo(2100))
        }
    }

    @Test
    fun testAscendantDigits() {
        with(Solution287()) {
            assertThat(ascendantDigits(1234), equalTo(1234))
            assertThat(ascendantDigits(3253), equalTo(2335))
            assertThat(ascendantDigits(9800), equalTo(89))
            assertThat(ascendantDigits(3333), equalTo(3333))
            assertThat(ascendantDigits(120), equalTo(12))
        }
    }

    @Test(timeout = 100)
    fun testKaprekarInteractionCount() {
        with(Solution287()) {
            assertThat(kaprekarIterationCount(6589), equalTo(2))
            assertThat(kaprekarIterationCount(5455), equalTo(5))
            assertThat(kaprekarIterationCount(6174), equalTo(0))
            assertThat(kaprekarIterationCount(3333), equalTo(0))
        }
    }
}