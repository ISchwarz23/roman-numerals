/**
 * A Roman Number Transformer that is able to transform a given number to its roman representation using a
 * predefined (expendable) rule-set.
 *
 * @author ISchwarz
 */
class RomanNumberTransformer {

    private val ruleSet: Array<RomanNumber> = arrayOf(
            RomanNumber("M", 1000),
            RomanNumber("CM", 900),
            RomanNumber("D", 500),
            RomanNumber("CD", 400),
            RomanNumber("C", 100),
            RomanNumber("XC", 90),
            RomanNumber("L", 50),
            RomanNumber("XL", 40),
            RomanNumber("X", 10),
            RomanNumber("IX", 9),
            RomanNumber("V", 5),
            RomanNumber("I", 1)
    )

    /**
     * Transforms the given value to its roman numeral representation. Only values bigger than zero are valid.
     * @param number The number to transform
     * @return The roman numeral representation of the given number.
     */
    fun transformToRoman(number: Int): String {
        if (number <= 0) {
            throw IndexOutOfBoundsException("number to transform has to be bigger than 0")
        }
        return transformToRomanRecursive(number)
    }

    private fun transformToRomanRecursive(numberToTransform: Int): String {
        var ruleIndex = 0

        while (ruleIndex < ruleSet.size) {
            val romanNumber = ruleSet[ruleIndex]
            val appearance = numberToTransform / romanNumber.value

            if (appearance == 0) {
                ruleIndex++
            } else {
                val restNumber: Int
                val representation: String

                if (appearance > 3 && ruleIndex > 0) {
                    val romanNumber = ruleSet[ruleIndex - 1]
                    representation = romanNumber.representation
                    restNumber = numberToTransform - romanNumber.value
                } else {
                    representation = romanNumber.toString(appearance)
                    restNumber = numberToTransform - (appearance * romanNumber.value)
                }

                if (restNumber > 0) {
                    return representation + transformToRomanRecursive(restNumber)
                } else if (restNumber < 0) {
                    return transformToRomanRecursive(Math.abs(restNumber)) + representation
                } else {
                    return representation
                }
            }
        }
        return ""
    }

    private data class RomanNumber(val representation: String, val value: Int) {

        override fun toString(): String {
            return toString(1)
        }

        fun toString(repetitions: Int): String {
            var counter = 0
            var output = ""
            while (counter < repetitions) {
                output += representation
                counter++
            }
            return output
        }
    }

}