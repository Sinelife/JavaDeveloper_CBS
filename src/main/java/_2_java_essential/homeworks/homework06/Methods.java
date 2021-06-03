package _2_java_essential.homeworks.homework06;

import java.util.List;

public class Methods {

    /**
     * Метод для вывода списка
     */
    public static String output(List list) {
        String res = "[";
        for (int i = 0; i < list.size(); i++) {
            res += list.get(i);
            if (i < list.size() - 1) {
                res += ", ";
            }
        }
        res += "]";
        return res;
    }
}
