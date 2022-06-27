/**
*Java 2. Home work #1
*
*@author Zuev Konstantin
*@version 26.03.2022
*/

public interface Competitor {
    void run(int dist);

    void swim(int dist);

    void jump(int height);

    boolean isOnDistance();

    void info();
}