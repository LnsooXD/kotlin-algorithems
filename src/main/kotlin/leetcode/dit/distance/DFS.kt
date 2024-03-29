package leetcode.dit.distance

class DFS : EditDistance {

    override fun minDistance(word1: String, word2: String) =
        minDistance(word1.toCharArray(), 0, word2.toCharArray(), 0)

    private fun minDistance(word1: CharArray, index1: Int, word2: CharArray, index2: Int): Int {
        if (index1 >= word1.size || index2 >= word2.size) {
            return max(word2.size - index2, word1.size - index1)
        }

        return min(
            this.minDistance(word1, index1 + 1, word2, index2), // delete
            this.minDistance(word1, index1 + 1, word2, index2 + 1)
                    + if (word1[index1] == word2[index2]) 0 else 1, // replace or skip
            this.minDistance(word1, index1, word2, index2 + 1) // insert
        )
    }


    companion object {
        private fun min(a: Int, b: Int) = if (a < b) a else b
        fun min(a: Int, b: Int, c: Int) = min(min(a, b), c)
        fun max(a: Int, b: Int) = if (a > b) a else b
    }

}