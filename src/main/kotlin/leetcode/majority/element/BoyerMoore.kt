package leetcode.majority.element

// 预设：众数一定存在
// 分类：数组中的数字分为两类：非众数和众数。投票就是一个非众数和众数不断相互抵消的过程，直到最后众数获胜

//
//    https://leetcode.cn/problems/majority-element/comments/40010
//
//    摩尔投票法：
//
//    核心就是对拼消耗。
//
//    玩一个诸侯争霸的游戏，假设你方人口超过总人口一半以上，并且能保证每个人口出去干仗都能一对一同归于尽。最后还有人活下来的国家就是胜利。
//
//    那就大混战呗，最差所有人都联合起来对付你（对应你每次选择作为计数器的数都是众数），或者其他国家也会相互攻击（会选择其他数作为计数器的数），但是只要你们不要内斗，最后肯定你赢。
//
//    最后能剩下的必定是自己人。
class BoyerMoore : MajorityElement {


    override fun majorityElement(nums: IntArray): Int {
        var candidate = nums[0]
        var count = 0
        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            if (candidate == num) {
                count++
            } else {
                count--
            }
        }

        return candidate
    }
}