import java.io.IOException;
import java.util.Scanner;
public class Main {
    public static void main(String[] args)  {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Введите выражение через пробел:");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws IllegalArgumentException{
        String result = null;
        int resultInt = 0;
        int value1 = 0;
        int value2 = 0;
        boolean isValue1Roman = false;
        boolean isValue2Roman = false;
        String[] value = input.split(" ");
        if (value.length > 3)
            throw new IllegalArgumentException("Калькулятор работает только с 2 числами, Вы ввели больше");
        String[] numToRoman = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"
        };
        switch (value[0]){
            case "I":
                value1 = 1;
                isValue1Roman = true;
                break;
            case "II":
                value1 = 2;
                isValue1Roman = true;
                break;
            case "III":
                value1 = 3;
                isValue1Roman = true;
                break;
            case "IV":
                value1 = 4;
                isValue1Roman = true;
                break;
            case "V":
                value1 = 5;
                isValue1Roman = true;
                break;
            case "VI":
                value1 = 6;
                isValue1Roman = true;
                break;
            case "VII":
                value1 = 7;
                isValue1Roman = true;
                break;
            case "VIII":
                value1 = 8;
                isValue1Roman = true;
                break;
            case "IX":
                value1 = 9;
                isValue1Roman = true;
                break;
            case "X":
                value1 = 10;
                isValue1Roman = true;
                break;
        }
        switch (value[2]){
            case "I":
                value2 = 1;
                isValue2Roman = true;
                break;
            case "II":
                value2 = 2;
                isValue2Roman = true;
                break;
            case "III":
                value2 = 3;
                isValue2Roman = true;
                break;
            case "IV":
                value2 = 4;
                isValue2Roman = true;
                break;
            case "V":
                value2 = 5;
                isValue2Roman = true;
                break;
            case "VI":
                value2 = 6;
                isValue2Roman = true;
                break;
            case "VII":
                value2 = 7;
                isValue2Roman = true;
                break;
            case "VIII":
                value2 = 8;
                isValue2Roman = true;
                break;
            case "IX":
                value2 = 9;
                isValue2Roman = true;
                break;
            case "X":
                value2 = 10;
                isValue2Roman = true;
                break;
        }
        if (isValue1Roman == false && isValue2Roman == false) {
            try {
                value1 = Integer.parseInt(value[0]);
                value2 = Integer.parseInt(value[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Введены не подходящие числа");
            }
        }
        if ((isValue1Roman == false && isValue2Roman == true) || (isValue1Roman == true && isValue2Roman == false)) {
            throw new IllegalArgumentException("Оба числа должны быть либо римскими либо арабскими");
        }
        if (value1 <= 0 || value1 > 10 || value2 <= 0 || value2 > 10) {
            throw new IllegalArgumentException("Вводные числа должны быть от 1 до 10");
        }
        switch (value[1]){
            case "+":
                resultInt = (value1 + value2);
                break;
            case "-":
                resultInt = (value1 - value2);
                break;
            case "/", ":":
                resultInt = (value1 / value2);
                break;
            case "*":
                resultInt = (value1 * value2);
                break;
            default:
                throw new IllegalArgumentException("Неизвестная арифметическая операция");
        }
        if (isValue1Roman == true && isValue2Roman == true){
            if (resultInt < 1){
                throw new IllegalArgumentException("Результат вычисления - 0 или отрицательное число");
            }
            result = numToRoman[resultInt];
        }   else {
            result = String.valueOf(resultInt);
        }
        return result;
    }
}