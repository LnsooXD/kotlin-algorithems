package other.min

class Reduce : MinNI {
    override fun min(vararg elements: Int) = elements.reduce { acc, i -> if (acc < i) acc else i }
}