package leetcode

// https://leetcode.cn/problems/valid-anagram/

class ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {
        if (s.isEmpty() && t.isEmpty()) {
            return true
        } else if (s.length != t.length) {
            return false
        }

        val map = IntArray(26) { 0 }
        for (c in s) {
            val key = this.hash(c)
            map[key] = map[key] + 1
        }

        for (c in t) {
            val key = this.hash(c)
            val count = map[key] - 1
            if (count < 0) {
                return false
            }
            map[key] = count
        }
        return true
    }

    private fun hash(c: Char) = c.toInt() - 'a'.toInt()

    fun isAnagramHash1(s: String, t: String): Boolean {
        if (s.isEmpty() && t.isEmpty()) {
            return true
        } else if (s.length != t.length) {
            return false
        }

        val map = HashMap<Char, Int>(s.length)
        for (c in s) {
            map[c] = (map[c] ?: 0) + 1 // count
        }

        for (c in t) {
            val count = (map[c] ?: return false) - 1
            if (count <= 0) {
                map.remove(c)
            } else {
                map[c] = count
            }
        }
        return map.isEmpty()
    }

    fun isAnagramSorting(s: String, t: String): Boolean {
        val sSortedChars = s.toCharArray()
        sSortedChars.sort()

        val tSortedChars = t.toCharArray()
        tSortedChars.sort()

        for (i in sSortedChars.indices) {
            if (sSortedChars[i] != tSortedChars[i]) {
                return false
            }
        }

        return true
    }

}