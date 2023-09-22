import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите пример");
        int a;
        int b;
        boolean ar;

        String str1 = in.nextLine();
        String[] x = str1.split("[+*/?\\-]");

        if (x.length > 2 ) try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("т.к. формат математической операции не удовлетворяет заданию " +
                    "- два операнда и один оператор (+, -, /, *)");
            return;
        }

        if (x.length !=2 ) try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("т.к. строка не является математической операцией");
            return;
        }

        if (RimArab.rimArabOff(x[0]) && !RimArab.rimArabOff(x[1])) try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("т.к. используются одновременно разные системы счисления");
            return;
        }
        if (!RimArab.rimArabOff(x[0]) && RimArab.rimArabOff(x[1])) try {
            throw new IOException();
        } catch (IOException e) {
            System.out.println("т.к. используются одновременно разные системы счисления");
            return;
        }

        if (RimArab.rimArabOff(x[0]) && RimArab.rimArabOff(x[1])) {     // на выхоте арабские цифры
            a = Integer.parseInt(x[0]);
            b = Integer.parseInt(x[1]);
            ar = true;
        } else if (!RimArab.rimArabOff(x[0]) && !RimArab.rimArabOff(x[1])) {     // на выхоте римские цифры
            a = RimArab.convert(x[0]);
            b = RimArab.convert(x[1]);
            ar = false;
        } else return;

        if (a < 0) try {
            throw new IOException();
        } catch (
                IOException e) {
            System.out.println(" т.к. операнд не удовлетворяет заданию");
            return;
        }
        if (a > 10) try {
            throw new IOException();
        } catch (
                IOException e) {
            System.out.println("т.к. операнд не удовлетворяет заданию");
            return;
        }
        if (b < 0) try {
            throw new IOException();
        } catch (
                IOException e) {
            System.out.println("т.к. операнд не удовлетворяет заданию");
            return;
        }
        if (b > 10) try {
            throw new IOException();
        } catch (
                IOException e) {
            System.out.println("т.к. операнд не удовлетворяет заданию");
            return;
        }
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
        if ((rez <=0) && (!ar)) try {
            throw new IOException();
        } catch (
                IOException e) {
            System.out.println("т.к. в римской системе нет отрицательных чисел");
            return;
        }

        if (ar) System.out.println("Результат: " +rez);
        if (!ar) System.out.println("Результат: " + RimArab.convert2 (rez));
    }
}
class RimArab {
    static String[] rim = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X","XI","XII",
            "XIII", "XIV","XV","XVI", "XVII", "XVII", "XVIII","XIX","XX","XXI","XXII","XXIII","XXIV","XXV","XXVI",
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