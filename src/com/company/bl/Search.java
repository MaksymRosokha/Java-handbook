package com.company.bl;

import com.company.Interface.ConsoleColor;
import com.company.dao.GeneralInformation;
import com.company.dao.Lesson;
import com.company.dao.ReaderFile;

import java.io.*;

/**
 * Клас, у якому реалізований пошук
 */
public class Search {

    /**
     * Знаходить файл який увів користувач, і читає його. Якщо файл не знайшовся, то з'явится
     * відповідне повідомлення, і буде запропоновано повернутися до меню
     *
     * @throws IOException виняток
     */
    public static void find() throws IOException {

        String enteredFile = ask(); //змінна для отримання вводу користувача
        String forComparison; //змінна для отримання назви файлу без індексу і розширення (бо користувач буде вводити без них)

        for (File file : Lesson.getListOfLessons()) {

            forComparison = file.getName().substring(3, (file.getName().length() - 4));

            if (enteredFile.equals(forComparison)) {
                System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
                System.out.println("Файл знайдений");
                ReaderFile readerFile = new Lesson();
                readerFile.readFile(file);
                return;
            }
        }

        for (File file : GeneralInformation.getListOfGeneralInformation()) {

            forComparison = file.getName().substring(3, (file.getName().length() - 4));

            if (enteredFile.equals(forComparison)) {
                System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
                System.out.println("\nФайл знайдений\n");
                ReaderFile readerFile = new GeneralInformation();
                readerFile.readFile(file);
                return;
            }
        }
        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("\nФайл не знайдений\n");
    }

    /**
     * Запитує у користувача, що потрібно знайти
     *
     * @return повертає те, що увів користувач
     * @throws IOException виняток
     */
    private static String ask() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
        System.out.println("Пошук");
        System.out.print(ConsoleColor.PURPLE_BOLD_BRIGHT);
        System.out.print("Введіть, що хочете знайти: ");

        String enterFile = input.readLine();

        return enterFile;
    }
}
