/**
*Java 2. Home work #4
*
*@author Zuev Konstantin
*@version 21.04.2022
*/


package lesson6.hw5;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        /*
        Реализовать сохранение данных в csv файл;
Реализовать загрузку данных из csv файла. Файл читается целиком.
Структура файла:
Строка заголовок с набором столбцов
Набор строк с целочисленными значениями
Разделитель между столбцами - символ точка с запятой (;)
         */
        AppData appData = new AppData();
        appData.load("hw5.txt");

        System.out.println(Arrays.toString(appData.getHeader()));
        System.out.println(Arrays.deepToString(appData.getData()));

        appData.save("hw5-1.txt");
    }
}