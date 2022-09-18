package leetcode

class LongestSubstringWithoutRepeatingCharacters {

    fun lengthOfLongestSubstring(s: String): Int {
        if (s.length <= 1) {
            return s.length
        }
        val set = IntArray(129) { -1 }
        var start = 0
        var max = 0

        for (end in s.indices) {
            val c = s[end]
            val key = c.toInt()
            val lastIndex = set[key]
            if (lastIndex in start until end) {
                start = lastIndex + 1
            }
            set[key] = end
            max = this.max(max, end + 1 - start)
        }
        return max
    }

    fun lengthOfLongestSubstring(s: String, max: Int): Int {
        if (max >= s.length) {
            return max
        } else if (s.length <= 1) {
            return s.length
        }

        val set = IntArray(256) { 0 }
        var len = 0

        for (c in s) {
            if (set[c.code] != 0) {
                break
            }
            len++
            set[c.code] = len
        }

        val ss = s.substring(1)
        return lengthOfLongestSubstring(ss, this.max(len, max))
    }

    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }
}