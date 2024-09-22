import java.util.*;

public class NumberOfNGEsOnRight{
     // Time : O(NlogN + logN),Space: O(queries)
    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
    // code here
        
        Set<Integer> set = new HashSet<>();
        for(int i: indices) set.add(arr[i]);
        
        Arrays.sort(arr);
        
        int[] result = new int[queries];
        int index = 0;
        for(var i: set){
            result[index++] = N - getIndex(arr, i, N);
        }
        
        return result;
     
  }
  
  public static int getIndex(int arr[] , int i, int n){
      int start = 0;
      int end = n-1;
      
      while(start<end){
          int mid  = start + (end-start)/2;
          
          if (arr[mid]> i) end = mid-1;
          else start = mid + 1;
      }
      
      return start;
  }

  // --------------------------------------------------------------------------------------------

  

  public static void main(String[] args) {
    int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
    int[] queries = {0, 5};
     var result = count_NGEs(arr.length, arr, queries.length, queries);
     for(var i: result) System.out.print(i+" ");
    
  }
}