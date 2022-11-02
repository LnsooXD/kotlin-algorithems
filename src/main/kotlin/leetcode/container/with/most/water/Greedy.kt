package leetcode.container.with.most.water

import leetcode.annotation.SolvingDate

// [1] (j-i)      * min(height[i], height[j])
// [2] ((j-1) -i) * min(height[i], height[j-1])
// [3] (j-(i+1))  * min(height[i+1], height[j])

// if height[i] > height[j] then
// [1] => (j-i)      * height[j]
// [2] => ((j-1) -i) * min(height[i], height[j-1])
//      let x = i-j, m1 = min(height[i], height[j]), m2 = min(height[i], height[j-n])
//      then:
//          m1 = height[j]
//          m2 = min(height[i], height[j-n])
//          amount1 = x * m1
//          amount2 = (x-n) * m2 = x * m2 - n * m2
//      => amount2 - amount1 = [(x-n) * m2] - [x * m1] = x * m2 - n * m2 - x * m1 = x * (m2 - m1) - n * m2
//      let amount2 - amount1 >= 0 then:
//          x * (m2 - m1) - n * m2 >= 0 => x * (m2 - m1) >= n * m2
//          [1] m1 = m2 = 0
//             or
//          [2] x >= (n * m2) / (m2 - m1) and m2 > m1 (if m2 < m1 then x < 0 that is impossible)
//              => m2 > height[j]
// [3] => (j-(i+n))  * min(height[i+n], height[j])
//      and j-(i+n) < j-i and min(height[i+n], height[j]) <= height[j]
//      so (j-(i+n))  * min(height[i+n], height[j]) < (j-i) * min(height[i], height[j])

// -----------------------------------------------------------------------
// [1] (j-i)      * min(height[i], height[j])
// [2] ((j-n)-i)  * min(height[i], height[j-1]) (1 < n < j-i) means the left combinations of with the index i
// [3] (j-(i+n))  * min(height[i+1], height[j]) (1 < n < j-i) means the left combinations of with the index j

// let height[i] =<  height[j] then
// [1] (j-i)      * min(height[i], height[j]) = (j-i) * height[i]
// [2] ((j-n)-i)  * min(height[i], height[j-1]) = ((j-i)-n) * min(height[i], height[j-1])
//   as j-i-n < j-i and min(height[i], height[j-1]) <= height[i]
//   so: ((j-n)-i)  * min(height[i], height[j-1]) < (j-i) * min(height[i], height[j])
//     => [2] < [1]
// let height[i] >= height[j] then can get the same conclusion: [3] < [1]
//
// so: if we want to get a lager amount, we must ditch the smaller one. Then, we may find a lager amount in the successive steps.

@SolvingDate(2022, 11, 2)
class Greedy : ContainerWithMostWater {
    override fun maxArea(height: IntArray): Int {
        var maxAmount = 0

        var i = 0
        var j = height.size - 1
        var diff = j - i

        while (diff > 0) {
            if (height[i] <= height[j]) {
                maxAmount = max(maxAmount, height[i] * diff)
                i++
            } else {
                maxAmount = max(maxAmount, height[j] * diff)
                j--
            }
            diff--
        }
        return maxAmount
    }

    companion object {
        fun max(vararg args: Int) = args.reduce { acc, i -> if (acc > i) acc else i }
    }
}