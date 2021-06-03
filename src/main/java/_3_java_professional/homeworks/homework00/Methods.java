package _3_java_professional.homeworks.homework00;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Methods {

    /** Метод для вывода элементов списка*/
    public static <E> String toStringList(List<E> list){
        int counter = 1;
        String res = "";
        Iterator<E> iterator = list.iterator();
        while(iterator.hasNext()){
            res += counter + ")" + iterator.next() + "\n";
            counter++;
        }
        return res;
    }



    /** Метод для вывода масива*/
    public static <E> String arrayOutput(E[] array){
        String res = "[";
        for (int i = 0; i < array.length; i++) {
            if(i == array.length - 1){
                res += array[i].toString() + "]";
            }
            else{
                res += array[i].toString() + ", ";
            }
        }
        return res;
    }
    

    /** Метод, который возвращает отсортированый пузырьковым методом список
     *  по переданому Comparator*/
    public static <E> List<E> bubbleSort(List<E> list, Comparator<? super E> c){
        E[] array = (E[])list.toArray();
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (c.compare(array[j], array[j + 1]) > 0)
                {
                    E tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                }
            }
        }
        list.clear();
        for (int i = 0; i < array.length; i++) {
            list.add(array[i]);
        }
        return list;
    }



    /** Метод, который возвращает отсортированый методом выбором список
     *  по переданому Comparator*/
    public static <E> List<E> selectionSort(List<E> list, Comparator<? super E> c){
        E[] array = (E[])list.toArray();
        for (int i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (c.compare(array[j], array[min_index]) < 0) {
                    min_index = j;
                }
            }
            E temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
        list.clear();
        for (int k = 0; k < array.length; k++) {
            list.add(array[k]);
        }
        return list;
    }
}
