import java.util.*;
class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        int[] sortedIndices = Arrays.copyOf(indices, n);
        Arrays.sort(sortedIndices);
        List<Replacement> reps = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reps.add(new Replacement(indices[i], sources[i], targets[i]));
        }
        reps.sort(Comparator.comparingInt(r -> r.index));
        StringBuilder sb = new StringBuilder();
        int i = 0; 
        while (i < s.length()) {
            boolean replaced = false;
            for (Replacement rep : reps) {
                if (rep.index == i && s.startsWith(rep.source, i)) {
                    sb.append(rep.target);
                    i += rep.source.length();
                    replaced = true;
                    break; 
                }
            }

            if (!replaced) {
                sb.append(s.charAt(i));
                i++;
            }
        }

        return sb.toString();
    }

    static class Replacement {
        int index;
        String source;
        String target;
        public Replacement(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
}
