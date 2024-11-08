package com.company.dao;

import java.io.*;

/**
 * Клас довідки
 */
public class Certificate extends ReaderFile {

    /**
     * Шлях до довідки
     */
    private static final String PATH_TO_CERTIFICATE = new File("Data\\Certificate.txt").getAbsolutePath();

    /**
     * Метод, який повертає файл довідки
     *
     * @return файл довідки
     * @throws IOException виняток
     */
    public static File getFile() throws IOException {

        File fileCertificate = new File(PATH_TO_CERTIFICATE);

        return fileCertificate;
    }
}
