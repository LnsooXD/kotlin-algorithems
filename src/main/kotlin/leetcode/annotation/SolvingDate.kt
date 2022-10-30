package leetcode.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class SolvingDate(val year: Int, val month: Int, val day: Int)
