import java.util.*;

public class Percentage {

    public static List<String> mostActive(List<String> customers) {
        Map<String, Integer> hs = new HashMap<>();

        // Count occurrences of each customer
        for (String s : customers) {
            hs.put(s, hs.getOrDefault(s, 0) + 1);
        }

        int totalTransactions = customers.size();
        List<String> result = new ArrayList<>();

        // Iterate through the map entries sorted by customer names (lexicographically)
        for (String customer : new TreeSet<>(hs.keySet())) {
            double percentage = ((double) hs.get(customer) / totalTransactions) * 100;

            // Add customers with >= 5% activity
            if (percentage >= 5) {
                result.add(customer);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Sample list of customers
        List<String> customers = Arrays.asList(
                "Omega", "Alpha", "Omega", "Alpha", "Omega",
                "Alpha", "Omega", "Alpha", "Omega", "Alpha",
                "Omega", "Alpha", "Omega", "Alpha", "Omega",
                "Alpha", "Omega", "Alpha", "Omega", "Beta");

        // Call mostActive function
        List<String> activeCustomers = mostActive(customers);

        // Print the result
        System.out.println("Customers with at least 5% of total transactions:");
        for (String customer : activeCustomers) {
            System.out.println(customer);
        }
    }
}
