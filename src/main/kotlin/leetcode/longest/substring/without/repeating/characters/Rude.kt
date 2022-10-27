package leetcode.longest.substring.without.repeating.characters

// DATE 2022-10-27
class Rude : LongestSubstringWithoutRepeatingCharactersI {

    override fun lengthOfLongestSubstring(s: String): Int {
        var fore = 0
        var hind = 0
        var longLength = 0
        while (fore < s.length) {
            for (k in fore - 1 downTo hind) {
                if (s[k] == s[fore]) {
                    hind = k + 1
                    break
                }
            }
            fore++
            longLength = (fore - hind).let { if (it > longLength) it else longLength }
        }
        return longLength
    }

}