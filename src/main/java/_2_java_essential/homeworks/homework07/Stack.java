package _2_java_essential.homeworks.homework07;

public class Stack {

    private Object[] values;
    private int size;
    private int capacity;

    /**
     * Конструктор по умолчанию
     */
    Stack() {
        this.capacity = 10;
        this.values = new Object[capacity];
    }


    /**
     * Конструктор с заданой вместимостью
     */
    Stack(int capacity) {
        this.capacity = capacity;
        this.values = new Object[capacity];
    }


    /**
     * Метод, который возвращает размер списка
     */
    public int size() {
        return size;
    }

    /**
     * Метод, который удаляет обьект из стека
     */
    public boolean pull() {
        if (size == 0) {
            return false;
        }
        values[size - 1] = null;
        size--;
        return true;
    }


    /**
     * Метод, который добавляет обьект в конец списка
     */
    public boolean push(Object o) {
        if (o == null) {
            return false;
        }
        increaseCapacity();
        values[size] = o;
        size++;
        return true;
    }


    /**
     * Дополнительный метод
     * Метод для копирования списка
     */
    private void copy(Object[] arrayWhichCopy, Object[] arrayWhereCopy, int from, int to) {
        for (int i = from, j = 0; i < to; i++, j++) {
            arrayWhereCopy[i] = arrayWhichCopy[j];
        }
    }


    /**
     * Дополнительный метод
     * Метод для разширения списка
     */
    private void increaseCapacity() {
        if (capacity == size + 1) {
            capacity = (int) (capacity * 1.5);
            Object[] newValues = new Object[capacity];
            copy(values, newValues, 0, size);
            values = newValues;
        }
    }

    /**
     * Метод для вывода стека
     */
    @Override
    public String toString() {
        String res = "[";
        for (int i = 0; i < size; i++) {
            res += values[i];
            if (i < size - 1) {
                res += ", ";
            }
        }
        res += "]";
        return res;
    }
}
