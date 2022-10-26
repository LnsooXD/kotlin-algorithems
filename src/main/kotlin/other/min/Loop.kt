package other.min

class Loop : MinNI {
    override fun min(vararg elements: Int): Int {
        if (elements.isEmpty()) {
            throw IllegalArgumentException("no arguments")
        }

        var res = elements[0]
        for (i in 1 until elements.size) {
            if (res > elements[i]) {
                res = elements[i]
            }
        }

        return res
    }

}