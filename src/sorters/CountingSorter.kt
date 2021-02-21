package sorters

class CountingSorter : Sorter {
    override fun sort(array: IntArray, timed: Boolean) {
        val start = System.currentTimeMillis()

        val max = array.maxOrNull()
        val min = array.minOrNull()
        val range = max!! - min!! + 1
        val countArray = IntArray(range)
        val outputArray = IntArray(array.size)

        for(i in array.indices) {
            countArray[array[i] - min]++
        }

        for(i in 1 until countArray.size) {
            countArray[i] += countArray[i - 1]
        }

        for(i in array.size - 1 downTo 0) {
            outputArray[countArray[array[i] - min] - 1] = array[i]
            countArray[array[i] - min]--
        }

        for(i in array.indices) {
            array[i] = outputArray[i]
        }

        if(timed) println("${this::class.simpleName}: ${System.currentTimeMillis() - start} ms")
    }
}