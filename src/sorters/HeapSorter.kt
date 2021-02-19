package sorters

class HeapSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        val start = System.currentTimeMillis()

        for(i in (array.size/2) - 1 downTo 0) heapify(array, array.size, i)

        for(i in array.size - 1 downTo 1) {
            swap(array, i, 0)

            heapify(array, i, 0)
        }

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }

    private fun heapify(array: IntArray, size: Int, i: Int) {
        var largest = i
        val left = 2*i + 1
        val right = 2*i + 2

        if(left < size && array[left] > array[largest])
            largest = left

        if(right < size && array[right] > array[largest])
            largest = right

        if(largest != i) {
            swap(array, i, largest)

            heapify(array, size, largest)
        }
    }
}