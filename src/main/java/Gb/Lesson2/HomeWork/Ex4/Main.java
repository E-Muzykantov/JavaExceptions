package Gb.Lesson2.HomeWork.Ex4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            enter();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public static void enter() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово: ");
        String str = scanner.nextLine();
        if (str == null || str == "") {
            throw new IllegalArgumentException("Пустые строки вводить нельзя!");
        } else {
            System.out.println("Введенное слово --- " + str);
        }
        scanner.close();
    }
}

