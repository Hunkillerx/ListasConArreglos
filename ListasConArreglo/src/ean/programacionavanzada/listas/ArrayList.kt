/**
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad EAN (Bogotá - Colombia)
 * Departamento de Sistemas
 * Faculta de Ingeniería
 *
 * Proyecto EAN Java Collections
 * @author UniversidadEAN
 * Fecha: Mar 05, 2018
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package ean.programacionavanzada.listas

/**
 * Implementación del tipo abstracto de datos Lista, especificado en la interface IList
 * Esta implementación utiliza un arreglo o vector estático para almacenar la información
 * respectiva
 */
open class ArrayList<T> : IList<T> {

    //---------------------------------------------------------
    // Constantes
    //---------------------------------------------------------

    /**
     * El tamaño máximo con el que creamos inicialmente el arreglo
     */
    private val TAMAÑO_MAXIMO = 1000

    //---------------------------------------------------------
    // Atributos
    //---------------------------------------------------------

    /**
     * El número de elementos que actualmente contiene el arreglo
     */
    private var tam: Int = 0

    /**
     * El vector o arreglo donde almacenaremos la información
     */
    private var info: Array<T?> = arrayOfNulls<Any?>(TAMAÑO_MAXIMO) as Array<T?>

    //---------------------------------------------------------
    // Constructor
    //---------------------------------------------------------
    constructor()

    //---------------------------------------------------------
    // Métodos
    //---------------------------------------------------------

    /**
     * Retorna `true` si la lista está vacía (no contiene elementos), `false` si tiene al menos un elemento
     */
    override val isEmpty: Boolean
        get() = (tam == 0)

    /**
     * Retona el número de elementos que hacen parte de la lista
     */
    override val size: Int
        get() = tam

    /**
     * Verifica si el elemento especificado hace parte de la lista o no
     */
    override fun contains(element: T): Boolean {
        TODO("Completar!")
    }

    /**
     * Agrega un elemento al final de la lista
     */
    override fun add(element: T) {
        TODO("Completar")
    }

    /**
     * Agrega un nuevo elemento al principio de la lista
     */
    override fun addToHead(element: T) {
        TODO("Completar!")
    }

    /**
     * Agrega un elemento en la posición específica de la lista
     */
    override fun add(position: Int, element: T) {
        TODO("Completar!!")
    }

    /**
     * Elimina el elemento que se encuentra en la posición indicada
     */
    override fun remove(position: Int) {
        TODO("Completar!")
    }

    /**
     * Elimina el primer elemento de la lista
     */
    override fun removeFirst() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Elimina el último elemento de la lista
     */
    override fun removeLast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    /**
     * Elimina la primera ocurrencia del elemento especificado
     */
    override fun removeElement(element: T) {
        TODO("Completar!!")
    }

    /**
     * Retorna el elemento que se encuentra una determinada posición de la lista
     */
    override fun get(position: Int): T = info[position]!!

    /**
     * Retorna el elemento que se encuentra en la primera posición de la lista
     *
     */
    override fun head(): T = info[0]!!

    /**
     * Retorna la lista sin el primer elemento. Es una copia de esta lista, no modifica la lista que recibe el
     * mensaje correspondiente
     */
    override fun tail(): IList<T> {
        TODO("Completar!")
    }

    /**
     * Retorna el índice de la primer ocurrencia del elemento especificado en la lista, o -1 si el elemento dado no
     * existe en la lista
     */
    override fun indexOf(element: T): Int {
        TODO("Completar!")
    }

    /**
     * Retorna el índice de la última ocurrencia del elemento dado en la lista, o -1 si el elemento dado no existe en
     * la lista
     */
    override fun lastIndexOf(element: T): Int {
        TODO("Completar!")
    }

    /**
     * Reemplaza el elemento en la posición especificada en la lista por elemento dado
     *
     * @return el elemento que se encontraba previamente en la posición dada
     */
    override fun set(position: Int, element: T) {
        TODO("Completar!!")
    }

    /**
     * Obtiene una copia idéntica de esta lista.
     */
    override fun copy(): IList<T> {
        TODO("Completar!!!")
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * Elimina todos los elementos de esta lista
     */
    override fun clear() {
        for (i: Int in info.indices) {
            info[i] = null
        }
        tam = 0
    }

    /**
     * Retorna un iterador sobre los elementos de esta secuencia de elementos
     */
    override fun iterator(): Iterator<T> {
        return IteratorImpl()
    }

    /**
     * Permite saber si una lista es igual a otra. Solo podemos comparar listas, sin importar la implementación
     */
    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is IList<*>) {
            return false
        }

        other as IList<T>

        if (this.size != other.size) {
            return false
        }

        for (i: Int in this.indices) {
            if (this[i] != other[i]) {
                return false
            }
        }

        return true
    }

    /**
     * Obtiene un código Hash para este objeto a partir del tamaño
     */
    override fun hashCode(): Int {
        return tam
    }

    /**
     * Convierte a cadena el objeto actual
     */
    override fun toString(): String {
        var res: StringBuffer = StringBuffer("[")

        for (i in 0 until tam) {
            res.append(info[i].toString())
            if (i != (tam - 1)) {
                res.append(", ")
            }
        }
        res.append("]")

        return "ArrayList(tam=$tam, info=$res)"
    }

    //-------------------------------------------------------
    // Clase que implementa a los iteradores
    //-------------------------------------------------------
    private inner class IteratorImpl: Iterator<T> {
        // Atributos
        private var index = 0

        /**
         * Returns `true` if the iteration has more elements.
         */
        override fun hasNext(): Boolean = index < tam

        /**
         * Returns the next element in the iteration.
         */
        override fun next(): T {

            if (!hasNext()) {
                throw NoSuchElementException()
            }

            val elem = info[index]
            index++
            return elem!!
        }
    }

}


