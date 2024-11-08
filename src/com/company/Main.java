package com.company;

import com.company.Interface.ConsoleColor;
import com.company.Interface.Menu;
import org.fusesource.jansi.AnsiConsole;

import java.io.*;
import java.net.URISyntaxException;

/**
 * Головний клас програми
 */
public class Main {
    /**
     * Точка входу в програму
     *
     * @param args аргументи що надійшли з командного рядка
     * @throws IOException        виняток
     * @throws URISyntaxException виняток
     */

    public static void main(String[] args) throws IOException, URISyntaxException {
        AnsiConsole.systemInstall();

        System.out.print(ConsoleColor.RED_BOLD_BRIGHT);
        System.out.println("-------------------\n" +
                "---Java довідник---\n" +
                "-------------------");


        //Виклик статичного методу mainMenu() класу Menu
        Menu.mainMenu();
    }
}
