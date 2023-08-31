import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner inputNumber= new Scanner(System.in); // ввод данных с клавиатуры.
    static String inputLine = inputNumber.next(); // заполнение текстовой ячейки данными со сканера.

    public static void main(String[] args) throws IOException {


        arabicNumerals(); //вызов метода с основным кодом вычисления.

    }


    public static int arabicNumerals  () throws IOException {
        Converter converter = new Converter();


        char operation = getOperation(); // используем метод для определения знака действия.


            String[] strings = inputLine.split("\\W"); /*строковое деление через регулярное выражение, поиск любого символа, кроме латиницы,цифр и нижнего
         подчеркивания.*/
            if (strings.length<2 || strings.length>2){  //исключение! Формат математической операции не удовлетворяет заданию-два операнда и 1 оператор.
                throw new IllegalArgumentException("Формат математической операции не удовлетворяет заданию-два целочисленных операнда и 1 оператор.");

         }


        if(converter.isRoman(strings[0])== converter.isRoman(strings[1])) { //проверка на совпадение формата введенных чисел.

            int a;
            int b;

            boolean romanNumber = converter.isRoman(strings[0]); //ввод логической переменной для обнаружения римского числа.


            if(romanNumber){ //если условие true, то идет конвертация римского числа в арабское.


                    a = converter.romanToArabian(strings[0]);
                    b = converter.romanToArabian(strings[1]);

                        if(mathematicalCalculation(a,b,operation)<=0){
                            throw new IOException("Результат вычисления римских чисел должен быть больше нуля!"); //исключение! результат вычисления римских чисел строго >0.
                        }



                    if (a <= 10 && b <= 10) {
                        System.out.println("Результат = " + converter.arabianToRoman(mathematicalCalculation(a, b, operation))); /* вывод полученного после расчета числа, обратно
                 сконвертированного из арабского в римское.*/
                    } else {

                            throw new IOException("Введены числа больше значения 10!"); //исключение! Разрешен ввод чисел не больше числа 10.

                    }

            }else{

                        a = Integer.parseInt(strings[0]); //перевод строкового значения в числовое.
                        b = Integer.parseInt(strings[1]);

                    if(a<=10 && b<=10){
                        System.out.println("Результат = " + mathematicalCalculation(a, b, operation)); //вывод математического расчета из отдельного метода.
                    }else{
                        throw new IOException("Введены числа больше значения 10"); //исключение! Разрешен ввод чисел не больше числа 10.
                        }
                    }
            }

        else
        {
            throw new NumberFormatException("Числа введены в разных форматах.");

        }

        return 0;
    }
    public static char getOperation () throws IOException //метод позволяет определить знак действия в приведенном примере.
    {
        char[] symbol = inputLine.toCharArray(); //переводим строковый массив в символьный.
        char symbolOperation = 0;
        for(int i = 0; i<symbol.length; i++){ // цикл проходит через массив и находит знак действия.

            if(symbol[i]=='+'||symbol[i]=='-'||symbol[i]=='*'||symbol[i]=='/'){
               symbolOperation = symbol[i]; // запоминаем значение ячейки в подготовленную переменную.
            }

            }
        if(symbolOperation!='+'&&symbolOperation!='-'&&symbolOperation!='/'&&symbolOperation!='*'){
                throw new IOException("Неверный формат. Используйте знаки +,-,/,* и только два операнда."); //исключение! Проверка на введение допустимого знака действия.
        }




        return symbolOperation;
    }
    private static int mathematicalCalculation(int a, int b, char op) { //метод позволяет произвести расчет введенных чисел.

        switch (op) {
            case '*':
                return a * b;
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }


}
