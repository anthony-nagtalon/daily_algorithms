package sorters

class QuickSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        var start = System.currentTimeMillis()

        sortHelper(array, 0, array.size - 1)

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }

    private fun sortHelper(array: IntArray, low: Int, high: Int) {
        if(low < high) {
            val partIndex = partition(array, low, high)

            sortHelper(array, low, partIndex - 1)
            sortHelper(array, partIndex + 1, high)
        }
    }

    private fun partition(array: IntArray, low: Int, high: Int) : Int {
        // Temp move middle element to end and use as pivot
        swap(array, (high - low)/2 + low, high)
        val pivot = array[high]

        var i = (low - 1)

        for(j in low until high) {
            if(array[j] < pivot) {
                i++
                if(i != j) swap(array, i, j)
            }
        }

        swap(array, i + 1, high)

        return i + 1
    }
}