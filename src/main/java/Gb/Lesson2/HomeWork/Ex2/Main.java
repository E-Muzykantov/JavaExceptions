package Gb.Lesson2.HomeWork.Ex2;

public class Main {
    public static void main(String[] args) {
        try {
            int[] intArray = {1,2,3,4,5,6,7,8,9,10}; //добавил массив потому что в 9 строке
                                                    // было обращение к несуществующему массиву
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }

    }
}
