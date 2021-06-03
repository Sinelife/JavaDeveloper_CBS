package _3_java_professional.homeworks.homework00;

import java.util.List;


/**Клас вызывающий метод run() класа TesterOfMethodsOfMyChosenList*/

public class Tester {
    public static void main(String[] args) {
        List myArrayList = new MyArrayList();
        List myLinkedList = new MyLinkedList();

        //cюда можно подставить имя того списка, который нужно протестировать
        TesterOfMethodsOfMyChosenList t = new TesterOfMethodsOfMyChosenList(myLinkedList);
        t.run();
    }
}
