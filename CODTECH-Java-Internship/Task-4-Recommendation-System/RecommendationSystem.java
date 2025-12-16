import java.util.*;

public class RecommendationSystem {

    public static void main(String[] args) {

        // Sample data (items with categories)
        Map<String, List<String>> data = new HashMap<>();

        data.put("Action", Arrays.asList("Avengers", "Batman", "Mission Impossible"));
        data.put("Comedy", Arrays.asList("Mr Bean", "The Mask", "Friends"));
        data.put("Drama", Arrays.asList("Titanic", "Notebook", "Forrest Gump"));
        data.put("Sci-Fi", Arrays.asList("Interstellar", "Inception", "Matrix"));

        Scanner sc = new Scanner(System.in);

        System.out.println("Available Categories:");
        for (String category : data.keySet()) {
            System.out.println("- " + category);
        }

        System.out.print("\nEnter your preferred category: ");
        String userChoice = sc.nextLine();

        System.out.println("\nRecommended Items:");

        if (data.containsKey(userChoice)) {
            for (String item : data.get(userChoice)) {
                System.out.println(item);
            }
        } else {
            System.out.println("No recommendations available for this category.");
        }
    }
}
