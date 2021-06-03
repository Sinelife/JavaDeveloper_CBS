package _1_java_starter.homeworks.homework03;

public class ArrayHomework {

    //Метод для вывода массива
    private static void outputArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
    }

    //Метод для того чтоб поменять местами два элемента масива по индексам
    private static void swapElementsInArray(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    //Метод, который возвращает максимальный элемент масива
    private static int maxElementInArray(int[] arr) {
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    //Метод, который возвращает ындекс максимального элемент масива
    private static int indexOfMaxElementInArray(int[] arr) {
        int max_index = 0;
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                max_index = i;
            }
        }
        return max_index;
    }

    //Метод, который возвращает индекс минимального элемента масива
    private static int indexOfMinElementInArray(int[] arr) {
        int min_index = 0;
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    //Метод, который возвращает индекс второго по размеру элемента масива
    private static int indexOfSecondMaxElementInArray(int[] arr) {
        int first_max = maxElementInArray(arr);
        int second_max = arr[0];
        int second_index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != first_max) {
                if (arr[i] > second_max) {
                    second_max = arr[i];
                    second_index = i;
                }
            }
        }
        return second_index;
    }

    //Метод, который возвращает минимальный элемент масива
    private static int minElementInArray(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }


    public static void main(String[] args) {
        int[] arr = {-5, -4, -3, -2, -1, 1, 2, 3, 2, 4, 5, 6, 7, 8, 8, 9, 10, 11, 12, 13, 14};

        /** 1. Вывести в консоль все парные числа одномерного массива.*/
        System.out.println("Exercise 1(Вывести все парные элементы масива)");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                System.out.print(arr[i] + ", ");
            }
        }

        /** 2. Вывести все числа одномерного массива в обратном порядке.*/
        System.out.println("\n\nExercise 2(Вывести в обратном порядке масив)");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr[i] + ", ");
        }


        /** 3. Вывести первую и вторую половину одномерного массива.*/
        System.out.println("\n\nExercise 3(Вывести обе половины масива)");
        System.out.print("Первая половина - ");
        for (int i = 0; i < (arr.length / 2); i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("\nВторая половина - ");
        for (int i = arr.length / 2; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }

        /** 4. Вывести первую и вторую половину одномерного массива в обратном порядке.*/
        System.out.println("\n\nExercise 4(Вывести в обратном порядке обе половины масива)");
        System.out.print("Первая половина - ");
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print("\nВторая половина - ");
        for (int i = arr.length - 1; i >= (arr.length / 2); i--) {
            System.out.print(arr[i] + ", ");
        }

        /** 5. Найти сумму всех элементов в массиве.*/
        System.out.println("\n\nExercise 5(Найти суму елементов)");
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.print("Сума: " + sum);

        /** 6. Найти среднеарифметическое всех чисел массива.*/
        System.out.println("\n\nExercise 6(Найти среднее арифметическое)");
        double average = (double) sum / arr.length;
        System.out.print("Среднее арифметическое: " + average);

        /** 7. Найти минимальное и максимальное число в массиве.*/
        System.out.println("\n\nExercise 7(Найти max и min)");
        int max = maxElementInArray(arr);
        int min = minElementInArray(arr);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);

        /** 8. Заменить все отрицательные числа в массиве на 0. */
        System.out.println("\nExercise 8(Заменить все отрицательные елементы на 0)");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr[i] = 0;
            }
            System.out.print(arr[i] + ", ");
        }

        /** 9. Подсчитать одинаковые числа в одномерном массиве. */
        System.out.println("\n\nExercise 9(Подсчитать одинаковые елементы в масиве)");
        int[][] elem_count = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            elem_count[i][0] = -1000;
        }
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isNotRepeat = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == elem_count[j][0]) {
                    isNotRepeat = false;
                }
            }
            if (isNotRepeat == true) {
                elem_count[counter][0] = arr[i];
                counter++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (elem_count[i][0] == arr[j]) {
                    elem_count[i][1]++;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (elem_count[i][0] != -1000) {
                System.out.println("Число " + elem_count[i][0] + " встречається " + elem_count[i][1] + " раз");
            }
        }

        /** 10. Поменять минимальное и максимальное числа в массиве местами.*/
        System.out.println("\n\nExercise 10(Поменять max и min местами)");
        arr[2] = -10;
        int min_index = indexOfMinElementInArray(arr);
        int max_index = indexOfMaxElementInArray(arr);
        System.out.print("До изменения - ");
        outputArray(arr);
        swapElementsInArray(arr, min_index, max_index);
        System.out.print("\nПосле изменения - ");
        outputArray(arr);

        /** 11. Инвертировать массив.*/
        System.out.println("\n\nexercise 11(Инвертировать массив)");
        for (int i = 0; i < (arr.length / 2); i++) {
            swapElementsInArray(arr, i, arr.length - 1 - i);
        }
        outputArray(arr);

        /** 12. Вывести в консоль половину массива, среднеарифметическое которых является большим.*/
        System.out.println("\n\nexercise 12(ввести половину среднее арифметическое, которой больше)");
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < (arr.length / 2); i++) {
            sum1 += arr[i];
        }
        double average1 = sum1 / (arr.length / 2);
        for (int i = arr.length / 2; i < arr.length; i++) {
            sum2 += arr[i];
        }
        double average2 = sum2 / (arr.length / 2);
        if (average1 > average2) {
            for (int i = 0; i < (arr.length / 2); i++) {
                System.out.print(arr[i] + ", ");
            }
        } else {
            for (int i = arr.length / 2; i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
                ;
            }
        }

        /** 13. Найти сумму отрицательных чисел в одномерном массиве.*/
        System.out.println("\n\nExercise 13(Найти суму всех отрицательных чисел)");
        arr[4] = -10;
        arr[9] = -7;
        arr[10] = -2;
        sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                sum += arr[i];
            }
        }
        System.out.print("Сума: " + sum);

        /** 14. Дан массив чисел, среди которых имеется один ноль. Вывести на печать все числа до нуля включительно.*/
        System.out.println("\n\nExercise 14(Все єлементы масива до 0)");
        arr[0] = 10;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
            if (arr[i] == 0) {
                break;
            }
        }

        /** 15. Написать программу, меняющую местами два наибольших элемента одномерного массива с первым и последним.*/
        System.out.println("\n\nExercise 15(Поменять два больших числа с первым и последним)");
        int first_index = indexOfMaxElementInArray(arr);
        int second_index = indexOfSecondMaxElementInArray(arr);
        System.out.print("До изменения - ");
        outputArray(arr);
        swapElementsInArray(arr, first_index, 0);
        swapElementsInArray(arr, second_index, arr.length - 1);
        System.out.print("\nПосле изменения - ");
        outputArray(arr);

        /** 16. Написать программу, которая выводит на экран элементы одномерного массива, которые расположены до минимального элемента всего массива.*/
        System.out.println("\n\nExercise 16(Вывести все элементы до минимального)");
        min_index = indexOfMinElementInArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i == min_index) {
                break;
            }
            System.out.print(arr[i] + ", ");
        }

        /** 17. Найти сумму всех чисел находящихся между минимальным и максимальным числом в массиве.*/
        System.out.println("\n\nExercise 17(Вывести все элементы между min и max)");
        min_index = indexOfMinElementInArray(arr);
        max_index = indexOfMaxElementInArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (min_index < max_index) {
                if (i > min_index && i < max_index) {
                    System.out.print(arr[i] + ", ");
                }
            } else {
                if (i > max_index && i < min_index) {
                    System.out.print(arr[i] + ", ");
                }
            }
        }

        /** 18. Вывести в консоль половину массива в которой находиться наименьшее число массива.*/
        System.out.println("\n\nExercise 18(Вывести половину масива, в которой есть min)");
        min_index = indexOfMinElementInArray(arr);
        if (min_index < (arr.length / 2)) {
            for (int i = 0; i < (arr.length / 2); i++) {
                System.out.print(arr[i] + ", ");
            }
        } else {
            for (int i = (arr.length / 2); i < arr.length; i++) {
                System.out.print(arr[i] + ", ");
            }
        }

        /** 19. Написать программу, которая перемещает в конец массива все элементы, значения которых находитсяв отрезке [a,b].*/
        System.out.println("\n\nExercise 19(Переместить в конец все єлементы из диапазона[a,b])");
        int a = 2;
        int b = 6;
        System.out.println("Диапазон - [" + a + "," + b + "]");
        System.out.print("До изменения - ");
        outputArray(arr);
        for (int i = 0; i <= b - a; i++) {
            for (int j = a; j < arr.length - 1; j++) {
                swapElementsInArray(arr, j, j + 1);
            }
        }

        System.out.print("\nПосле изменения - ");
        outputArray(arr);
    }
}
