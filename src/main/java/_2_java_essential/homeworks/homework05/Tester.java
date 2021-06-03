package _2_java_essential.homeworks.homework05;


import _2_java_essential.homeworks.homework06.MyArrayList;
import _3_java_professional.homeworks.homework00.MyLinkedList;

import java.util.*;


/**
 * Клас тестер, вызывающий метод run класа TimeCounter
 */
public class Tester {
    public static final int LIST_SIZE = 3_000_000;


    public static void main(String[] args) {
        List<Object> arrayList = new ArrayList<>();
        TimeCounter tc = new TimeCounter(arrayList, LIST_SIZE);
        //tc.run();

        List<Object> linkedList = new LinkedList<>();
        tc = new TimeCounter(linkedList, LIST_SIZE);
        //tc.run();

        List<Object> myArrayList = new _2_java_essential.homeworks.homework06.MyArrayList();
        tc = new TimeCounter(myArrayList, LIST_SIZE);
        //tc.run();


        List<Object> myArrayList3 = new MyArrayList<>();
        tc = new TimeCounter(myArrayList3, LIST_SIZE);
        //tc.run();

        List<Object> myLinkedList = new MyLinkedList<>();
        tc = new TimeCounter(myLinkedList, LIST_SIZE);
        tc.run();
    }
}
