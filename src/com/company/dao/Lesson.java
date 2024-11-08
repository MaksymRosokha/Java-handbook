package com.company.dao;

import com.company.Interface.ConsoleColor;
import com.company.bl.Filter;

import java.io.*;
import java.util.ArrayList;

/**
 * Клас уроків
 */
public class Lesson extends ReaderFile {

    /**
     * Список уроків
     */
    private static ArrayList<File> listOfLessons = new ArrayList<>();

    /**
     * Шлях до файлів з уроками
     */
    private static final String PATH_TO_LESSONS = new File("Data\\Lessons").getAbsolutePath();

    /**
     * Повертає список уроків
     *
     * @return повертає список уроків
     */
    public static ArrayList<File> getListOfLessons() {
        makeListOfLessons();
        return listOfLessons;
    }

    /**
     * Отримує список файлів, після їхньої фільтрації
     *
     * @param filterFiles відфільтровані файли
     */
    public static void setListOfLessons(ArrayList<File> filterFiles) {
        listOfLessons.clear();

        for (File file : filterFiles) {
            listOfLessons.add(file);
        }
    }

    /**
     * Виводить на екран список уроків
     *
     * @return повертає true якщо вдалося вивести файли, якщо ні то false
     * @throws IOException виняток
     */
    public static boolean showListOfLessons() throws IOException {
        System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
        System.out.println("Список уроків:");

        boolean isLessons = makeListOfLessons();

        int i = 0;

        if (isLessons) {
            for (File lesson : listOfLessons) {
                System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                System.out.println(i + " - " + lesson.getName().substring(3, (lesson.getName().length() - 4)));

                i++;
            }
            return true; //Є файли
        }
        return false;//Файлів немає
    }

    /**
     * Заповнює список уроків файлами
     *
     * @return повертає true якщо вдалося знайти файли, якщо ні то false
     */
    public static boolean makeListOfLessons() {
        File file = new File(PATH_TO_LESSONS);

        if (Filter.getIsFilter() == false) {
            listOfLessons.clear();

            if (file.listFiles() != null) {
                for (File s : file.listFiles()) {
                    if (s.isFile()) {
                        listOfLessons.add(s);
                    }
                }
                return true;
            } else {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("\nНе вдалося знайти файли уроків Java\n");
                return false;
            }
        } else {
            return true;
        }
    }

    /**
     * Визначай файл, який вибрав користувач
     *
     * @return повертає вибраний файл
     * @throws IOException виняток
     */
    public static File selectedFile() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;

        do {
            System.out.print(ConsoleColor.PURPLE_BOLD_BRIGHT);
            System.out.print("Виберіть урок: ");
            try {
                index = Integer.parseInt(input.readLine());
                System.out.println("");
            } catch (Exception ex) {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
                continue;
            }

            if (index < listOfLessons.size() && index >= 0) {
                break;
            } else {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("Помилка! Не правильно введене число. Спробуйте ще раз.\n");
                continue;
            }
        } while (true);

        return listOfLessons.get(index);
    }
}
