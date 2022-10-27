package leetcode.longest.substring.without.repeating.characters

// DATE 2022-10-27
class PosCache : LongestSubstringWithoutRepeatingCharactersI {
    override fun lengthOfLongestSubstring(s: String): Int {
        val cache = IntArray(128) { -1 }
        var longestLength = 0
        var hind = 0
        var fore = 0

        while (fore < s.length) {
            val ci = s[fore].toInt()
            hind = cache[ci].let { if (it >= hind) it + 1 else hind }
            cache[ci] = fore
            fore++

            longestLength = (fore - hind).let { if (it > longestLength) it else longestLength }
        }
        return longestLength
    }
}