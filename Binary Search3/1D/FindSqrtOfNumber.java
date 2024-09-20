public class FindSqrtOfNumber{

	public static int getSqrt(int n){

		if (n == 1) return n;
		int sqrt = 1;

		for(int i=2;i<=n;i++){
			if(i*i <= n){
				sqrt = i;
			}else{
				return sqrt;
			}
		}

		return 1;
	}


	public static int getSqrt1(int n){
		int left = 1;
		int right = n;
		int result = 1;

		while(left < right){
			int mid = (left + right) /2;
			int sq = mid*mid;
			if(sq == n){
				return mid;
			}else if(sq<n){
				result = Math.max(result, mid);
				left = mid + 1;
			}else{
				right = mid -1;
			}	
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(getSqrt(36));
		System.out.println(getSqrt(28));


		System.out.println(getSqrt1(36));
		System.out.println(getSqrt1(28));
	}
}