package _3_java_professional.classworks.classwork04;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\Ярослав\\IdeaProjects\\java-developer-2018-autumn\\Yaroslav\\src\\main\\java\\java_essential");
        getFileNamesOfDirectory(directory);
    }



    public static void getFileNamesOfDirectory(File directory) {
        if (directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isDirectory()) {
                    getFileNamesOfDirectory(file);
                } else {
                    System.out.println(file.getName());
                }
            }
        }
    }


    public static void getFileNamesOfDirectoryQueue(File directory) {
        Queue<File> queue = new LinkedList<>();
        queue.add(directory);
        while(!queue.isEmpty()) {
            for (File file : queue) {
                if (file.isDirectory()) {

                }
            }
        }
    }
}
