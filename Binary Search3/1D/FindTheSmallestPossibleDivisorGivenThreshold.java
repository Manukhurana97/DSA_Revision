public class FindTheSmallestPossibleDivisorGivenThreshold{

	public static int smallestDivisor(int[] nums, int threshold) {

        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        if(threshold == 1) return max;
        
        for(int i=1;i<max;i++){
            int divisor = 0;
            for(int num: nums)
                divisor += Math.ceil((double)num / (double)i);

            if(divisor <= threshold) return i;
        }

        return max;
    }

    public static int smallestDivisor1(int[] nums, int threshold) {

        int max = 0;
        for(int num: nums) max = Math.max(max, num);

        if(threshold == 1) return max;

        int left = 1;
        int right = max;

        while(left<=right){
            int mid = left + (right - left) / 2;

            int divisor = 0;
            for(int num: nums)
                divisor += Math.ceil((double) num / (double) mid);


            if(divisor <= threshold){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }


        return left;
        
    }



	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		int arr1[] = {8,4,2,3};
		System.out.println(" ->"+smallestDivisor(arr, 8));
		System.out.println(" ->"+smallestDivisor(arr1, 10));

		System.out.println(" ->"+smallestDivisor1(arr, 8));
		System.out.println(" ->"+smallestDivisor1(arr1, 10));
	}
}