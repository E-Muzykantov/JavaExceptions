package Gb.Lesson2.HomeWork.Ex1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    try {
        enter();
    } catch (InputMismatchException e){
        System.out.println("Не верный формат ввода. Ожидается Float --- пожалуйста повторите");
        enter();
    }
    }
    public static float enter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        float number = scanner.nextFloat();
        scanner.close();
        return number;
    }
}
