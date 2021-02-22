package sorters

class RadixSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        var start = System.currentTimeMillis()

        val size = array.size
        val max = array.maxOrNull()
        var exp = 1

        while((max!! / exp) > 0) {
            countSort(array, size, exp)
            exp *= 10
        }

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }

    private fun countSort(array: IntArray, size: Int, exp: Int) {
        val outputArray = IntArray(size)
        val countArray = IntArray(10) { 0 }

        for(i in array.indices) {
            countArray[(array[i] / exp) % 10]++
        }

        for(i in 1 until 10) {
            countArray[i] += countArray[i - 1]
        }

        for(i in array.size - 1 downTo 0) {
            outputArray[countArray[(array[i] / exp) % 10] - 1] = array[i]
            countArray[(array[i] / exp) % 10]--
        }

        for(i in array.indices) {
            array[i] = outputArray[i]
        }
    }

}