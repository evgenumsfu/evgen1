import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример");
        String str1 = in.nextLine();
        System.out.println(calc(str1));
    }
    public static String calc(String str1) throws IOException {
        String str2 = str1.replaceAll("\\s", "");
        int a = 0;
        int b = 0;
        boolean ar = true;
        String[] x = str2.split("[+*/?\\-]");
        if (x.length > 2) try {
            throw new IOException();
        } finally {}
        if (x.length !=2) try {
            throw new IOException();
        } finally {}
        if (rimArabOff(x[0]) && !rimArabOff(x[1])) try {
            throw new IOException();
        } finally {}
        if (!rimArabOff(x[0]) && rimArabOff(x[1])) try {
            throw new IOException();
        } finally {}
        if (rimArabOff(x[0]) && rimArabOff(x[1])) {     // на выхоте арабские цифры
            a = Integer.parseInt(x[0]);
            b = Integer.parseInt(x[1]);
        } else if (!rimArabOff(x[0]) && !rimArabOff(x[1])) {     // на выхоте римские цифры
            a = convert(x[0]);
            b = convert(x[1]);
            ar = false;}
        if (a < 0) try {
            throw new IOException();
        } finally {}
        if (a > 10) try {
            throw new IOException();
        } finally {}
        if (b < 0) try {
            throw new IOException();
        } finally {}
        if (b > 10) try {
            throw new IOException();
        } finally {}
        int rez = 0;
        if (str1.contains("+")) {
            rez = a + b;
        }
        if (str1.contains("-")) {
            rez = a - b;
        }
        if (str1.contains("*")) {
            rez = a * b;
        }
        if (str1.contains("/")) {
            rez = a / b;
        }
        if ((rez <= 0) && (!ar)) try {
            throw new IOException();
        } finally {}
        if (!ar) return "Результат: " + convert2(rez);  // вывод римских чисел
        return "Результат: " + rez;                     // вывод арабских чисел
    }
    static String[] rim = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI","XII",
            "XIII", "XIV","XV","XVI", "XVII", "XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI",
            "XXVII","XXVIII","XXIX","XXX","XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX",
            "XL","XLI", "XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L","LI","LII","LIII","LIV","LV",
            "LVI","LVII","LVIII","LIX","LX","LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
            "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXVIII","LXXIX","LXXX","LXXXI","LXXXII",
            "LXXXIII", "LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC","XCI","XCII","XCIII","XCIV",
            "XCV","XCVI", "XCVII","XCVIII","XCIX","C"};
    public static boolean rimArabOff(String x) {
        for (String s : rim) {
            if (x.equals(s)) {
                return false;
            }
        }
        return true;
    }
    public static int convert(String x) {
        for (int i=0; i < rim.length; i++) {
            if (x.equals(rim[i])) {
                return i;
            }
        }
        return -1;
    }
    public static String convert2 (int rez) {
        return rim[rez];}
}