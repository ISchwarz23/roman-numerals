import org.jetbrains.spek.api.Spek
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.fail

/**
 * Test specification checking the correctness of the RomanNumberTransformer.
 * @author ISchwarz
 */
class RomanNumberTransformerSpec : Spek({

    val testParams: Array<Pair<Int, String>> = arrayOf(
            Pair(1, "I"),
            Pair(2, "II"),
            Pair(3, "III"),
            Pair(4, "IV"),
            Pair(5, "V"),
            Pair(6, "VI"),
            Pair(7, "VII"),
            Pair(8, "VIII"),
            Pair(9, "IX"),
            Pair(10, "X"),
            Pair(11, "XI"),
            Pair(14, "XIV"),
            Pair(15, "XV"),
            Pair(16, "XVI"),
            Pair(19, "XIX"),
            Pair(20, "XX"),
            Pair(21, "XXI"),
            Pair(25, "XXV"),
            Pair(30, "XXX"),
            Pair(30, "XXX"),
            Pair(40, "XL"),
            Pair(50, "L"),
            Pair(60, "LX"),
            Pair(70, "LXX"),
            Pair(80, "LXXX"),
            Pair(90, "XC"),
            Pair(99, "XCIX"),
            Pair(100, "C"),
            Pair(101, "CI"),
            Pair(200, "CC"),
            Pair(400, "CD"),
            Pair(499, "CDXCIX"),
            Pair(500, "D"),
            Pair(501, "DI"),
            Pair(999, "CMXCIX"),
            Pair(1000, "M"),
            Pair(1001, "MI"),
            Pair(1499, "MCDXCIX"),
            Pair(4999, "MMMMCMXCIX"),
            Pair(5000, "MMMMM"),
            Pair(5001, "MMMMMI")
    )

    given("Roman Number Transformer with default settings") {
        val romanNumberTransformer = RomanNumberTransformer()

        on("transform a negative number") {
            try {
                romanNumberTransformer.transformToRoman(-10)
                fail("should result in an IndexOutOfBoundsException")
            } catch (e: Exception) {
                it("should result in an IndexOutOfBoundsException") {
                    assertTrue { e is IndexOutOfBoundsException }
                }
            }
        }

        on("transform the number '0'") {
            try {
                romanNumberTransformer.transformToRoman(0)
                fail("should result in an IndexOutOfBoundsException")
            } catch (e: Exception) {
                it("should result in an IndexOutOfBoundsException") {
                    assertTrue { e is IndexOutOfBoundsException }
                }
            }
        }

        testParams.forEach {
            on("transform the number '" + it.first + "'") {
                val value = romanNumberTransformer.transformToRoman(it.first)
                it("should result in a value of '" + it.second + "'") {
                    assertEquals(it.second, value)
                }
            }
        }
    }

})
