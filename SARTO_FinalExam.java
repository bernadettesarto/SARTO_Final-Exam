import java.util.Stack;

public class SARTO_FinalExam {

    // Define a Creature class to hold the name and power level

    static class Creature {
        String name;
        int power_Level; 
        
        // Changed variable name to follow Java naming conventions

        Creature(String name, int power_Level) {
            this.name = name.trim(); 
            
            // Trim spaces from name

            this.power_Level = power_Level;
        }
    }

    public static void main(String[] args) {

        // Initialize an array of creatures with their power levels

        Creature[] creatures = {
            new Creature("Dragon", 95),
            new Creature("Griffin", 88),
            new Creature("Unicorn", 78),
            new Creature("Phoenix", 92),
            new Creature("Centaur", 85)
        };

        
        bubbleSortDescending(creatures);// Sort using Bubble Sort in descending order
        System.out.println("*** Bubble Sort: Descending Order by Power Level ***");
        printCreatures(creatures);
        System.out.println();

       
        selectionSortAscending(creatures); // Sort using Selection Sort in ascending order
        System.out.println("*** Selection Sort: Ascending Order by Power Level ***");
        printCreatures(creatures);
        System.out.println();

        
        Stack<Creature> creatureStack = new Stack<>();// Use a Stack to store creatures and display them in descending order
        for (Creature creature : creatures) {
            creatureStack.push(creature);
        }
        System.out.println("*** Stack Implementation: Popping Creatures ***");
        while (!creatureStack.isEmpty()) {
            Creature creature = creatureStack.pop();
            System.out.println(creature.name + " - " + creature.power_Level);
        }
    }

    
    public static void bubbleSortDescending(Creature[] creatures) {// Bubble Sort implementation to sort creatures by power level in descending order
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                // Swap creatures if they are in the wrong order

                if (creatures[j].power_Level < creatures[j + 1].power_Level) {
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    
    public static void selectionSortAscending(Creature[] creatures) {// Selection Sort implementation to sort creatures by power level in ascending order
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].power_Level < creatures[minIndex].power_Level) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element

            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    
    public static void printCreatures(Creature[] creatures) {// Method to display the creatures and their power levels
        for (Creature creature : creatures) {
            System.out.println(creature.name + " - " + creature.power_Level);
        }
    }
}