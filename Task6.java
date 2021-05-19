import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Task6 {

    /*1. Число Белла - это количество способов, которыми массив из n элементов может
    быть разбит на непустые подмножества. Создайте функцию, которая принимает
    число n и возвращает соответствующее число Белла.*/

    public static int bell(int num) {
        int[][] mass = new int[num + 1][num + 1];
        int sum = 0;
        mass[0][0] = 1;
        mass[num][num] = 1;
        for (int n = 1; n <= num; n++) {
            for (int i = 1; i < num; i++) {
                mass[n][i] = mass[n - 1][i - 1] + i * mass[n - 1][i];
            }
        }
        for (int i = 0; i <= num; i++) sum += mass[num][i];
        return sum;
    }

    /* 2. В «поросячей латыни» (свинский латинский) есть два очень простых правила:
            – Если слово начинается с согласного, переместите первую букву (буквы) слова до
    гласного до конца слова и добавьте «ay» в конец.*/

    public static String translateWord(String word){
        if (word.matches("[aeiouy]")) {
            word += "yay";
        }
        else {
            String newWord = word.split("[aeiouy]")[0];
            word = word.replaceFirst(newWord,"")+newWord+"ay";
        }
        return word;
    }

    public static String translateSentence(String word){
        String vow = "aeiouyAEIOUY";
        String[] newword = word.substring(0, word.length()-1).split(" ");
        word = "";
        for (String s : newword) {
            for (int j = 0; j < vow.length(); j++) {
                if (vow.indexOf(s.charAt(j)) != -1) {
                    word += s + "yay ";
                    break;
                } else {
                    String newWord = s.split("[aeiyouAEIYOU]")[0];
                    word += s.replaceFirst(newWord, "") + newWord + "ay ";
                    break;
                }
            }
        }
        return word + ".";
    }

    /* 3. Учитывая параметры RGB (A) CSS, определите, является ли формат принимаемых
    значений допустимым или нет. Создайте функцию, которая принимает строку
            (например, " rgb(0, 0, 0)") и возвращает true, если ее формат правильный, в
    противном случае возвращает false.*/

    public static boolean validColor (String rgb){
        int num = rgb.indexOf('(');
        if (rgb.contains(" "))
            return false;
        String [] newrgb = rgb.substring(rgb.indexOf('(')+1,rgb.indexOf(')')).split(",");
        double [] n = new double [num];
        for (int i = 0 ; i < num; i++) {
            n[i] = Double.parseDouble(newrgb[i]);
        }
        for (int i = 0 ; i < num; i++) {
            return n[i] >= 0 && n[i] <= 255 && num == newrgb.length;
        }
        return false;
    }

    /* 4. Создайте функцию, которая принимает URL (строку), удаляет дублирующиеся
    параметры запроса и параметры, указанные во втором аргументе (который будет
    необязательным массивом).*/

    public static String stripUrlParams (String url, String ... paramsToStrip) {
        String str = "";
        if (!url.contains("?"))
            return url;
        else {
            str = url.substring(url.indexOf("?") + 1);
            url = url.substring(0, url.indexOf("?") + 1);
        }
        char[] params = str.toCharArray();

        StringBuilder print = new StringBuilder();
        for (char param : params) {
            if (Character.isLetter(param))
                if (!(print.toString().contains(String.valueOf(param)))) {
                    if (paramsToStrip.length > 0) {
                        for (String arg : paramsToStrip) {
                            if (!(arg.contains(String.valueOf(param))))
                                print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");
                        }
                    }
                    else
                        print.append(str.substring(str.lastIndexOf(param), str.lastIndexOf(param) + 3)).append("&");
                }
        }
        return url + print.substring(0, print.length()-1);
    }

    /* 5. Напишите функцию, которая извлекает три самых длинных слова из заголовка
    газеты и преобразует их в хэштеги. Если несколько слов одинаковой длины,
    найдите слово, которое встречается первым.*/

    public static String getHashTags(String str){
        String[] hashtags = new String[]{" ", " ", " "};
        StringBuilder buf = new StringBuilder();
        for (int i = 0 ; i<str.length();i++){
            if (str.charAt(i) != ' ')
                buf.append(str.charAt(i));
            else if (buf.length() > hashtags[0].length()) {
                hashtags[0] = buf.toString();
                buf = new StringBuilder();
            }
            else if (buf.length() > hashtags[1].length()) {
                hashtags[1] = buf.toString();
                buf = new StringBuilder();
            }
            else if (buf.length() > hashtags[2].length()) {
                hashtags[2] = buf.toString();
                buf = new StringBuilder();
            }
            else
                buf = new StringBuilder();
        }
        for (int i = 0; i < hashtags.length; i++){
            hashtags[i] = "#" + hashtags[i].toLowerCase();
        }
        return Arrays.toString(hashtags);
    }

    /* 6.Создайте функцию, которая принимает число n и возвращает n-е число в
    последовательности Улама.*/

    public static int ulma (int n){
        int[] mas = new int[n];
        mas[0]=1;
        mas[1]=2;
        int len=2, next=3;
        while (next<Integer.MAX_VALUE && len<n){
            int count =0;
            for (int i=0;i<len;i++){
                for (int j=len-1; j>i; j--){
                    if (mas[i]+mas[j]==next && mas[i]!=mas[j])
                        count++;
                    else if (count > 1)
                        break;
                }
                if (count > 1)
                    break;
            }
            if (count == 1) {
                mas[len]=next;
                len++;
            }
            next++;
        }
        return mas[n-1];
    }
    /* 7. Напишите функцию, которая возвращает самую длинную неповторяющуюся
    подстроку для строкового ввода.*/

    public static String longestNonrepeatingSubstring(String str){
        String podstr = "";
        char [] mass = str.toCharArray();
        StringBuilder strBuilder = new StringBuilder();
        for (char c : mass) {
            if (!strBuilder.toString().contains(String.valueOf(c)))
                strBuilder.append(c);
            else {
                if (strBuilder.length() > podstr.length())
                    podstr = strBuilder.toString();
                strBuilder = new StringBuilder("" + c);
            }
        }
        str = strBuilder.toString();
        if (str.length()>podstr.length())
            podstr=str;
        return podstr;
    }

    /* 8. Создайте функцию, которая принимает арабское число и преобразует его в римское
    число. */
    public static String convertToRoman (int num){
        StringBuilder roman = new StringBuilder();
        if (num < 1 || num > 3999)
            return "Введите число поменьше. ";
        while (num >= 1000) {
            roman.append("M");
            num -= 1000;        }
        while (num >= 900) {
            roman.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            roman.append("D");
            num -= 500;
        }
        while (num >= 400) {
            roman.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            roman.append("C");
            num -= 100;
        }
        while (num >= 90) {
            roman.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            roman.append("L");
            num -= 50;
        }
        while (num >= 40) {
            roman.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            roman.append("X");
            num -= 10;
        }
        while (num >= 9) {
            roman.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            roman.append("V");
            num -= 5;
        }
        while (num >= 4) {
            roman.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            roman.append("I");
            num -= 1;
        }
        return roman.toString();
    }

    /* 9. Создайте функцию, которая принимает строку и возвращает true или false в
    зависимости от того, является ли формула правильной или нет. */

    public static boolean formula(String formula){
        String[] mass = formula.split(" ");
        int ans = 0;
        int expectedResult = 0;
        if (!Character.isDigit(mass[0].charAt(0))) return false;
        else ans = Integer.parseInt(mass[0]);
        int i = 1;
        while (!mass[i].equals("=")) {
            if (mass[i].equals("+")){
                ans += Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("-")){
                ans -= Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("*")){
                ans *= Integer.parseInt(mass[i + 1]);
            }
            if (mass[i].equals("/")){
                ans /= Integer.parseInt(mass[i + 1]);
            }
            i += 2;
        }
        i = formula.indexOf('=');
        String check = formula.substring(i + 1, formula.length());
        if (check.contains("=")) return false;
        else expectedResult = Integer.parseInt(mass[mass.length - 1]);
        return ans == expectedResult;
    }

    /* 10. Число может не быть палиндромом, но его потомком может быть. Прямой потомок
    числа создается путем суммирования каждой пары соседних цифр, чтобы создать
    цифры следующего числа.*/

    public static boolean palindromedescendant(int num){
        boolean bul = false;
        StringBuffer nuum =new StringBuffer(num);
        StringBuffer nuuum =new StringBuffer(num);
        if (nuum.length()%2!=0)
            return false;
        else{
            while (!bul){
                if(nuum != nuum.reverse()){
                    for(int i=0; i<nuum.length();i+=2){
                        int a = Integer.parseInt(String.valueOf(nuum.charAt(i)));
                        int b = Integer.parseInt(String.valueOf(nuum.charAt(i+1)));
                        nuuum.append(a+b);
                    }
                }
                else
                    bul = true;
            }
        }
        return bul;
    }

    public static void main (String[] args) throws IOException, NoSuchAlgorithmException {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        switch (n)
        {
            case (1):
                int NUM = in.nextInt();
                int out1 = bell(NUM);
                System.out.println(out1);
                break;
            case (2):
                String word = in.nextLine();
                String out21 = translateWord(word);
                String out22 = translateSentence(word);
                System.out.println(out21 + " " + out22);
                break;
            case (3):
                String str = in.nextLine();
                boolean out3 = validColor(str);
                System.out.println(out3);
                break;
            case (4):
                String STR1 = in.nextLine();
                String STR2 = in.nextLine();
                String out4 = stripUrlParams(STR1, STR2);
                System.out.println(out4);
                break;
            case (5):
                String STR = in.nextLine();
                String out5 = getHashTags(STR);
                System.out.println(out5);
                break;
            case (6):
                int Num = in.nextInt();
                int out6 = ulma(Num);
                System.out.println(out6);
                break;
            case (7):
                String str4 = in.nextLine();
                String out71 = longestNonrepeatingSubstring(str4);
                System.out.println(out71);
                break;
            case (8):
                int num = in.nextInt();
                String out8 = convertToRoman(num);
                System.out.println(out8);
                break;
            case (9):
                String form = in.nextLine();
                boolean out9 = formula(form);
                System.out.println(out9);
                break;
            case (10):
                int x = in.nextInt();
                boolean out10 = palindromedescendant(x);
                System.out.println(out10);
                break;
        }

    }

}
