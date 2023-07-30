package Gb.Lesson2.HomeWork.Ex3;

public class Main {
    public static void main(String[] args) {
        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        }
        catch (NullPointerException ex) {
            System.out.println("Указатель не может указывать на null!");
        }catch (ArithmeticException ex){
            System.out.println("Нельзя делить на 0"); //Добавил исключение деления на 0
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера!");
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так..."); //Переместил вниз (Родитель Exception)
        }
    }
    public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
    }
}

