import java.util.TreeMap;

 class Converter {
    TreeMap<Character, Integer> romanKeyMap = new TreeMap<>();
    TreeMap<Integer, String> arabianKeyMap = new TreeMap<>();

    public Converter(){
        romanKeyMap.put('I', 1);
        romanKeyMap.put('V', 5);
        romanKeyMap.put('X', 10);
        romanKeyMap.put('L', 50);
        romanKeyMap.put('C', 100);
        romanKeyMap.put('D', 500);
        romanKeyMap.put('M', 1000);


        arabianKeyMap.put(100, "C");
        arabianKeyMap.put(90, "XC");
        arabianKeyMap.put(50, "L");
        arabianKeyMap.put(40, "XL");
        arabianKeyMap.put(10, "X");
        arabianKeyMap.put(9, "IX");
        arabianKeyMap.put(5, "V");
        arabianKeyMap.put(4, "IV");
        arabianKeyMap.put(1, "I");

    }

    public boolean isRoman (String number){         //  метод принимает строку и сверяет ее с данными ключами метода Converter.
        return romanKeyMap.containsKey(number.charAt(0)); //конвертация строкового значения в тип char, сверка полученного результата с существующими ключами.
    }

    public int romanToArabian(String s)
    {
        int end = s.length()-1; //задаем конечный индекс.

        char[] charArray = s.toCharArray(); //конвертируем строковый массив в символьный.

        int arabian;
        int result = romanKeyMap.get(charArray[end]); // сразу конвертируем последний символ.

        for(int i = end-1; i>=0; i--) //цикл начнет свой ход с предпоследнего значения в массиве.
        {
            arabian=romanKeyMap.get(charArray[i]);

            if(arabian<romanKeyMap.get(charArray[i+1])) //сравнение двух соседнестоящих с конца символов.
            {
                result-=arabian;
            } else {
                result+=arabian;
            }

        }

        return result;
    }

    public String arabianToRoman( int number){ //метод конвертирует арабские числа в римские.
      String romanNumber = "";
      int arabianKey;
      do
        {
          arabianKey = arabianKeyMap.floorKey(number); //floorKey ищет ближейшее нужное значение снизу вверх.
          romanNumber+=arabianKeyMap.get(arabianKey); //берется подходящий ключ из списка и записывается в строку
          number -= arabianKey; //из нашего исходного числа отнимается значение уже записанного ключа.
        } while (number != 0); //цикл работает пока выполняются условия.

      return  romanNumber;
    }








}
