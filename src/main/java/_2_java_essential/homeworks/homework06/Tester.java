package _2_java_essential.homeworks.homework06;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Tester {
    public static void main(String[] args) {
        List myArrayList = new MyArrayList();


        /** Тест методов isEmpty() и size()*/
        System.out.println("\t\t\tTEST: isEmpty(), size()");
        System.out.println("Пустой ли список? " + myArrayList.isEmpty());
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("\n");


        /** Тест метода add(Object o)*/
        System.out.println("\t\t\tTEST: add(Object o)");
        for (int i = 0; i < 10; i++) {
            System.out.println("Добавим элемент " + i);
            myArrayList.add(i);
        }
        System.out.println("Пустой ли список? " + myArrayList.isEmpty());
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("\n");


        /** Тест метода contains(Object o)*/
        System.out.println("\t\t\tTEST: contains(Object o)");
        int a = 1000;
        int b = 3;
        System.out.println("Элемент " + a + " входит в список? - " + myArrayList.contains(a));
        System.out.println("Элемент " + b + " входит в список? - " + myArrayList.contains(b));
        System.out.println("\n");


        /** Тест метода add(int index, Object element)*/
        System.out.println("\t\t\tTEST: add(int index, Object element)");
        int k = 100;
        int index = 2;
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Добавим элемент " + k + " по индексу " + index);
        myArrayList.add(index, k);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Добавим элемент " + (k + 11) + " по индексу " + myArrayList.size());
        myArrayList.add(myArrayList.size(), k + 11);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("\n");


        /** Тест методов remove(Object o) и remove(int index)*/
        System.out.println("\t\t\tTEST: remove(Object o) и remove(int index)");
        k = 6;
        index = 6;
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Удалим элемент " + k);
        myArrayList.remove((Object) k);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Удалим элемент по индексу " + index);
        myArrayList.remove(index);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("\n");


        /** Тест метода get(int index)*/
        System.out.println("\t\t\tTEST: get(int index)");
        for (int i = 0; i < myArrayList.size(); i++) {
            System.out.println("Элемент по индексу " + i + " - " + myArrayList.get(i));
        }
        System.out.println("\n");


        /** Тест метода set(int index)*/
        System.out.println("\t\t\tTEST: set(int index)");
        k = 100;
        index = 9;
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Меняем элемент по индексу " + index + " на " + k);
        myArrayList.set(index, k);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("\n");


        /** Тест метода indexOf() и lastIndexOf()*/
        System.out.println("\t\t\tTEST: indexOf() и lastIndexOf()");
        System.out.println("Индекс первого вхождения елемента " + k + " = " + myArrayList.indexOf(k));
        System.out.println("Индекс последнего вхождения елемента " + k + " = " + myArrayList.lastIndexOf(k));
        System.out.println("\n");


        /** Тест метода addAll(int index, Collection c)*/
        System.out.println("\t\t\tTEST: addAll(int index, Collection c)");
        Collection linkedList = new LinkedList();
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        linkedList.add(200);
        linkedList.add(300);
        index = 2;
        System.out.println("Добавляемая колекция - " + linkedList + " по индексу " + index);
        myArrayList.addAll(index, linkedList);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("\n");


        /** Тест метода addAll(Collection c)*/
        System.out.println("\t\t\tTEST: addAll(Collection c)");
        Collection arrayList = new ArrayList();
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        arrayList.add(444);
        arrayList.add(555);
        arrayList.add(666);
        System.out.println("Добавляемая колекция - " + arrayList);
        myArrayList.addAll(arrayList);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("\n");


        /** Тест метода containsAll(Collection c)*/
        System.out.println("\t\t\tTEST: containsAll(Collection c)");
        arrayList = new ArrayList();
        System.out.println("Список - " + Methods.output(myArrayList));
        arrayList.add(1);
        arrayList.add(555);
        arrayList.add(666);
        System.out.println("Колекция - " + arrayList);
        System.out.println("Входит колекция в список? - " + myArrayList.containsAll(arrayList));
        arrayList = new ArrayList();
        arrayList.add(444);
        arrayList.add(555);
        arrayList.add(10000);
        System.out.println("Колекция - " + arrayList);
        System.out.println("Входит колекция в список? - " + myArrayList.containsAll(arrayList));
        System.out.println("\n");


        /** Тест метод removeAll(Collection c)*/
        System.out.println("\t\t\tTEST: removeAll(Collection c)");
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        arrayList = new ArrayList();
        arrayList.add(100);
        arrayList.add(1);
        System.out.println("Колекция(для удаления) - " + arrayList);
        myArrayList.removeAll(arrayList);
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("\n");


        /** Тест метода clear()*/
        System.out.println("\t\t\tTEST: clear()");
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Удаляем все элементы методом clear()");
        myArrayList.clear();
        System.out.println("Список - " + Methods.output(myArrayList));
        System.out.println("Размер списка = " + myArrayList.size());
        System.out.println("Пустой ли список? " + myArrayList.isEmpty());

    }


}
