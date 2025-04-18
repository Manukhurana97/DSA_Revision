// https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/

public class FindAllTheKDistanceIndicesInAnArray{

	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> kIndexList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == key) kIndexList.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            for(int j: kIndexList){
                if(Math.abs(i-j) <= k){
                    result.add(i);
                    break;
                }
            }
        }
        
        Collections.sort(result);
        return result;
    }



    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        
        List<Integer> kIndexList = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] == key) kIndexList.add(i);
        }
        
        List<Integer> result = new ArrayList<>();
        int i=0, j=0, count=0;
        while(i<nums.length && j<kIndexList.size()){
            if(Math.abs(i-kIndexList.get(j)) <= k){
                result.add(i);
                i+=1;
            }else if(i < kIndexList.get(j) - k){
                i+=1;
            }else{
                j+=1;
            }
        }
        
        return result;
    }
}