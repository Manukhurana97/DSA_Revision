// https://leetcode.com/problems/partition-labels/

public class PartitionLabels{

	public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i=0;
        for(var ch: s.toCharArray()){
            map.put(ch, i);
            i++;
        }

        List<Integer> result = new ArrayList<>();
        int size = 0, end = 0;
        for(i=0;i<s.length(); i++){
            size++;
            end = Math.max(end, map.get(s.charAt(i))); // get to the last position of the group

            if(i==end){ // once reached the last position of element of a group 
                result.add(size); // add the size of the result
                size = 0; // start the size / len again
            }
        }

        return result;
    }
}