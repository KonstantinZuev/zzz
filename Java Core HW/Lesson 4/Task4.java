/**
*Java 2. Home work #4
*
*@author Zuev Konstantin
*@version 18.04.2022
*/

package task4;

public class Task4 {

    public static void main(String[] args) {
        String[] words = {"dog", "cat", "pet", "lock", "mock", "lock", "fork", "mock", "golf", "lock"};

        
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        System.out.println(map);
        System.out.println("");

        
        Set<String> uniq = new HashSet<>(Arrays.asList(words));
        System.out.println(uniq);
        System.out.println("");

        
        Phonebook pb = new Phonebook();

        pb.add("Ivanov", "123");
        pb.add("Petrov", "456");
        pb.add("Petrov", "789");

        System.out.println(pb.get("Petrov"));
    }
}