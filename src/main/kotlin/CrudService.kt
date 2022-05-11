open class CrudService<T : ElementId> {
    val elements = mutableListOf<T>()
    private var nextId = 1

    fun add(elem: T): T {
        elem.id = nextId++
        elements.add(elem)
        return elements.last()
    }

    fun edit(elem: T): Boolean {
        for ((index, curElem) in elements.withIndex()) {
            if (curElem.id == elem.id)
                elements[index] = elem
            return true
        }
        return false
    }

    fun getById(id: Int) = elements.find { it.id == id }

    fun get() = elements

    fun delete(elem: T): Boolean {
        for ((index, curElem) in elements.withIndex()) {
            if (curElem.id == elem.id) {
                elements.removeAt(index)
                return true
            }
        }
        return false
    }


}