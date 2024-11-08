package com.company.Interface;

/**
 * Клас, який дозволяє використовувати кольори в консолі
 */
public class ConsoleColor {

    /**
     * Повертає початковий колір
     */
    public static final String RESET = "\033[0m";


    /**
     * Червоний
     */
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    /**
     * Зелений
     */
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    /**
     * Жовтий
     */
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    /**
     * Синій
     */
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
    /**
     * Фіолетовий
     */
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
    /**
     * Бізий
     */
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    /**
     * Білий
     */
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";
}
