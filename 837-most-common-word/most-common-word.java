import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        String normalized = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");
        String[] words = normalized.split("\\s+"); 
        Map<String, Integer> countMap = new HashMap<>();
        int maxCount = 0;
        String result = "";
        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) continue;
            int count = countMap.getOrDefault(word, 0) + 1;
            countMap.put(word, count);
            if (count > maxCount) {
                maxCount = count;
                result = word;
            }
        }
        return result;
    }
}
