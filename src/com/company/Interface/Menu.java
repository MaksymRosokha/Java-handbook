package com.company.Interface;

import com.company.bl.Filter;
import com.company.bl.Search;
import com.company.dao.*;

import java.awt.*;
import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Даний клас реалізує меню
 */
public class Menu {

    /**
     * Даний метод реалізує головне меню користувача
     *
     * @throws IOException        виняток
     * @throws URISyntaxException виняток
     */
    public static void mainMenu() throws IOException, URISyntaxException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int command = 0;

        while (true) {
            System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
            System.out.println("- - - МЕНЮ - - -");
            System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
            System.out.print("1 - Уроки Java\n" +
                    "2 - Загальна інформація про Java\n" +
                    "3 - Завантажити Java\n" +
                    "4 - Пошук\n" +
                    "5 - Фільтри\n" +
                    "6 - Режим автора\n" +
                    "7 - Довідка\n" +
                    "0 - Вихід\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
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
                    //Якщо є файли
                    if (Lesson.showListOfLessons()) {
                        ReaderFile fileReader = new Lesson();
                        fileReader.readFile(Lesson.selectedFile());
                    }

                    backToMenu();
                    continue;
                }
                case 2: {
                    //Якщо є файли
                    if (GeneralInformation.showListOfGeneralInformation()) {
                        ReaderFile fileReader = new GeneralInformation();
                        fileReader.readFile(GeneralInformation.selectedFile());
                    }

                    backToMenu();
                    continue;
                }
                case 3: {
                    Desktop.getDesktop().browse(new URI("https://www.oracle.com/java/technologies/"));
                    System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                    System.out.println("Сайт для завантаження Java відкритий у вашому браузері\n");
                    backToMenu();
                    continue;
                }
                case 4: {
                    /*
                     * Перевірка на те, чи є файли у одному з списків.
                     * Якщо списки пусті то методи повертають false
                     */
                    if (Lesson.makeListOfLessons() | GeneralInformation.makeListOfGeneralInformation()) {
                        Search.find();
                    }

                    backToMenu();
                    continue;
                }
                case 5: {
                    Lesson.makeListOfLessons();
                    Filter.filter();

                    backToMenu();
                    continue;
                }
                case 6: {
                    Lesson.makeListOfLessons();
                    GeneralInformation.makeListOfGeneralInformation();

                    AuthorMode.userSelection();

                    backToMenu();
                    continue;
                }
                case 7: {
                    ReaderFile fileReader = new Certificate();
                    fileReader.readFile(Certificate.getFile());

                    backToMenu();
                    continue;
                }
                case 0: {
                    System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                    System.out.println("Допобачення");
                    System.exit(0);
                }
                default: {
                    System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                    System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
                    continue;
                }
            }
        }
    }

    /**
     * Метод реалізує повернення користувача назад до меню, або вихід з програми
     *
     * @throws IOException виняток
     */
    private static void backToMenu() throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        do {
            int command;
            System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
            System.out.print("1 - Повернутися в меню\n" +
                    "0 - Вихід\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
                    "Команда: ");
            try {
                command = Integer.parseInt(input.readLine());
            } catch (Exception ex) {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
                continue;
            }

            switch (command) {
                case 1: {
                    System.out.println("");
                    break;
                }
                case 0: {
                    System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                    System.out.println("\nДопобачення");
                    System.exit(0);
                }
                default: {
                    System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                    System.out.println("Помилка! Не правильно введена команда. Спробуйте ще раз.\n");
                    continue;
                }
            }

            break;
        } while (true);
    }
}
