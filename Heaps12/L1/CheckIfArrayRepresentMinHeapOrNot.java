// https://www.geeksforgeeks.org/problems/does-array-represent-heap4345/1

public class CheckIfArrayRepresentMinHeapOrNot{
    public boolean countSub(long arr[], long n)
    {
        if(n==1) return true;
        
        Queue<Long> queue = new LinkedList<>();
        queue.add(arr[0]);
        
        long index = 1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                
                long current = queue.poll();
                
                if(index<n){
                    if(arr[(int)index]>current) return false;
                    if(index<=n/2) queue.add(arr[(int) index]);
                }
                index++;
                
                if(index<n){
                    if(arr[(int)index]>current) return false;
                    if(index<=n/2) queue.add(arr[(int)index]);
                }
                index++;
            }
        }
        
        return true;
    }

    // --------------------------------------------------------------------------


    public boolean countSub(long arr[], long n)
    {
        if(n==1) return true;
        
       
       for(int i=0; i<n/2; i++){
           int left = 2*i+1;
           int right = 2*i+2;
           
           if(left<n && arr[left] > arr[i]) return false;
           if(right<n && arr[right] > arr[i]) return false;
           
       }
        
        return true;
    }
}