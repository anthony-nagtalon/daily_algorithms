package sorters

class MergeSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        var start = System.currentTimeMillis()

        sortHelper(array, 0, array.size - 1)

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }

    fun sortHelper(array : IntArray, left : Int, right : Int) {
        if(left < right) {
            val mid = left + (right - left)/2

            sortHelper(array, left, mid)
            sortHelper(array, mid + 1, right)

            merge(array, left, mid, right)
        }
    }

    fun merge(array : IntArray, left : Int, mid : Int, right : Int) {
        val leftSize = mid - left + 1
        val rightSize = right - mid

        val leftArray = IntArray(leftSize) { i -> array[left + i] }
        val rightArray = IntArray(rightSize) { i -> array[mid + 1 + i]}

        var i = 0
        var j = 0
        var k = left

        while(i < leftSize && j < rightSize) {
            if(leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i]
                i++
            } else {
                array[k] = rightArray[j]
                j++
            }
            k++
        }

        while(i < leftSize) {
            array[k] = leftArray[i]
            i++
            k++
        }

        while(j < rightSize) {
            array[k] = rightArray[j]
            j++
            k++
        }
    }
}