import java.util.*;

public class NextGreaterElement{
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        
        for(int i=0; i<nums1.length; i++){
            int j = 0;
            while(j < nums2.length && nums1[i] != nums2[j]) j+=1; // find the index in n2
           
            while(j < nums2.length && nums2[j] <= nums1[i]) j+=1; // check if next greater element exists
            
            result[i] = (j == nums2.length) ? -1:nums2[j]; 
        }

        return result;
    }




    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); // map to store next greater elemt
        Stack<Integer> stack  = new Stack<>();

        for(int j: nums2){
            while(!stack.isEmpty() && stack.peek()<j){
                map.put(stack.pop(), j);
            }
            stack.push(j);
        }

        while(!stack.isEmpty()) map.put(stack.pop(), -1);
        

        int[] result = new int[nums1.length];
        for(int i=0;i<nums1.length;i++) result[i] = map.get(nums1[i]);
        

        return result;
    }


    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};

        var result = nextGreaterElement(nums1, nums2);
        for(int i: result) System.out.print(i+", ");
        System.out.println();
        result = nextGreaterElement1(nums1, nums2);
        for(int i: result) System.out.print(i+", ");


    }
}