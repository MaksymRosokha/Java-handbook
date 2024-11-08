package com.company.dao;

import com.company.Interface.ConsoleColor;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Клас для читання вмісту файлу
 */
public class ReaderFile {
    /**
     * Метод який реалізує читання з файлу
     *
     * @param file файл вміст якого потрібно прочитати
     */
    public void readFile(File file) {

        try (FileReader fileReader = new FileReader(file, StandardCharsets.UTF_8)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";

            while ((line = bufferedReader.readLine()) != null) {
                System.out.print(ConsoleColor.YELLOW_BOLD_BRIGHT);
                for (char c : line.toCharArray()) {
                    if (c == '~') {
                        System.out.print(ConsoleColor.CYAN_BOLD_BRIGHT);
                        break;
                    }
                }

                System.out.println(line);
            }

            bufferedReader.close();
            fileReader.close();

        } catch (Exception ex) {
            System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
            System.out.println("Відсутня інформація.");
        }

        System.out.println("\n");
    }
}
