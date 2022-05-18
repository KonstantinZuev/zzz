package lesson4;

/**
*@author Zuev Konstantin
*@version 18.05.2022
*
*Класс DegenerateTriangleException
*Исключение на случай вырожденного треугольника в отрезок или точку
*/

public class DegenerateTriangleException extends Exception{
    public DegenerateTriangleException() {
        super("Вырожденный в отрезок или точку треугольник не имеет площади");
    }
}