package _1_java_starter.classworks.classwork05;

public class StringMethods {

    private static String subString(String str, int from, int to) {
        if (from < 0 || to > str.length() || to < from) {
            return "Ошибка ввода.";
        }
        char[] chars = str.toCharArray();
        String result = "";
        for (int i = from; i < to; i++) {
            result += chars[i];
        }
        return result;
    }


    private static String maxSimpleSubstring(String str1, String str2) {
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        String[] result = new String[100];
        int wordCounter = 0;
        for (int i = 0; i < chars1.length; i++) {
            for (int j = 0; j < chars2.length; j++) {
                if (chars1[i] == chars2[j]) {
                    result[wordCounter] = "" + chars1[i];
                    for (int k = 1; k < chars1.length - i; k++) {
                        if (chars1[i + k] == chars2[j + k]) {
                            result[wordCounter] += chars1[i + k];
                        } else {
                            wordCounter++;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < wordCounter; i++) {
            System.out.println(i + ")" + result[i]);
        }
        String maxResult = "";
        for (int i = 0; i < wordCounter; i++) {
            if (maxResult.length() < result[i].length()) {
                maxResult = result[i];
            }
        }
        return maxResult;
    }


    public static void main(String[] args) {
        String str1 = "Hello,__WWWWorld!";
        //System.out.println(subString(str1, 1, 6));
        String str2 = ",Hello,People__WWWWorld!";

        System.out.println(maxSimpleSubstring(str1, str2));
    }
}
