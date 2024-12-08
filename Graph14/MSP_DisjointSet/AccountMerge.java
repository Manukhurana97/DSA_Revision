class DisjointSet{
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    
    public int findParent(int i){
        if(i != parent.get(i)){
            parent.set(i, findParent(parent.get(i))); // Path compression
        }
        
        return parent.get(i);
    }
    
    public void union(int u, int v){
        int uParent = findParent(u);
        int vParent = findParent(v);
        
        if(uParent == vParent) return;
        
        if(size.get(uParent) > size.get(vParent)){
            size.set(uParent, size.get(uParent) + size.get(vParent));
            parent.set(vParent, uParent);
        }else{
            size.set(vParent, size.get(uParent) + size.get(vParent));
            parent.set(uParent, vParent);
        }
    }
}

public class AccountMerge {
  public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet set = new DisjointSet(n);

        Map<String, Integer> emailToIndex = new HashMap<>();

        // Map emails to their account index and union accounts with shared emails
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) { // Skip the name
                String email = account.get(j);
                if (emailToIndex.containsKey(email)) {
                    set.union(emailToIndex.get(email), i);
                } else {
                    emailToIndex.put(email, i);
                }
            }
        }

        // Group emails by their root parent
        Map<Integer, TreeSet<String>> indexToEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int parent = set.findParent(entry.getValue());
            
            indexToEmails.computeIfAbsent(parent, k -> new TreeSet<>()).add(email);
        }

        // Build the result list
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeSet<String>> entry : indexToEmails.entrySet()) {
            int index = entry.getKey();
            TreeSet<String> emails = entry.getValue();

            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(index).get(0)); // Add the name
            mergedAccount.addAll(emails); // Add sorted emails
            result.add(mergedAccount);
        }

        return result;
    }
}