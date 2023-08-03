package Gb.Lesson3.HomeWork;


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        try {
            boolean exit = false;
            while (!exit) {
                String text = input(); // 4951551515 m Frolov Viktor Alekseevich 25.03.2023
                checkInputCode(checkInput(text));
                saveToFile(parseText(text));
                if (exitApp() == -1) {
                    exit = true;
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IncorrectFormatException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    //String text = "  4951551515 m Frolov Viktor Alekseevich 25.03.2023";
    public static String input() {
        System.out.println("Для записи в файл, введите следующие данные в любом порядке через пробел: ");
        System.out.println("Фамилия Имя Отчество, дата рождения, номер телефона, пол");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public static int exitApp() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите повторить ввод?   y/n");
        String input = scanner.nextLine();
        if (input == null || input.strip().equals("")) {
            System.out.println("Вы ничего не ввели");
            return 0;
        } else if (input.equals("n")) {
            scanner.close();
            System.out.println("Выход из программы...");
            return -1;
        } else if (input.equals("y")) {
            return 0;
        } else {
            System.out.println("Неверный ввод, программа завершит работу.");
            scanner.close();
            return -1;
        }
    }

    public static int checkInput(String text) {
        if (text == null || text.strip().equals("")) {
            return -1;
        }
        String[] splitArr = text.strip().split("\\s+");
        if (splitArr.length > 6) {
            return -2;
        } else if (splitArr.length < 6) {
            return -3;
        }
        return 1;
    }

    public static void checkInputCode(int code) {
        switch (code) {
            case 1: {
                break;
            }
            case -1: {
                throw new IllegalArgumentException("Вы ничего не ввели, попробуйте снова.");
            }
            case -2: {
                throw new IllegalArgumentException("Вы ввели больше данных, чем требуется.");
            }
            case -3: {
                throw new IllegalArgumentException("Вы ввели меньше данных, чем требуется.");
            }
            default:
                System.out.println("Непредвиденный код ошибки");
                break;
        }
    }

    public static List<String> parseText(String text) {
        Pattern data = Pattern.compile("\\b\\d{2}\\.\\d{2}\\.\\d{4}\\b");
        Pattern fio = Pattern.compile("\\b[a-zA-Z]{2,1000}\\s[a-zA-Z]+\\s[a-zA-Z]+\\b");
        Pattern gender = Pattern.compile("\\b[Ff]\\b|\\b[Mm]\\b");
        Pattern phNumber = Pattern.compile("\\b\\d{10}\\b");
        Matcher dataMatch = data.matcher(text);
        Matcher fioMatch = fio.matcher(text);
        Matcher genderMatch = gender.matcher(text);
        Matcher phNumberMatch = phNumber.matcher(text);
        List<String> array = new ArrayList<>();

        if (Pattern.compile(fio.pattern()).matcher(text).find()) {
            while (fioMatch.find()) {
                array.add(text.substring(fioMatch.start(), fioMatch.end()));
            }
        } else throw new IncorrectFormatException("Неверный формат ФИО. Ожидается --- \"String String String\"");
        if (Pattern.compile(data.pattern()).matcher(text).find()) {
            while (dataMatch.find()) {
                array.add(text.substring(dataMatch.start(), dataMatch.end()));
            }
        } else throw new IncorrectFormatException("Неверный формат даты рождения. Ожидается --- \"dd.mm.yyyy\"");
        if (Pattern.compile(phNumber.pattern()).matcher(text).find()) {
            while (phNumberMatch.find()) {
                array.add(text.substring(phNumberMatch.start(), phNumberMatch.end()));
            }
        } else
            throw new IncorrectFormatException("Неверный формат номера телефона. Ожидается --- \"0123456789\" (10 integer symbols)");
        if (Pattern.compile(gender.pattern()).matcher(text).find()) {
            while (genderMatch.find()) {
                array.add(text.substring(genderMatch.start(), genderMatch.end()));
            }
        } else throw new IncorrectFormatException("Неверный формат пола. Ожидается --- \"[F-f] or [M-m]\"");
        return array; // [fio, data, phNumber, gender]
    }

    public static void saveToFile(List<String> array) throws IOException {
        List<String> splitter = Arrays.asList(array.get(0).strip().split("\\s"));
        String fileName = "C:\\Users\\linem\\Desktop\\Разработчик\\9. Java Exceptions\\JavaExceptions\\src\\main\\java\\Gb\\Lesson3\\HomeWork\\" +splitter.get(0);
        try (FileWriter writer = new FileWriter(fileName, true)) {
            for (String s : array) {
                writer.write(s + " ");
            }
            writer.write("\n");
            writer.flush();
            System.out.println("Запись прошла успешно.");
        } catch (IOException e) {
            throw new SaveFileException("Запись в файл не удалась", e);
        }
    }
}