package com.company.dao;

import com.company.Interface.ConsoleColor;

import java.io.*;
import java.util.ArrayList;

/**
 * Клас про загальну інформацію по Java
 */
public class GeneralInformation extends ReaderFile {

    /**
     * Список файлів із загальною інформацією по Java
     */
    private static ArrayList<File> listOfGeneralInformation = new ArrayList<>();

    /**
     * Шлях до файлів з інформацією
     */
    private static final String PATH_TO_GENERAL_INFORMATION_ABOUT_JAVA = new File("Data\\General information about Java").getAbsolutePath();

    /**
     * Повертає список загальної інформації по Java
     *
     * @return повертає список загальної інформації по Java
     */
    public static ArrayList<File> getListOfGeneralInformation() {
        return listOfGeneralInformation;
    }

    /**
     * Виводить на екран список загальної інформації по Java
     *
     * @return повертає true якщо вдалося вивести файли, якщо ні то false
     * @throws IOException виняток
     */
    public static boolean showListOfGeneralInformation() throws IOException {
        System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
        System.out.println("Список:");

        boolean isGeneralInformation = makeListOfGeneralInformation();

        int i = 0;
        if (isGeneralInformation) {
            for (File generalInformation : listOfGeneralInformation) {
                System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                System.out.println(i + " - " + generalInformation.getName().substring(3, (generalInformation.getName().length() - 4)));

                i++;
            }
            return true;//Є файли
        }
        return false;//Файлів немає
    }

    /**
     * Заповнює список файлами
     *
     * @return повертає true якщо вдалося знайти файли, якщо ні то false
     */
    public static boolean makeListOfGeneralInformation() {
        File file = new File(PATH_TO_GENERAL_INFORMATION_ABOUT_JAVA);

        listOfGeneralInformation.clear();

        if (file.listFiles() != null) {
            for (File s : file.listFiles()) {
                if (s.isFile()) {
                    listOfGeneralInformation.add(s);
                }
            }
            return true;
        } else {
            System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
            System.out.println("\nНе вдалося знайти файли по загальній інформації Java\n");
            return false;
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
            System.out.print("Вибір: ");
            try {
                index = Integer.parseInt(input.readLine());
                System.out.println("");
            } catch (Exception ex) {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
                continue;
            }

            if (index >= 0 && index < listOfGeneralInformation.size()) {
                break;
            } else {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("Помилка! Не правильно введене число. Спробуйте ще раз.\n");
                continue;
            }
        } while (true);

        return listOfGeneralInformation.get(index);
    }
}
