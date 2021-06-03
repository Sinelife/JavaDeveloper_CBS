package _3_java_professional.homeworks.homework00;

import java.util.*;


/** Демо версия LinkedList , в котором first и last являються лишь
 *  границами ограничивающими список(В отличии от MyLinkedList, где
 *  first и last являються первым и последним элементами списка)
 *
 *  Реализованы лишь iterator, listIterator, add(E e), clear(), toArray()
 *  Все эти методы необходимы для ComparatorTester чтоб проверить как
 *  Компаратор будет работать с подобным списком
 *  */
public class MyOtherLinkedList<E> implements List<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;


    public MyOtherLinkedList(){
        this.last = new Node(null, null, null);
        this.first = new Node(null, null, null);
        this.first.next = last;
        this.last.prev = first;
        this.size = 0;
    }



    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int counter = 0;
        for(E elem : this){
            array[counter] = elem;
            counter++;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E elem) {
        if(elem == null){
            return false;
        }
        if(isEmpty()){
            Node<E> newNode = new Node(first, elem, last);
            last.prev = newNode;
            first.next = newNode;
        }
        else{
            Node<E> prevLast = last.prev;
            Node<E> newNode = new Node(prevLast, elem, last);
            last.prev = newNode;
            prevLast.next = newNode;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        first = new Node(null, null, last);
        last = new Node(first, null, null);
        size = 0;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        /*(element == null || index < 0 || index > size - 1){
            return null;
        }
        LinkedListIterator iterator = new LinkedListIterator();
        int counter = 0;
        while(iterator.hasNext()){
            if(counter == index){
                iterator.set(element);
                return iterator.get();
            }
            iterator.next();
            counter++;
        }*/
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return new LinkedListIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }




    /** Вспомагательный вложеный клас*/
    private static class Node<E> {
        E elem;         /** значение самого элемента*/
        Node<E> next;   /** отсылка на следующий элемент*/
        Node<E> prev;   /** отсылка на предыдущий элемент*/

        Node(Node<E> prev, E element, Node<E> next) {
            this.elem = element;
            this.next = next;
            this.prev = prev;
        }
    }



    /**
     * Клас итератора для MyLinkedList
     */
    private class LinkedListIterator implements ListIterator<E> {
        private Node<E> current = first.next;


        /** Конструктор для обычного итератора*/
        LinkedListIterator(){}

        /** Конструктор для итератора с индексом*/
        LinkedListIterator(int index){
            int counter = 0;
            while(counter != index){
                current = current.next;
                counter++;
            }
        }

        /**
         * Метод для получения значения элемента во время итерации по списку
         * в обратном порядке
         */
        public E getElemInverse(){
            return current.elem;
        }

        /**
         * Метод для получения значения элемента во время итерации по списку
         * по порядку
         */
        public E get(){
            return current.elem;
        }

        /**
         * Метод для изменения значения элемента во время итерации по списку
         * в обратном порядке
         */
        public void setElemInverse(E elem){
            current.elem = elem;
        }

        /**
         * Метод для изменения значения элемента во время итерации по списку
         * по порядку
         */
        @Override
        public void set(E element) {
            current.elem = element;
        }

        @Override
        public E next() {
            if (!hasNext()) { throw new NoSuchElementException(); }
            E elem = current.elem;
            current = current.next;
            return elem;
        }

        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        @Override
        public boolean hasPrevious() {
            return current.prev != null;
        }

        @Override
        public E previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            return 0;
        }

        @Override
        public int previousIndex() {
            return 0;
        }

        @Override
        public void remove() {

        }

        @Override
        public void add(E e) {

        }
    }
}
