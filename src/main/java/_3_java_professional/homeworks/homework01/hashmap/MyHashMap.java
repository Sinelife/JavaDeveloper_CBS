package _3_java_professional.homeworks.homework01.hashmap;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MyHashMap<K,V> implements Map<K,V> {

    private static final int DEFAULT_CAPACITY = 16;
    private static final double DEFAULT_LOAD_FACTOR = 0.75;
    private static final int DEFAULT_THRESHOLD = (int) (DEFAULT_CAPACITY * DEFAULT_LOAD_FACTOR);


    public Node<K,V>[] table;
    private int threshold;
    private double loadFactor = DEFAULT_LOAD_FACTOR;
    private int size = 0;


    /**
     *  Конструктор по умолчанию создает HashMap дефолтной вместимости 16.
     *  Количество порогового заполнения также задаеться дефолтным значением
     *  DEFAULT_LOAD_FACTOR * DEFAULT_CAPACITY
     */
    MyHashMap(){
        this.threshold = DEFAULT_THRESHOLD;
        this.table = new Node[DEFAULT_CAPACITY];
    }

    private MyHashMap(int oldTableLength){
        this.table = new Node[oldTableLength * 2];
        this.threshold = (int) (table.length * loadFactor);
    }


    /**
     *  Метод, который возвращает размер MyHashMap
     */
    @Override
    public int size() {
        return size;
    }

    /**
     *  Метод, который проверяет пустая ли HashMap
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     *  Метод, проверяющий есть ли такой ключ в HashMap
     */
    @Override
    public boolean containsKey(Object key) {
        if (key == null) {
            return false;
        }
        int bucketIndex = hash((K) key) % table.length;
        Iterator<K> iterator = new BucketIterator(bucketIndex);
        while(((BucketIterator) iterator).current != null){
            if(((BucketIterator) iterator).current.getKey().equals(key)){
                return true;
            }
            iterator.next();
        }
        return false;
    }


    /**
     *  Метод, проверяющий есть ли такое значение в HashMap
     */
    @Override
    public boolean containsValue(Object value) {
        if (value == null) {
            return false;
        }
        for (int i = 0; i < table.length; i++) {
            Iterator<K> iterator = new BucketIterator(i);
            while(((BucketIterator) iterator).current != null){
                if(((BucketIterator) iterator).current.getValue().equals(value)){
                    return true;
                }
                iterator.next();
            }
        }
        return false;
    }


    /**
     *  Метод, для получения значения элемента по ключу
     */
    @Override
    public V get(Object key) {
        if(key == null){
            return null;
        }
        int bucketIndex = hash((K) key) % table.length;
        Iterator iterator = new BucketIterator(bucketIndex);
        while(((BucketIterator) iterator).current != null) {
            if(((BucketIterator) iterator).current.getKey().equals(key)){
                return ((BucketIterator) iterator).current.getValue();
            }
            iterator.next();
        }
        return null;
    }


    /**
     *  Метод, который добавляет элемент в HashMap
     */
    @Override
    public V put(K key, V value) {
        if(key == null || value == null){
            return null;
        }
        resize();
        Node<K,V> newNode = new Node(key, value, hash(key));
        int bucketIndex = hash(key) % table.length;
        //System.out.println(bucketIndex);
        if(table[bucketIndex] == null){
            table[bucketIndex] = newNode;
            size++;
        }
        else{
            Iterator iterator = new BucketIterator(bucketIndex);
            Node<K,V> current = ((BucketIterator) iterator).current;
            while(((BucketIterator) iterator).current != null){
                if(current.getKey().equals(key)){
                    ((BucketIterator) iterator).current.setValue(value);
                    return ((BucketIterator) iterator).current.getValue();
                }
                if(current.next == null){
                    break;
                }
                iterator.next();
                current = ((BucketIterator) iterator).current;
            }
            current.next = newNode;
            size++;
        }

        return newNode.getValue();
    }



    /**
     *  Метод, для удаления элемента из HashMap
     */
    @Override
    public V remove(Object key) {
        if(key == null || !containsKey(key)){
            return null;
        }
        int bucketIndex = hash((K) key) % table.length;
        Iterator<K> iterator = new BucketIterator(bucketIndex);
        Node<K,V> deletedNode = null;
        //удаление ноды из начала корзины
        if(((BucketIterator) iterator).current.getKey().equals(key)){
            size--;
            V value = ((BucketIterator) iterator).current.getValue();
            iterator.next();
            Node<K,V> afterDeletedNode = ((BucketIterator) iterator).current;
            table[bucketIndex] = afterDeletedNode;
            return value;
        }

        //удаление ноды не из начала корзины
        Node<K,V> preDeletedNode = null;
        while(((BucketIterator) iterator).current != null){
            preDeletedNode = ((BucketIterator) iterator).current;
            iterator.next();
            if(((BucketIterator) iterator).current == null){
                return null;
            }
            if(((BucketIterator) iterator).current.getKey().equals(key)) {
                deletedNode = ((BucketIterator) iterator).current;
                break;
            }
        }
        Node<K,V> afterDeletedNode = ((BucketIterator) iterator).current.next;
        preDeletedNode.next = afterDeletedNode;
        size--;
        return deletedNode.value;
    }


    /**
     *  Метод, для добавления в HashMap всех элементов другой Колекции
     *  имплиментирующей Map
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        for(Entry<? extends K,? extends V> node : map.entrySet()){
            put(node.getKey(), node.getValue());
        }
    }

    /**
     *  Метод, для полной очистки HashMap
     */
    @Override
    public void clear() {
        table = new Node[DEFAULT_CAPACITY];
        threshold = DEFAULT_THRESHOLD;
        size = 0;
    }



    /**
     * Метод для возвращения набора(Set), которая состоит из всех значений
     * всех ключей HashMap.
     * При удалении ключа из набора, элемент с таким ключем будет
     * удален из HashMap
     * Чтоб этот набор поддерживала эти возможности будет создан
     * анонимный клас, который переопределит методы стандартного
     * Set
     */
    @Override
    public Set<K> keySet() {
        Set<K> keys = new Set<K>() {
            @Override
            public int size() {
                return MyHashMap.this.size();
            }

            @Override
            public boolean isEmpty() {
                return MyHashMap.this.isEmpty();
            }

            @Override
            public boolean contains(Object key) {
                if(key == null){
                    return false;
                }
                return MyHashMap.this.containsKey(key);
            }

            @Override
            public Iterator<K> iterator() {
                return new Iterator<K>() {
                    private Iterator<Node<K,V>> iterator = new HashMapIterator();

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public K next() {
                        return iterator.next().getKey();
                    }
                };
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }


            @Override
            public boolean remove(Object key) {
                if(key == null || !(contains(key))){
                    return false;
                }
                MyHashMap.this.remove(key);
                return true;
            }


            @Override
            public boolean containsAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for(Object k : c){
                    if(!contains(k)){
                        return false;
                    }
                }
                return true;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for (int i = 0; i < 16; i++) {
                    for (K k : this) {
                        if (!c.contains(k)) {
                            remove(k);
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for(Object k : c){
                    if(contains(k)){
                        remove(k);
                    }
                }
                return true;
            }

            @Override
            public void clear() {
                MyHashMap.this.clear();
            }

            @Override
            public String toString(){
                String res = "[";
                int counter = size();
                for(K k : this){
                    res += k;
                    counter--;
                    if(counter != 0){
                        res += ", ";
                    }
                }
                res += "]";
                return res;
            }


            @Override
            public boolean add(K k) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends K> c) {
                return false;
            }
        };

        if(isEmpty()) {
            return null;
        }
        /**Заполненение переопределенного набора Set ключами
        *  элементов HashMap*/
        for (int i = 0; i < table.length; i++) {
            Iterator iterator = new BucketIterator(i);
            if(table[i] != null) {
                while (((BucketIterator) iterator).current != null) {
                    keys.add(((BucketIterator) iterator).current.key);
                    iterator.next();
                }
            }
        }

        return keys;
    }


    /**
     * Метод для возвращения колекции, которая состоит из всех значений
     * всех элементов HashMap.
     * При удалении значения из колекции, элемент с этим значением
     * должен быть удален и из HashMap
     * Чтоб эта колекция поддерживала эти возможности будет создан
     * анонимный клас, который переопределит методы стандартной
     * Collection
     */
    @Override
    public Collection<V> values() {
        Collection<V> values = new Collection<V>() {
            @Override
            public int size() {
                return MyHashMap.this.size();
            }

            @Override
            public boolean isEmpty() {
                return MyHashMap.this.isEmpty();
            }

            @Override
            public boolean contains(Object value) {
                if(value == null){
                    return false;
                }
                return MyHashMap.this.containsValue(value);
            }

            @Override
            public Iterator<V> iterator() {
                return new Iterator<V>() {
                    private Iterator<Node<K,V>> iterator = new HashMapIterator();

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public V next() {
                        return iterator.next().getValue();
                    }
                };
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }


            @Override
            public boolean remove(Object value) {
                if(value == null){
                    return false;
                }
                K key;
                Iterator<Node<K,V>> i = new HashMapIterator();
                while(i.hasNext()){
                    Node<K,V> node = i.next();
                    if(node.getValue().equals(value)){
                        key = node.getKey();
                        MyHashMap.this.remove(key);
                        return true;
                    }
                }
                return false;
            }


            @Override
            public boolean containsAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for(Object o : c){
                    if(!contains(o)){
                        return false;
                    }
                }
                return true;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for(Object v : c){
                    while(contains(v)){
                        remove(v);
                    }
                }
                return true;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for (int i = 0; i < 16; i++) {
                    for (V v : this) {
                        if (!(c.contains(v))) {
                            remove(v);
                        }
                    }
                }
                return true;
            }

            @Override
            public void clear() {
                MyHashMap.this.clear();
            }

            @Override
            public String toString(){
                String res = "[";
                int counter = size();
                for(V v : this){
                    res += v;
                    counter--;
                    if(counter != 0){
                        res += ", ";
                    }
                }
                res += "]";
                return res;
            }

            /**
             * Методы добавления не должны быть реализованы так
             * как тогда можна было б добавить значение без ключа
             */
            @Override
            public boolean add(V v) {
                return true;
            }
            @Override
            public boolean addAll(Collection<? extends V> c) {
                return true;
            }
        };


        if(isEmpty()) {
            return null;
        }
        /**Заполненение переопределенной колекции value значениями
         * элементов HashMap*/
        for (int i = 0; i < table.length; i++) {
            Iterator iterator = new BucketIterator(i);
            if(table[i] != null) {
                while (((BucketIterator) iterator).current != null) {
                    values.add(((BucketIterator) iterator).current.value);
                    iterator.next();
                }
            }
        }
        return values;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K,V>> nodes = new Set<Entry<K, V>>() {

            @Override
            public int size() {
                return MyHashMap.this.size();
            }

            @Override
            public boolean isEmpty() {
                return MyHashMap.this.isEmpty();
            }

            @Override
            public boolean contains(Object o) {
                if(o == null){
                    return false;
                }
                Entry<K,V> node = (Entry<K,V>) o;
                if(!MyHashMap.this.containsKey(node.getKey())){
                    return false;
                }
                if(!MyHashMap.this.containsValue(node.getValue())){
                    return false;
                }
                return true;
            }

            @Override
            public Iterator<Entry<K, V>> iterator() {
                return new Iterator<Entry<K, V>>() {
                    private Iterator<Node<K,V>> iterator = new HashMapIterator();

                    @Override
                    public boolean hasNext() {
                        return iterator.hasNext();
                    }

                    @Override
                    public Entry<K, V> next() {
                        return iterator.next();
                    }
                };
            }


            @Override
            public Object[] toArray() {
                Object[] array = new Object[size()];
                int i = 0;
                for(Entry<K,V> node : this){
                    array[i] = node;
                }
                return array;
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Entry<K, V> node) {
                if(node == null){
                    return false;
                }
                MyHashMap.this.put(node.getKey(), node.getValue());
                return true;
            }

            @Override
            public boolean remove(Object o) {
                if(o == null || !(contains(o))){
                    return false;
                }
                Entry<K,V> node = (Entry<K,V>)o;
                if(contains(node)) {
                    MyHashMap.this.remove(node.getKey());
                    return true;
                }
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Entry<K,V>> c) {
                if(c == null){
                    return false;
                }
                for(Entry<K,V> node : c){
                    add(node);
                }
                return true;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for(Object node : c){
                    if(!contains(node)){
                        return false;
                    }
                }
                return true;
            }


            public boolean retainAll(Collection<?> c) {
                if(c == null){
                    return false;
                }

                for (int i = 0; i < 16; i++) {
                    for (Entry<K, V> node : this) {
                        boolean notDelete = false;
                        for (Object o : c) {
                            Entry<K, V> otherNode = (Entry<K, V>) o;
                            if (node.getKey().equals(otherNode.getKey()) && node.getValue().equals(otherNode.getValue())) {
                                notDelete = true;
                            }
                        }
                        if (!notDelete) {
                            remove(node);
                        }
                    }
                }
                return true;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                if(c == null){
                    return false;
                }
                for(Object node : c){
                    if(contains(node)){
                        remove(node);
                    }
                }
                return true;
            }

            @Override
            public void clear() {
                MyHashMap.this.clear();
            }

            @Override
            public String toString(){
                String res = "[";
                int counter = size();
                for(Entry<K, V> node : this){
                    res += node.toString();
                    counter--;
                    if(counter != 0){
                        res += ", ";
                    }
                }
                res += "]";
                return res;
            }
        };

        /**Заполненение переопределенного набора Set нодами из
         * элементов ключ-значение HashMap*/
        for (int i = 0; i < table.length; i++) {
            Iterator iterator = new BucketIterator(i);
            if(table[i] != null) {
                while (((BucketIterator) iterator).current != null) {
                    nodes.add(((BucketIterator) iterator).current);
                    iterator.next();
                }
            }
        }

        return nodes;
    }

    /**
     * Метод для вычесления хеша Node
     */
    public int hash(K key){
        int hash = 31;
        hash = hash * 17 + key.hashCode();
        if(hash < 0){
            hash *= -1;
        }
        return hash;
    }

    /**
     *  Метод, который выводит HashMap
     */
    @Override
    public String toString(){
        if(size == 0){
            return "[]";
        }
        String res = "[";
        /**Todo res += "\n";*/
        int counter = size;
        for (int i = 0; i < table.length; i++) {
            if(table[i] != null) {
                Iterator iterator = new BucketIterator(i);
                while (((BucketIterator) iterator).current != null) {
                    Node<K, V> node = ((BucketIterator) iterator).current;
                    res += node.toString();
                    counter--;
                    if(counter != 0){
                        res += ", ";
                    }
                    iterator.next();
                }
                /**Todo res += "\n";*/
            }
        }
        res += "]";
        return res;
    }


    /**
     *  Метод, для разширения HashMap в случае перехода порога допустимого
     *  количества элементов
     */
    public void resize(){
        if((size + 1) > threshold){
            MyHashMap<K,V> resizedHashMap = new MyHashMap<>(table.length);
            for (int i = 0; i < table.length; i++) {
                Iterator<K> iterator = new BucketIterator(i);
                while(((BucketIterator) iterator).current != null){
                    Node<K,V> node = ((BucketIterator) iterator).current;
                    resizedHashMap.put(node.getKey(), node.getValue());
                    iterator.next();
                }
            }
            System.out.println("HashMap разширяеться!!!!!");
            table = resizedHashMap.table;
            threshold = resizedHashMap.threshold;
        }
    }



    /**
     * Вспомагательный клас для хранения элементов HashMap.
     * Каждая Node содержит ключ, значение, хеш єлемента и ссылку
     * на следующий элемент в этой же корзине.
     */
    public static class Node<K,V> implements Entry<K,V> {
        final int hash;     //поле для хеша
        final K key;        //поле ключа ноды
        V value;            //поле значения ноды
        Node<K,V> next;     //поле отсылка на следующую ноду


        /**
         * Конструктор для создания Node по ключу и значению
         */
        Node(K key, V value, int hash) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = null;
        }

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = 0;
        }


        /**
         * Метод для получения ключа элемента
         */
        @Override
        public final K getKey(){
            return key;
        }

        /**
         * Метод для получения значения элемента
         */
        @Override
        public final V getValue() {
            return value;
        }

        /**
         * Метод для задавания значения элемента
         */
        @Override
        public final V setValue(V newValue) {
            V oldValue = value;
            value = newValue;
            return oldValue;
        }


        /**
         * Метод для вывода элемента(его ключа и значения)
         */
        @Override
        public final String toString() {
            return key + " = " + value;
        }

    }







    /**
     * Клас итератора для корзины в HashMap
     */
    private class BucketIterator implements Iterator<K> {
        private Node<K,V> current;      //необходим для итерации по корзине


        /**
         * Конструктор итератора для корзины.
         * Индекс задает номер корзины, по списку элементов которой будем итерировать
         */
        BucketIterator(int index){
            current = table[index];
        }

        /**
         * Метод для проверки есть ли у после данного элемента еще элемент
         */
        @Override
        public boolean hasNext() {
            return current.next != null;
        }

        /**
         * Метод для перехода на следующий элемент списка
         */
        @Override
        public K next() {
            Node<K,V> node = current;
            current = current.next;
            return node.getKey();
        }
    }



    /**
     * Клас итератора для всего HashMap(необходим для values и keySet)
     */
    private class HashMapIterator implements Iterator<Node<K,V>> {
        private Node<K,V> preCurrent;
        private Node<K,V> current;      //необходим для итерации по корзине
        private int currentBucket;
        private int currentElement;

        /**
         * Конструктор итератора для корзины.
         * Индекс задает номер корзины, по списку элементов которой будем итерировать
         */
        HashMapIterator(){
            //currentBucket = 0;
            //currentElement = 0;
            current = table[currentBucket];
        }

        /**
         * Метод для проверки есть ли у после данного элемента еще элемент
         */
        @Override
        public boolean hasNext() {
            return currentBucket < table.length && currentElement < size();
        }

        /**
         * Метод для перехода на следующий элемент HashMap
         */
        @Override
        public Node next() {
            while(current == null){
                currentBucket++;
                if(currentBucket == table.length){
                    return null;
                }
                current = table[currentBucket];
            }
            Node<K,V> node = current;
            currentElement++;
            current = current.next;
            preCurrent = node;
            return node;
        }

        public Node<K,V> getCurrent(){
            return current;
        }
/*
        @Override
        public void remove(){
            while(current == null){
                currentBucket++;
                current = table[currentBucket];
            }

            if(current.next == null){
                current = null;
                preCurrent.next = null;
                size--;
            }
            else {
                current = current.next;
                preCurrent.next = current;
                size--;
            }


        }
*/
    }
}
