package com.company.dao;

import com.company.Interface.ConsoleColor;

import java.io.*;

/**
 * Клас, який реалізує створення, редагування та видалення файлів
 */
public class AuthorMode {

    /**
     * Метод, який визначає вибір користувача (створити, редагувати чи видалити)
     *
     * @throws IOException виняток
     */
    public static void userSelection() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int command = 0;

        while (true) {
            System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
            System.out.println("Режим автора:");
            System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
            System.out.print("1 - Створити файл\n" +
                    "2 - Редагувати файл\n" +
                    "3 - Видалити файл\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
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
                    String dir = directorySelection();

                    //Для додавання індексу файлу
                    if (dir.equals("Data\\Lessons\\")) {
                        dir += (Lesson.getListOfLessons().size() + ".");
                    } else {
                        dir += (GeneralInformation.getListOfGeneralInformation().size() + ".");
                    }

                    System.out.print(ConsoleColor.PURPLE_BOLD_BRIGHT);
                    System.out.print("Введіть назву файлу (без розширення): ");
                    String nameFile = input.readLine();

                    createFile(dir + nameFile);
                    break;
                }
                case 2: {
                    String dir = directorySelection();

                    System.out.print(ConsoleColor.PURPLE_BOLD_BRIGHT);
                    System.out.print("Введіть назву файлу (без розширення): ");
                    String nameFile = input.readLine();

                    editFile(dir + nameFile + ".txt");
                    break;
                }
                case 3: {
                    String dir = directorySelection();

                    System.out.print(ConsoleColor.PURPLE_BOLD_BRIGHT);
                    System.out.print("Введіть назву файлу (без розширення): ");
                    String nameFile = input.readLine();

                    File file = new File(dir + nameFile + ".txt");
                    deleteFile(file);
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
     * Метод, який створює файли
     *
     * @param nameFile ім'я файлу, який потрібно створити
     * @throws FileNotFoundException виняток
     */
    private static void createFile(String nameFile) throws FileNotFoundException {

        File file = new File(nameFile + ".txt");
        try {
            OutputStream a = new FileOutputStream(file);
            a.close();
            System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
            System.out.println("\nФайл успішно створений\n");
        } catch (Exception ex) {
            System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
            System.out.println("\nНе вдалося створити файл\n");
            return;
        }
    }

    /**
     * Метод, який редагує вміст файлу
     *
     * @param nameFile ім'я файлу, який потрібно відредагувати
     * @throws IOException виняток
     */
    private static void editFile(String nameFile) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(nameFile);
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (Exception ex) {
            System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
            System.out.println("\nНе вдалося знайти файл\n");
            return;
        }

        System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
        System.out.println("\nВведіть вміст файлу:");
        String text = input.readLine();

        fileWriter.write(text);
        fileWriter.close();
        System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
        System.out.println("\nФайл успішно відредаговано\n");
    }

    /**
     * Метод, який видаляє файли
     *
     * @param file файл, який потрібно видалити
     */
    private static void deleteFile(File file) {
        if (file.delete()) {
            System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
            System.out.println("\nФайл успішно видалено\n");
        } else {
            System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
            System.out.println("\nНе вдалося видалити файл\n");
        }
    }

    /**
     * Метод, який повертає шлях до файлу, у залежності від вибору користувача
     *
     * @return повертає шлях до файлу, у залежності від вибору користувача
     * @throws IOException виняток
     */
    private static String directorySelection() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int command = 0;

        while (true) {
            System.out.print(ConsoleColor.WHITE_BOLD_BRIGHT);
            System.out.println("До якого типу належить файл?");
            System.out.print(ConsoleColor.BLUE_BOLD_BRIGHT);
            System.out.print("1 - Уроки Java\n" +
                    "2 - Загальна інформація про Java\n" + ConsoleColor.PURPLE_BOLD_BRIGHT +
                    "Команда: ");

            try {
                command = Integer.parseInt(input.readLine());
                System.out.println("");
            } catch (Exception ex) {
                System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
            }

            switch (command) {
                case 1: {
                    System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
                    System.out.println("Список наявних файлів:");
                    System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                    for (File file : Lesson.getListOfLessons()) {
                        System.out.println(file.getName());
                    }
                    System.out.println("");
                    return ("Data\\Lessons\\");
                }
                case 2: {
                    System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
                    System.out.println("Список наявних файлів:");
                    System.out.print(ConsoleColor.GREEN_BOLD_BRIGHT);
                    for (File file : GeneralInformation.getListOfGeneralInformation()) {
                        System.out.println(file.getName());
                    }
                    System.out.println("");
                    return ("Data\\General information about Java\\");
                }
                default: {
                    System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
                    System.out.println("\nПомилка! Не правильно введена команда. Спробуйте ще раз.\n");
                    continue;
                }
            }
        }
    }
}
