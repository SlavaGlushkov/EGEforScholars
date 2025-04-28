package Task24;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        // Задача https://education.yandex.ru/ege/task/2d8f6e0c-c37b-4caa-b0b1-6584a5d0261f
        String text = new Scanner(new FileReader("C:\\Users\\ASUS\\Downloads\\24 (5).txt")).nextLine();
        ///Решение с помощью regex
        //?= выражение типа Look forward
        // ?<= выражение типа Look behind
        // .* любые символы в любом количестве, кроме пробела, CR, NL.
        // ? Ленивый захват выражения
        String[] arrRegex = text.split("(?=AHAHA).*?(?<=AHAHA)");
        Arrays.sort(arrRegex,Comparator.comparingInt(String:: length));
        System.out.println("Regex: " + arrRegex[arrRegex.length - 1].length() + " " + arrRegex[arrRegex.length - 1]);
        //Для получения правильного ответа (2371) нужно добавить строку "AHAH" в начало и конец строки и
        //проанализировать строку аналитически.
        /// Метод пробелов
        //Убираем все "AHAHA причем именно так"
        text = text.replace("AHAHA"," ");
        String arrSpaces [] = text.split(" ");
        Arrays.sort(arrSpaces,Comparator.comparingInt(String:: length));
        System.out.println("Regex: " + arrSpaces[arrSpaces.length - 1].length() + " " + arrSpaces[arrSpaces.length - 1]);
        //Для получения правильного ответа (2371) нужно добавить строку "AHAH" в начало и конец строки и
        //проанализировать строку аналитически.
    }
}
