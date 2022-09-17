/**
*Java 2. Home work #1
*
*@author Zuev Konstantin
*@version 26.03.2022
*/

public class Main {

    public static void main(String[] args) {
        Course c = new Course(new Cross(80), new Water(3), new Wall(5)); // Создаем полосу препятствий
        Team team = new Team("Heroes", new Human("Johny"), new Cat("Murzik"), new Dog("Izzy")); // Создаем команду
         c.doIt(team); // Просим команду пройти полосу

            System.out.println("\nWinners:");
            team.passedTheDistance();

            System.out.println("\nResult:");// Показываем результаты
            team.showResults();
        }
    }