import java.util.Scanner;
import java.io.IOException;

public class Task1 {
/*1. В Java есть единственный оператор, способный обеспечить остаток от операции деления.
Два числа передаются в качестве параметров. Первый параметр,
разделенный на второй параметр, будет иметь остаток, возможно, ноль. Верните это значение.*/

    public static int remainder (int a, int b)
    {
        return a % b ;
    }

/*2.Напишите функцию, которая принимает основание и высоту треугольника и
возвращает его площадь.*/

    public static double triArea (int a, int h)
    {
        return 0.5*a*h ;
    }

/*3. В этой задаче фермер просит вас сказать ему, сколько ног можно сосчитать среди всех его животных. Фермер разводит три вида:
chickens = 2 legs
cows = 4 legs
pigs = 4 legs
Фермер подсчитал своих животных, и он дает вам промежуточный итог для каждого вида.
Вы должны реализовать функцию, которая возвращает общее количество ног всех
животных.*/

    public static int animal(int chickens, int cows, int pigs)
    {
        return chickens*2 + cows* 4 + pigs*4 ;
    }

/*4 Создайте функцию, которая принимает три аргумента (prob, prize, pay) и
возвращает true, если prob * prize > pay; в противном случае возвращает false.
Чтобы проиллюстрировать это: profitableGamble (0,2, 50, 9) должен выдать значение true,
поскольку 1 (0,2 * 50 - 9), а 1> 0.*/

    public static boolean profitableGamble ( double prob, double prize, double pay)
    {
        return prob * prize > pay;
    }

/*5 Напишите функцию, которая принимает 3 числа и возвращает, что нужно сделать с
a и b: они должны быть сложены, вычитаны, умножены или разделены, чтобы
получить N. Если ни одна из операций не может дать N, верните "none".
3 числа – это N, a и b.*/

    public static String operation(int N, int a, int b)
    {
        if (a+b == N)
            return "added";
        else if (a-b == N)
            return "subtracted";
        else if (a*b == N)
            return "multiply";
        else if (a/b == N)
            return "davide";
        else return "none";
    }

// 6 Создайте функцию, которая возвращает значение ASCII переданного символа.

    public static int ctoa(char a)
    {
        return (int) a;
    }

/*7 Напишите функцию, которая берет последнее число из последовательного списка чисел
и возвращает сумму всех чисел до него и включая его.*/

    public static int addUpTo(int n)
    {
        int[] mass = new int[n];
        int sum = 0;
        for(int i = 0; n > i; i++){
            mass[i] = i+1;
            sum = sum + mass[i];
        }
        return sum;
    }

/*8 Создайте функцию, которая находит максимальное значение третьего ребра
треугольника, где длины сторон являются целыми числами.*/

    public static int nextEdge(int a, int b)
    {
        return a + b -1;
    }

//9 Создайте функцию, которая принимает массив чисел и возвращает сумму его кубов.

    public static int sumOfCubes(int [] mass)
    {
        int sum = 0;
        for (int value : mass) {
            sum += Math.pow(value, 3);
        }
        return sum;
    }

/*10 Создайте функцию, которая будет для данного a, b, c выполнять следующие действия:
– Добавьте A к себе B раз.
– Проверьте, делится ли результат на C.*/

    public static boolean abcmath(int a, int b, int c)
    {
        for (int i = 0; i<b ; i++){
            a+=a;
        }
        return (a % c == 0);
    }

    public static void main (String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n)
        {
            case (1):
                int a = in.nextInt();
                int b = in.nextInt();
                int out1 = remainder(a, b);
                System.out.println(out1);
                break;
            case (2):
                int A = in.nextInt();
                int h = in.nextInt();
                double out2 = remainder(A, h);
                System.out.println(out2);
                break;
            case (3):
                int chikens = in.nextInt();
                int cows = in.nextInt();
                int pigs = in.nextInt();
                int out3 = animal(chikens, cows, pigs);
                System.out.println(out3);
                break;
            case (4):
                double prob = 0.2, price = 50, pay = 9;
                boolean out4 = profitableGamble(prob, price, pay);
                System.out.println(out4);
                break;
            case (5):
                int a1 = in.nextInt();
                int b1 = in.nextInt();
                int N = in.nextInt();
                String out5 = operation(N, a1, b1);
                System.out.println(out5);
                break;
            case (6):
                char a2 = (char) System.in.read();
                int out6 = ctoa(a2);
                System.out.println(out6);
                break;
            case (7):
                int Num = in.nextInt();
                int out7 = addUpTo(Num);
                System.out.println(out7);
                break;
            case (8):
                int a3 = in.nextInt();
                int b3 = in.nextInt();
                int out8 = nextEdge(a3, b3);
                System.out.println(out8);
                break;
            case (9):
                int [] mas = new int[10];
                for (int j = 0; j < 10; j++)
                    mas[j] = in.nextInt();
                int out9 = sumOfCubes(mas);
                System.out.println(out9);
                break;
            case (10):
                int A1 = in.nextInt();
                int B1 = in.nextInt();
                int C1 = in.nextInt();
                boolean out10 = abcmath(A1, B1, C1);
                System.out.println(out10);
                break;
        }

    }
}
