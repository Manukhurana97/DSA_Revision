public class ArrayRepresentationOfHeap{

	public boolean countSub(long arr[], long n)
    {
        if(n==1) return true;
        
        for (int i = 0; i <= (n - 2) / 2; i++) {
            if(2 * i + 1 <n && arr[2*i+1] > arr[i]) return false;
            if(2 * i + 2<n && arr[2*i+2] > arr[i]) return false;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ArrayRepresentationOfHeap obj = new ArrayRepresentationOfHeap();
        long[] arr = {5,4,3,2,1};
        System.out.println(obj.countSub(arr, arr.length));
        
        long[] arr1 = {1,2,3,4,5};
        System.out.println(obj.countSub(arr1, arr1.length));
    }
}