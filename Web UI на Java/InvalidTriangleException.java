package lesson4;
import java.util.*;

/**
*@author Zuev Konstantin
*@version 18.05.2022
*
*Класс InvalidTriangleException
*Исключение на случай невозможности треугольника херона по трем сторонам
*/

public class InvalidTriangleException extends Exception{
    public InvalidTriangleException() {
        super("Треугольник не существует");
    }
}