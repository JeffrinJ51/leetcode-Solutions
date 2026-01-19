import java.util.*;
class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            String[] parts = email.split("@");
            String local = parts[0].split("\\+")[0].replace(".", "");
            String domain = parts[1];
            unique.add(local + "@" + domain);
        }
        return unique.size();
    }
}
