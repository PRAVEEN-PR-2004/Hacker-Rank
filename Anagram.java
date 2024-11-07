import java.util.*;

public class Anagram {

    /*
     * Complete the 'stringAnagram' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. STRING_ARRAY dictionary
     * 2. STRING_ARRAY query
     */

    public static List<Integer> stringAnagram(List<String> dictionary, List<String> query) {
        // Preprocess the dictionary to create a map of anagram signatures to counts
        Map<String, Integer> anagramMap = new HashMap<>();

        for (String word : dictionary) {
            String signature = getAnagramSignature(word);
            anagramMap.put(signature, anagramMap.getOrDefault(signature, 0) + 1);
        }

        // Prepare the result list by querying the map
        List<Integer> result = new ArrayList<>();
        for (String q : query) {
            String signature = getAnagramSignature(q);
            result.add(anagramMap.getOrDefault(signature, 0));
        }

        return result;
    }

    // Helper method to compute the anagram signature by sorting characters
    private static String getAnagramSignature(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        return String.valueOf(arr);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of dictionary words
        int dictionaryCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read all dictionary words
        List<String> dictionary = new ArrayList<>();
        for (int i = 0; i < dictionaryCount; i++) {
            dictionary.add(scanner.nextLine());
        }

        // Read the number of query words
        int queryCount = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        // Read all query words
        List<String> query = new ArrayList<>();
        for (int i = 0; i < queryCount; i++) {
            query.add(scanner.nextLine());
        }

        // Compute the anagram counts for each query
        List<Integer> result = stringAnagram(dictionary, query);

        // Print the results, each count on a new line
        for (Integer count : result) {
            System.out.println(count);
        }

        scanner.close();
    }
}
