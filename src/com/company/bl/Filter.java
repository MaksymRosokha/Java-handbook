package com.company.bl;

import com.company.Interface.ConsoleColor;
import com.company.dao.Lesson;

import java.io.*;
import java.util.ArrayList;

/**
 * Даний клас призначений для фільтрування уроків
 */
public class Filter {

    /**
     * Перевіряє чи був уже відфільтрований список
     */
    private static boolean isFilter = false;

    /**
     * Даний метод повертає true якщо список був відфільтрований, false якщо ні
     *
     * @return повертає чи відфільтрований список
     */
    public static boolean getIsFilter() {
        return isFilter;
    }

    /**
     * Даний метод визначає вибір користувача
     *
     * @throws IOException виняток
     */
    public static void filter() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int command = 0;

        while (true) {
            System.out.print(ConsoleColor.WHITE_BOLD_BRIGHT);
            System.out.println("По чому бажаєте фільтрувати?");
            System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
            System.out.print("1 - По спаданню\n" +
                    "2 - По зростанню\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
                    "Команда: ");

            try {
                command = Integer.parseInt(input.readLine());
                System.out.println("");
            } catch (Exception ex) {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
                continue;
            }

            switch (command) {
                case 1: {
                    if (!isFilter) {
                        filterInDescendingOrder();
                        isFilter = !isFilter;
                    } else {
                        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                        System.out.println("Список уже відфільтрований по спаданню\n");
                    }
                    break;
                }
                case 2: {
                    if (isFilter) {
                        filterByGrowth();
                        isFilter = !isFilter;
                    } else {
                        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                        System.out.println("Список уже відфільтрований по зростанню\n");
                    }
                    break;
                }
                default: {
                    System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                    System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
                    continue;
                }
            }

            break;//Вихід з циклу
        }

    }

    /**
     * Фільтрує в порядку спадання
     */
    private static void filterInDescendingOrder() {
        ArrayList<File> fileArrayList = Lesson.getListOfLessons();
        ArrayList<File> temporaryList = new ArrayList<>();

        for (int i = (fileArrayList.size() - 1); i >= 0; i--) {
            temporaryList.add(fileArrayList.get(i));
        }

        Lesson.setListOfLessons(temporaryList);

    }

    /**
     * Фільтрує в порядку зростання
     */
    private static void filterByGrowth() {
        ArrayList<File> fileArrayList = Lesson.getListOfLessons();
        ArrayList<File> temporaryList = new ArrayList<>();

        for (int i = (fileArrayList.size() - 1); i >= 0; i--) {
            temporaryList.add(fileArrayList.get(i));
        }

        Lesson.setListOfLessons(temporaryList);
    }

}
