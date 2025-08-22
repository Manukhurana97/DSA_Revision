// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

public class RandomizedCollection {
    List<Integer> values;
    Map<Integer, Set<Integer>> map;
    Random rand = new Random();

    public RandomizedCollection() {
        values = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }
    
    public boolean insert(int val) {
        boolean result  = !map.containsKey(val);
        map.computeIfAbsent(val, k -> new HashSet<>()).add(values.size());
        values.add(val);
        return result;
    }
    
    public boolean remove(int val) {
        var indices = map.get(val);
        if(indices == null || indices.isEmpty()) return false;

        int index = indices.iterator().next();
        indices.remove(index);

        int lastIndex = values.size()-1;
        int lastValue = values.get(lastIndex);

        if(index < lastIndex) {
            values.set(index, lastValue);
            map.get(lastValue).remove(lastIndex);
            map.get(lastValue).add(index);
        }

        values.remove(lastIndex);

        if(indices.isEmpty()) {
            map.remove(val);
        }

        return true;
        
    }
    
    public int getRandom() {
        return values.get(rand.nextInt(values.size()));
    }
}
