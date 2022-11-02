package leetcode.container.with.most.water

// https://leetcode.cn/problems/container-with-most-water/

// https://leetcode.cn/problems/container-with-most-water/solution/on-shuang-zhi-zhen-jie-fa-li-jie-zheng-que-xing-tu/
class ContainerWithMostWaterOld {

    fun maxArea(height: IntArray): Int {
        var maxArea = 0

        var i = 0
        var j = height.size - 1

        while (i < j) {
            val hi = height[i]
            val hj = height[j]
            val w = j - i

            if (hi > hj) {
                val a = hj * w
                maxArea = max(maxArea, a)
                j--
            } else {
                val a = hi * w
                maxArea = max(maxArea, a)
                i++
            }
        }




        return maxArea
    }


    fun max(a: Int, b: Int): Int {
        return if (a > b) a else b
    }


}

