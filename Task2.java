import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
//1. Создайте функцию, которая повторяет каждый символ в строке n раз

    public static String repeat(String word, int n){
        String newWord = " ";
        for (int i = 0; i< word.length() ; i++){
            for (int j = 0; j<n; j++){
                newWord+= word.charAt(i);
            }
        }
        return newWord;
    }

//2. Создайте функцию, которая принимает массив и возвращает разницу между
//самыми большими и самыми маленькими числами.

    public static int differenceMaxMin(int [] mass){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : mass) {
            min = Math.min(min, value);
            max = Math.max(max, value);
        }
        return max - min;
    }

//3. Создайте функцию, которая принимает массив в качестве аргумента и возвращает
//true или false в зависимости от того, является ли среднее значение всех элементов
//массива целым числом или нет.

    public static boolean isAvgWhole(int mass[]){
        double sum=0;

        for (int value : mass) {
            sum += value;
        }
        if ((sum%mass.length)%100<1)
            return true;
        else
            return false;

    }

//4. Создайте метод, который берет массив целых чисел и возвращает массив, в
//котором каждое целое число является суммой самого себя + всех предыдущих
//чисел в массиве.

    public static int[] cumulativeSum( int [] mass){

        for (int i = 1; i < mass.length; i++){
            mass[i] = mass[i] + mass[i-1];
        }
        return mass;
    }

//5. Создайте функцию, которая возвращает число десятичных знаков, которое имеет
//число (заданное в виде строки). Любые нули после десятичной точки
//отсчитываются в сторону количества десятичных знаков.

    public static int cumulativeSum2(String number){
        if (number.indexOf('.')!=0){
            return number.length()-number.indexOf('.')-1;
        }
        else
            return 0;
    }

//6. Создайте функцию, которая при заданном числе возвращает соответствующее
//число Фибоначчи.

    public static int Fibonacci (int n){
        switch (n) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return Fibonacci(n - 2) + Fibonacci(n - 1);
        }
    }

//7. Почтовые индексы состоят из 5 последовательных цифр. Учитывая строку,
//напишите функцию, чтобы определить, является ли вход действительным
//почтовым индексом. Действительный почтовый индекс выглядит следующим
//образом:
//– Должно содержать только цифры (не допускается использование нецифровых цифр).
//– Не должно содержать никаких пробелов.
//– Длина не должна превышать 5 цифр.

    public static boolean isValid(String index){
        int buf = 0;
        for (int i = 0; i < index.length(); i++) {
            if (!Character.isDigit(index.charAt(i)))
                buf++;
            else if (index.charAt(i) == ' ')
                buf++;
            else if (index.length() != 5)
                buf++;
        }
        return buf == 0;
    }

//8. Пара строк образует странную пару, если оба из следующих условий истинны:
//– Первая буква 1-й строки = последняя буква 2-й строки.
//– Последняя буква 1-й строки = первая буква 2-й строки.
//– Создайте функцию, которая возвращает true, если пара строк представляет собой
//странную пару, и false в противном случае.

    public static boolean isStrangePair (String word1, String word2){
        return word1.charAt(0) == word2.charAt(word2.length() - 1) &&
                word2.charAt(0) == word1.charAt(word1.length() - 1);
    }

//9. Создайте две функции: isPrefix(word, prefix-) и isSuffix (word, -suffix).
//– isPrefix должен возвращать true, если он начинается с префиксного аргумента.
//– isSuffix должен возвращать true, если он заканчивается аргументом суффикса.
//– В противном случае верните false.

    public static boolean isPrefix(String word, String pref){
        pref =  pref.substring(0,  pref.length()-1);
        return word.startsWith(pref);
    }

    public static boolean isSuffix(String word, String suf){
        //suf = suf.substring(1);
        return word.endsWith(suf);
    }

//10. Создайте функцию, которая принимает число (шаг) в качестве аргумента и
//возвращает количество полей на этом шаге последовательности.
//Шаг 0: начните с 0
//Шаг 1: Добавьте 3
//Шаг 2: Вычтите 1
//Повторите Шаги 1 И 2 ...

    public static int boxSeq(int shag){
        if (shag == 0) return 0;
        int count = 0;
        for (int i = 0; i < shag; i++) {
            if (i % 2 != 0) count--;
            else count += 3;
        }
        return count;
    }

    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n)
        {
            case (1):
                String word = in.next();
                int num = in.nextInt();
                String out1 = repeat(word, num);
                System.out.println(out1);
                break;
            case (2):
                int [] mas = new int [10];
                for (int i = 0; i < 10; i++)
                     mas[i] = in.nextInt();
                double out2 = differenceMaxMin(mas);
                System.out.println(out2);
                break;
            case (3):
                int [] mas2 = new int [10];
                for (int i = 0; i < 10; i++)
                    mas2[i] = in.nextInt();
                boolean out3 = isAvgWhole(mas2);
                System.out.println(out3);
                break;
            case (4):
                int [] mas3 = new int [10];
                for (int i = 0; i < 10; i++)
                    mas3[i] = in.nextInt();
                int [] out4 = new int[10];
                out4 = cumulativeSum(mas3);
                for (int i = 0; i < 10; i++)
                    System.out.println(out4[i]);
                break;
            case (5):
                String number = in.next();
                int out5 = cumulativeSum2(number);
                System.out.println(out5);
                break;
            case (6):
                int numb = in.nextInt();
                int out6 = Fibonacci(numb);
                System.out.println(out6);
                break;
            case (7):
                String index = in.next();
                boolean out7 = isValid(index);
                System.out.println(out7);
                break;
            case (8):
                String word1 = in.next();
                String word2 = in.next();
                boolean out8 = isStrangePair(word1, word2);
                System.out.println(out8);
                break;
            case (9):
                String WORD = in.next();
                String pref = in.next();
                String suf = in.next();
                boolean out91 = isPrefix(WORD, pref);
                boolean out92 = isSuffix(WORD, suf);
                System.out.printf ("Perfix: %s, Suffix: %s", out91, out92);
                break;
            case (10):
                int shag = in.nextInt();
                int out10 = boxSeq(shag);
                System.out.println(out10);
                break;
        }

    }
}