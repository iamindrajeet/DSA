package miscellaneous;

import java.util.ArrayList;
import java.util.Scanner;

public class problemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get input for legs of three animals and total legs
        String[] input = scanner.nextLine().split(" ");
        String x = input[0];
        String y = input[1];
        String z = input[2];
        int totalLegs = Integer.parseInt(input[3]);

        // Find all possible combinations of animals
        ArrayList<String> animalCombinations = findPossibleAnimals(x, y, z, totalLegs);

        // Print the possible combinations or "impossible" if no solutions exist
        if (!animalCombinations.isEmpty()) {
            for (String combination : animalCombinations) {
                System.out.println(combination);
            }
        } else {
            System.out.println("impossible");
        }
        scanner.close();
    }

    public static ArrayList<String> findPossibleAnimals(String x, String y, String z, int totalLegs) {
        ArrayList<String> possibleCombinations = new ArrayList<>();

        // Iterate through all possible combinations of the number of each animal
        for (int numX = 0; numX <= totalLegs; numX++) {
            for (int numY = 0; numY <= totalLegs; numY++) {
                for (int numZ = 0; numZ <= totalLegs; numZ++) {
                    // Check if the total number of legs matches the given totalLegs
                    if (Integer.parseInt(x) * numX + Integer.parseInt(y) * numY + Integer.parseInt(z) * numZ == totalLegs) {
                        // Append the valid combination to the possibleCombinations list
                        possibleCombinations.add(numX + " " + numY + " " + numZ);
                    }
                }
            }
        }

        return possibleCombinations;
    }
}