package Testovoe2;

import java.util.Scanner;

public class Alternativ {

        public static String result(String st) throws Exception {
            String st1 = st.replaceAll("\"", "");
            String[] data = st1.split(" ");
            int maxStringLength = 10;
//исключение, количество символов в строке не более 10
            for (int i = 0; i < data.length ;i++ )
                if (data.length > maxStringLength){
                    throw new Exception("В строке не должно быть более 10 символов");
                }
//исключение, что первый аргумент - строка
            if (!(st.charAt(0) == '\"')) {
                throw new Exception("Первым аргументом должна быть строка в двойных кавычках");
            }
            char deistvie;
            if (st1.contains(" + ")) {
                st1.split(" + ");
                deistvie = '+';
            } else if (st1.contains("-")) {
                st1.concat("-");
                deistvie = '-';
            } else if (st1.contains(" * ")) {
                st1.concat(" * ");
                deistvie = '*';
            } else if (st1.contains(" / ")) {
                st1.concat(" / ");
                deistvie = '/';
//исключение, если неверный знак действия
            } else {
                throw new Exception("Неверный знак действия");
            }
//исключение, что делить и умножать можно только на число
            if (deistvie == '*' || deistvie == '/') {
                if (st.charAt(st.length() - 1) == '\"')
                    throw new Exception("Строчку можно делить или умножать только на число");
            }
//Действия в зависимости от знака
            if (deistvie == '+') {
                System.out.println(data[0] + data[2]);
            } else if (deistvie == '-') {
                String lastElement = data[data.length - 1];
                String minus = st1.replace(data[data.length - 1], "");
                System.out.println(minus.replace(" - ", ""));
            } else if (deistvie == '*') {
                int number = Integer.parseInt(data[2]);
                if (number < 1 || number > 10) {
                    throw new Exception("Можно использовать числа от 1 до 10 включительно");
                }
                String umnozhenie = data[0].repeat(Integer.parseInt(data[2]));
                if (umnozhenie.length() > 40) {
                    System.out.println(umnozhenie.substring(0, 39) + "...");
                } else if (umnozhenie.length() < 40) {
                    System.out.println(umnozhenie);
                }
            }
            else if (deistvie == '/'){
                System.out.println("Последний символ " + Integer.parseInt(data[2]));

                String delenie = data[0].substring(0, (data[0].length()/Integer.parseInt(data[2])));
                System.out.println(delenie);
            }
            return st1;
        }
        public static void main (String[]args) throws Exception {
            Scanner scan = new Scanner(System.in);
            String text = new String(scan.nextLine());
            result(text);
        }
    }