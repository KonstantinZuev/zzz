/**
*Java 2. Home work #3
*
*@author Zuev Konstantin
*@version 06.04.2022
*/

package task2;

public abstract class Fruit {

    private float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    float getWeight() {
        return weight;
    }
}