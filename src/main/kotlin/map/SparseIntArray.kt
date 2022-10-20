package map

import java.util.*

/**
 * SparseIntArrays map integers to integers.  Unlike a normal array of integers,
 * there can be gaps in the indices.  It is intended to be more memory efficient
 * than using a HashMap to map Integers to Integers, both because it avoids
 * auto-boxing keys and values and its data structure doesn't rely on an extra entry object
 * for each mapping.
 *
 *
 * Note that this container keeps its mappings in an array data structure,
 * using a binary search to find keys.  The implementation is not intended to be appropriate for
 * data structures
 * that may contain large numbers of items.  It is generally slower than a traditional
 * HashMap, since lookups require a binary search and adds and removes require inserting
 * and deleting entries in the array.  For containers holding up to hundreds of items,
 * the performance difference is not significant, less than 50%.
 *
 *
 * It is possible to iterate over the items in this container using
 * [.keyAt] and [.valueAt]. Iterating over the keys using
 * `keyAt(int)` with ascending values of the index will return the
 * keys in ascending order, or the values corresponding to the keys in ascending
 * order in the case of `valueAt(int)`.
 */
class SparseIntArray constructor(initialCapacity: Int = 10) : Cloneable {
    private var mKeys: IntArray
    private var mValues: IntArray
    private var mSize: Int
    /**
     * Creates a new SparseIntArray containing no mappings that will not
     * require any additional memory allocation to store the specified
     * number of mappings.  If you supply an initial capacity of 0, the
     * sparse array will be initialized with a light-weight representation
     * not requiring any additional array allocations.
     */
    /**
     * Creates a new SparseIntArray containing no mappings.
     */
    init {
        if (initialCapacity == 0) {
            mKeys = intArrayOf()
            mValues = intArrayOf()
        } else {
            mKeys = IntArray(initialCapacity)
            mValues = IntArray(mKeys.size)
        }
        mSize = 0
    }

    public override fun clone(): SparseIntArray {
        var clone: SparseIntArray? = null
        try {
            clone = super.clone() as SparseIntArray
            clone.mKeys = mKeys.clone()
            clone.mValues = mValues.clone()
        } catch (ignored: CloneNotSupportedException) {
        }
        return clone!!
    }
    /**
     * Gets the int mapped from the specified key, or the specified value
     * if no such mapping has been made.
     */
    /**
     * Gets the int mapped from the specified key, or `0`
     * if no such mapping has been made.
     */
    operator fun get(key: Int, valueIfKeyNotFound: Int = 0): Int {
        val i: Int = binarySearch(mKeys, mSize, key)
        return if (i < 0) {
            valueIfKeyNotFound
        } else {
            mValues[i]
        }
    }

    /**
     * Removes the mapping from the specified key, if there was any.
     */
    fun delete(key: Int) {
        val i: Int = binarySearch(mKeys, mSize, key)
        if (i >= 0) {
            removeAt(i)
        }
    }

    /**
     * Removes the mapping at the given index.
     */
    fun removeAt(index: Int) {
        System.arraycopy(mKeys, index + 1, mKeys, index, mSize - (index + 1))
        System.arraycopy(mValues, index + 1, mValues, index, mSize - (index + 1))
        mSize--
    }

    /**
     * Adds a mapping from the specified key to the specified value,
     * replacing the previous mapping from the specified key if there
     * was one.
     */
    fun put(key: Int, value: Int) {
        var i: Int = binarySearch(mKeys, mSize, key)
        if (i >= 0) {
            mValues[i] = value
        } else {
            i = i.inv()
            mKeys = insert(mKeys, mSize, i, key)
            mValues = insert(mValues, mSize, i, value)
            mSize++
        }
    }

    /**
     * Returns the number of key-value mappings that this SparseIntArray
     * currently stores.
     */
    fun size() = mSize

    /**
     * Given an index in the range `0...size()-1`, returns
     * the key from the `index`th key-value mapping that this
     * SparseIntArray stores.
     *
     *
     * The keys corresponding to indices in ascending order are guaranteed to
     * be in ascending order, e.g., `keyAt(0)` will return the
     * smallest key and `keyAt(size()-1)` will return the largest
     * key.
     *
     *
     * For indices outside of the range `0...size()-1`, the behavior is undefined for
     * apps targeting [android.os.Build.VERSION_CODES.P] and earlier, and an
     * [ArrayIndexOutOfBoundsException] is thrown for apps targeting
     * [android.os.Build.VERSION_CODES.Q] and later.
     */
    fun keyAt(index: Int): Int {
        if (index >= mSize) {
            // The array might be slightly bigger than mSize, in which case, indexing won't fail.
            // Check if exception should be thrown outside of the critical path.
            throw ArrayIndexOutOfBoundsException(index)
        }
        return mKeys[index]
    }

    /**
     * Given an index in the range `0...size()-1`, returns
     * the value from the `index`th key-value mapping that this
     * SparseIntArray stores.
     *
     *
     * The values corresponding to indices in ascending order are guaranteed
     * to be associated with keys in ascending order, e.g.,
     * `valueAt(0)` will return the value associated with the
     * smallest key and `valueAt(size()-1)` will return the value
     * associated with the largest key.
     *
     *
     * For indices outside of the range `0...size()-1`, the behavior is undefined for
     * apps targeting [android.os.Build.VERSION_CODES.P] and earlier, and an
     * [ArrayIndexOutOfBoundsException] is thrown for apps targeting
     * [android.os.Build.VERSION_CODES.Q] and later.
     */
    fun valueAt(index: Int): Int {
        if (index >= mSize) {
            // The array might be slightly bigger than mSize, in which case, indexing won't fail.
            // Check if exception should be thrown outside of the critical path.
            throw ArrayIndexOutOfBoundsException(index)
        }
        return mValues[index]
    }

    /**
     * Directly set the value at a particular index.
     *
     *
     * For indices outside of the range `0...size()-1`, the behavior is undefined for
     * apps targeting [android.os.Build.VERSION_CODES.P] and earlier, and an
     * [ArrayIndexOutOfBoundsException] is thrown for apps targeting
     * [android.os.Build.VERSION_CODES.Q] and later.
     */
    fun setValueAt(index: Int, value: Int) {
        if (index >= mSize) {
            // The array might be slightly bigger than mSize, in which case, indexing won't fail.
            // Check if exception should be thrown outside of the critical path.
            throw ArrayIndexOutOfBoundsException(index)
        }
        mValues[index] = value
    }

    /**
     * Returns the index for which [.keyAt] would return the
     * specified key, or a negative number if the specified
     * key is not mapped.
     */
    fun indexOfKey(key: Int) = binarySearch(mKeys, mSize, key)

    /**
     * Returns an index for which [.valueAt] would return the
     * specified key, or a negative number if no keys map to the
     * specified value.
     * Beware that this is a linear search, unlike lookups by key,
     * and that multiple keys can map to the same value and this will
     * find only one of them.
     */
    fun indexOfValue(value: Int): Int {
        for (i in 0 until mSize) {
            if (mValues[i] == value) return i
        }
        return -1
    }

    /**
     * Removes all key-value mappings from this SparseIntArray.
     */
    fun clear() {
        mSize = 0
    }

    /**
     * Puts a key/value pair into the array, optimizing for the case where
     * the key is greater than all existing keys in the array.
     */
    fun append(key: Int, value: Int) {
        if (mSize != 0 && key <= mKeys[mSize - 1]) {
            put(key, value)
            return
        }
        mKeys = append(mKeys, mSize, key)
        mValues = append(mValues, mSize, value)
        mSize++
    }

    /**
     * {@inheritDoc}
     *
     * This implementation composes a string by iterating over its mappings.
     */
    override fun toString(): String {
        if (size() <= 0) {
            return "{}"
        }
        val buffer = StringBuilder(mSize * 28)
        buffer.append('{')
        for (i in 0 until mSize) {
            if (i > 0) {
                buffer.append(", ")
            }
            val key = keyAt(i)
            buffer.append(key)
            buffer.append('=')
            val value = valueAt(i)
            buffer.append(value)
        }
        buffer.append('}')
        return buffer.toString()
    }

    companion object {
        fun append(array: IntArray, currentSize: Int, element: Int): IntArray {
            var res = array
            assert(currentSize <= res.size)
            if (currentSize + 1 > res.size) {
                val newArray = IntArray(growSize(currentSize))
                System.arraycopy(res, 0, newArray, 0, currentSize)
                res = newArray
            }
            res[currentSize] = element
            return res
        }

        fun insert(array: IntArray, currentSize: Int, index: Int, element: Int): IntArray {
            assert(currentSize <= array.size)
            if (currentSize + 1 <= array.size) {
                System.arraycopy(array, index, array, index + 1, currentSize - index)
                array[index] = element
                return array
            }
            val newArray = IntArray(growSize(currentSize))
            System.arraycopy(array, 0, newArray, 0, index)
            newArray[index] = element
            System.arraycopy(array, index, newArray, index + 1, array.size - index)
            return newArray
        }

        private fun growSize(currentSize: Int) = if (currentSize <= 4) 8 else currentSize.shl(1)

        fun binarySearch(array: IntArray, size: Int, value: Int): Int {
            var lo = 0
            var hi = size - 1
            while (lo <= hi) {
                val mid = (lo + hi) ushr 1
                val midVal = array[mid]
                if (midVal < value) {
                    lo = mid + 1
                } else if (midVal > value) {
                    hi = mid - 1
                } else {
                    return mid // value found
                }
            }
            return lo.inv() // value not present
        }
    }
}