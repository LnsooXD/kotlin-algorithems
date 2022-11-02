package leetcode.container.with.most.water

import leetcode.annotation.SolvingDate

@SolvingDate(2022, 11, 2)
class Rude : ContainerWithMostWater {
    override fun maxArea(height: IntArray): Int {
        var maxAmount = 0
        for (i in 0 until height.size - 1) {
            for (j in i + 1 until height.size) {
                maxAmount = max((j - i) * min(height[i], height[j]), maxAmount)
            }
        }
        return maxAmount
    }

    companion object {
        fun min(vararg args: Int) = args.reduce { acc, i -> if (acc < i) acc else i }
        fun max(vararg args: Int) = args.reduce { acc, i -> if (acc > i) acc else i }
    }
}