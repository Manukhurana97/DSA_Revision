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
}