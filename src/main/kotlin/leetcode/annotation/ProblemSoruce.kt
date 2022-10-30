package leetcode.annotation

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.SOURCE)
annotation class ProblemSoruce(val serialNumber: Int, val title: String, val url: String)