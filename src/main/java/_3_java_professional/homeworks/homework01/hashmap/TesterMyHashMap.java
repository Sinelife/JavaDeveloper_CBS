package _3_java_professional.homeworks.homework01.hashmap;


import java.util.*;

public class TesterMyHashMap {

    public static void main(String[] args) {
        Map<Integer, String> map = new MyHashMap<>();

        testerForHashMapMethods(map);
        testerForKeySetMethods(map);
        testerForValuesMethods(map);
        testerForEntrySetMethods(map);
    }




    /**
     * Метод, в котором тестируються все методы MyHashMap
     */
    public static void testerForHashMapMethods(Map map){
        /** Тест методов isEmpty(), size() и put(key,value)*/
        System.out.println("\t\t\t\t\tTEST: isEmpty(), size(), put(key,value)");
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        System.out.println("HashMap пустая? - " + map.isEmpty());
        fillMapWithElements(map, 6, true);
        System.out.println("HashMap пустая? - " + map.isEmpty());
        System.out.println("\n\n");


        /** Тест метода put(key,value) для ключа который уже есть*/
        System.out.println("\t\t\t\t\tTEST: put(key,value) для ключа который уже есть");
        int key = 4;
        String value = "Сатания";
        System.out.println("Добавляем значение " + value + " в HashMap по ключу " + key + ", который уже есть");
        map.put(key, value);
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        System.out.println("\n\n");



        /** Тест методов containsKey(key), containsValue(value)*/
        System.out.println("\t\t\t\t\tTEST: containsKey(key), containsValue(value)");
        System.out.println("HashMap - " + map);
        key = 44;
        System.out.println("Содержит ключ " + key + "? - " + map.containsKey(key));
        key = 1111;
        System.out.println("Содержит ключ " + key + "? - " + map.containsKey(key));
        value = "Гавриил";
        System.out.println("Содержит значение " + value + "? - " + map.containsValue(value));
        value = "Астарта";
        System.out.println("Содержит значение " + value + "? - " + map.containsValue(value));
        System.out.println("\n\n");



        /** Тест методов putAll(c)*/
        System.out.println("\t\t\t\t\tTEST: putAll(c)");
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        Map newMap = new MyHashMap();
        newMap.put(1212, "Аббадон");
        newMap.put(312, "Лилит");
        newMap.put(999, "Лилит");
        System.out.println("Добавляемая HashMap - " + newMap);
        map.putAll(newMap);
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        System.out.println("\n\n");



        /** Тест метода remove(key)*/
        System.out.println("\t\t\t\t\tTEST: remove(key)");
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        key = 44;
        System.out.println("Удаляем элемент по ключу " + key + " со значением " + map.remove(key));
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: clear()");
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        map.clear();
        System.out.println("HashMap - " + map);
        System.out.println("Размер - " + map.size());
        System.out.println("\n\n\n\n");
    }


    /**
     * Метод, в котором тестируються все методы Values(колекции значений
     * нашей MyHashMap)
     */
    public static void testerForValuesMethods(Map map){
        /** Тест для values()*/
        System.out.println("VALUES+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("\t\t\t\t\tTEST: values И ВСЕ ЕГО МЕТОДЫ");
        System.out.println("\t\t\t\t\tTEST: remove(), size()");
        fillMapWithElements(map, 7, false);
        Collection<String> values = map.values();
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        String value = "Баал";
        System.out.println("Удаляем из колекции значение " + value);
        values.remove(value);
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: removeAll()");
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        List<String> list2 = new ArrayList<>();
        list2.add("Аввесалом");
        list2.add("Гавриил");
        list2.add("Набериус");
        values.removeAll(list2);
        System.out.println("Список удаляемых значений - " + list2);
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: retainAll()");
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        list2 = new ArrayList<>();
        list2.add("Гавриил");
        list2.add("Астарта");
        list2.add("Самаэль");
        values.retainAll(list2);
        System.out.println("Список неудаляемых ключей - " + list2);
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: clear(), isEmpty()");
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        System.out.println("Values пустой? - " + values.isEmpty());
        values.clear();
        System.out.println("HashMap - " + map);
        System.out.println("Values - " + values);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Values - " + values.size());
        System.out.println("Values пустой? - " + values.isEmpty());
        System.out.println("\n\n\n\n");
    }


    /**
     * Метод, в котором тестируються все методы KeySet(набора ключей
     * нашей MyHashMap)
     */
    public static void testerForKeySetMethods(Map map){
        /** Тест для keySet()*/
        System.out.println("KEYSET-------------------------------------------------------------------------------------");
        System.out.println("\t\t\t\t\tTEST: KeySet И ВСЕ ЕГО МЕТОДЫ");
        System.out.println("\t\t\t\t\tTEST: remove(), size()");
        fillMapWithElements(map, 6, false);
        Set<Integer> keys = map.keySet();
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        int key = 16;
        System.out.println("Удаляем из набора ключей ключ " + key);
        keys.remove(key);
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: removeAll()");
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        List<Integer> list = new ArrayList<>();
        list.add(14);
        list.add(44);
        list.add(99);
        keys.removeAll(list);
        System.out.println("Список удаляемых ключей - " + list);
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: retainAll()");
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        list = new ArrayList<>();
        list.add(24);
        list.add(54);
        list.add(64);
        keys.retainAll(list);
        System.out.println("Список неудаляемых ключей - " + list);
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        System.out.println("\n\n");


        System.out.println("\t\t\t\t\tTEST: clear(), isEmpty()");
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        System.out.println("Keys пустой? - " + keys.isEmpty());
        keys.clear();
        System.out.println("HashMap - " + map);
        System.out.println("Keys - " + keys);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер Keys - " + keys.size());
        System.out.println("Keys пустой? - " + keys.isEmpty());
        System.out.println("\n\n\n");
    }


    /**
     * Метод, в котором тестируються все методы EntrySet(набора элементов
     * ключ-значение нашей MyHashMap)
     */
    public static void testerForEntrySetMethods(Map map){
        /** Тест для entrySet()*/
        System.out.println("ENTRYSET====================================================================================================");
        System.out.println("\t\t\t\t\tTEST: entrySet И ВСЕ ЕГО МЕТОДЫ");
        System.out.println("\t\t\t\t\tTEST: remove(), size()");
        fillMapWithElements(map, 7, false);
        Set<Map.Entry<Integer, String>> elements = map.entrySet();
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        MyHashMap.Node element = new MyHashMap.Node(54,"Баал");
        System.out.println("Удаляем из колекции значение " + element);
        elements.remove(element);
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("\n\n");


        System.out.println("\t\t\t\t\tTEST: removeAll()");
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        List<MyHashMap.Node<Integer,String>> list3 = new ArrayList<>();
        list3.add(new MyHashMap.Node(44,"Аввесалом"));
        list3.add(new MyHashMap.Node(445,"Гавриил"));
        list3.add(new MyHashMap.Node(64,"Набериус"));
        elements.removeAll(list3);
        System.out.println("Список удаляемых значений - " + list3);
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("\n\n");


        System.out.println("\t\t\t\t\tTEST: retainAll()");
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        list3 = new ArrayList<>();
        list3.add(new MyHashMap.Node(34,"Астарта"));
        list3.add(new MyHashMap.Node(445,"Гавриил"));
        list3.add(new MyHashMap.Node(24,"Самаэль"));
        elements.retainAll(list3);
        System.out.println("Список неудаляемых ключей - " + list3);
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: add()");
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        MyHashMap.Node newElement = new MyHashMap.Node(5400,"Бельфегор");
        System.out.println("Добавляем элемент: " + newElement.toString());
        elements.add(newElement);
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: addAll()");
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        List<MyHashMap.Entry<Integer,String>> newElements = new ArrayList<>();
        newElements.add(new MyHashMap.Node(580,"Асмодей"));
        newElements.add(new MyHashMap.Node(4800,"Лилит"));
        newElements.add(new MyHashMap.Node(5400,"Маммон"));
        System.out.println("Добавляемая колекция - " + newElements);
        elements.addAll(newElements);
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("\n\n");



        System.out.println("\t\t\t\t\tTEST: clear(), isEmpty()");
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("EntrySet пустой? - " + elements.isEmpty());
        elements.clear();
        System.out.println("HashMap - " + map);
        System.out.println("EntrySet - " + elements);
        System.out.println("Размер HashMap - " + map.size());
        System.out.println("Размер EntrySet - " + elements.size());
        System.out.println("EntrySet пустой? - " + elements.isEmpty());
        System.out.println("\n\n\n\n");
    }



    /**
     * Метод для заполнения HashMap данными из масива строк с
     * подсчитаными по формуле ключами
     */
    public static void fillMapWithElements(Map<Integer,String> map, int n, boolean output){
        if(!output){
            for (int i = 0; i < n; i++) {
                int key = (i * 5 + 2) * 2;
                String value = Constants.names[i];
                map.put(key, value);
                if(i % 3 == 0){
                    key *= (i * 5 + 2) * 2;
                    value = Constants.names[i];
                    map.put(key, value);
                }
            }
        }
        else {
            for (int i = 0; i < n; i++) {
                int key = (i * 5 + 2) * 2;
                String value = Constants.names[i];
                System.out.println("\tДобавление элемента: " + key + " = " + value);
                map.put(key, value);
                System.out.println("HashMap - " + map);
                System.out.println("Размер - " + map.size());
                if (i % 3 == 0) {
                    key *= (i * 5 + 2) * 2;
                    value = Constants.names[i];
                    System.out.println("\tДобавление элемента: " + key + " = " + value);
                    map.put(key, value);
                    System.out.println("HashMap - " + map);
                    System.out.println("Размер - " + map.size());
                }
            }
        }
    }
}
