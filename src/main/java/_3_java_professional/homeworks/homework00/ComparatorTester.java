package _3_java_professional.homeworks.homework00;

import java.lang.reflect.Field;
import java.util.Comparator;
import java.util.List;


/** Тестер для проверки роботы Comparator для списка имплементирующего
 *  интерфейс List*/

public class ComparatorTester {
    public static void main(String[] args) {
        List<Character> list = new MyLinkedList<>();
        fillListWithSomeElements(list);

        System.out.println("\t\t\tТЕСТ КОМПАРАТОРА для " + list.getClass().getSimpleName());
        System.out.println("Не отсортированый список.");
        System.out.println(Methods.toStringList(list));
        System.out.println("\nСписок отсортированый по убыванию силы.");
        outputSortedListByField(list, "power");
        System.out.println("\nСписок отсортированый по имени в алфавитном порядке.");
        outputSortedListByField(list, "name");
        System.out.println("\nСписок отсортированый высоте ранга.");
        outputSortedListByField(list, "rank");


    }

    /** Метод для заполнения списка какимито значениями для тестов*/
    public static void fillListWithSomeElements(List<Character> list){
        list.add(new Character("Эллейн", "эльф", "лучник", Character.Rank.S, 510));
        list.add(new Character("Валор", "человек", "паладин", Character.Rank.A, 450));
        list.add(new Character("Ромерик", "гном", "воин", Character.Rank.B, 390));
        list.add(new Character("Баал", "демон", "маг", Character.Rank.S, 560));
        list.add(new Character("Вулфрик", "гном", "жрец", Character.Rank.B, 430));
        list.add(new Character("Элвин", "эльф", "друид", Character.Rank.A, 440));
        list.add(new Character("Эдмунд", "человек", "маг", Character.Rank.SS, 610));

    }


    /** Метод для сортировки списка по переданому полю и вывода его на экран*/
    public static void outputSortedListByField(List<Character> list, String comparableField){
        Comparator<Character> comparator = ChooseComparator(new Character(), comparableField);
        //Collections.sort(list,comparator);
        list = Methods.selectionSort(list, comparator);
        System.out.println(Methods.toStringList(list));
    }


    /** Метод, который возвращает Comparator необходимый для сортировки
     * переданого поля*/
    public static Comparator ChooseComparator(Character c , String comparableField) {
        List<String> fieldList = new MyLinkedList<>();
        Field[] fields = c.getClass().getDeclaredFields();
        for(Field field : fields){
            fieldList.add(field.toString());
        }
        if(comparableField.equals("power")){
            return new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return o2.getPower() - o1.getPower();
                }
            };
        }
        if(comparableField.equals("name")){
            return new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    for (int i = 0; i < 3; i++) {
                        if(o1.getName().charAt(i) != o2.getName().charAt(i)) {
                            return o1.getName().charAt(i) - o2.getName().charAt(i);
                        }
                    }
                    return o2.getPower() - o1.getPower();
                }
            };
        }
        if(comparableField.equals("rank")){
            return new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    if(o1.getRank().equals(o2.getRank())){
                        return o2.getPower() - o1.getPower();
                    }
                    return o1.getRank().compareTo(o2.getRank());

                }
            };
        }
        return null;
    }


    /*
    public static <E> Comparator ChooseComparator(E elem , String comparableField){
        List<String> fieldList = new MyLinkedList<>();
        Field[] fields = elem.getClass().getDeclaredFields();
        Field chosenField;
        for(Field field : fields){
            fieldList.add(field.toString());
            if(field.toString().equals(comparableField)){
                chosenField = field;
            }
        }
        for(String field :fieldList){
            if(field.equals(comparableField)){
                Comparator<E> comparator = new Comparator<E>() {
                    @Override
                    public int compare(E o1, E o2) {
                        return 0;
                    }
                };
                return comparator;
            }
        }
        return null;
    }*/


}
