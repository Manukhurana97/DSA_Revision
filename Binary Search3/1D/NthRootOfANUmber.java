public class NthRootOfANUmber{

	public static int getSqrt(int n, int m){

		for(int i=1;i<=m;i++){
			double pow = Math.pow(i, n);
			if(pow == m) return i;
			if(pow>m) return -1;
		}

		return -1;
	}

	public static int getSqrt1(int n, int m){
		int left = 1;
		int right =m;

		while(left<right){
			int mid = (left + right) /2;

			double pow = Math.pow(mid, n);

			if(pow == m){
				return mid;
			}else if(pow>m){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}

		double pow = Math.pow(right, n);
		return pow == m ? right : -1;
	}




	public static void main(String[] args) {
		System.out.println(getSqrt(3, 27));
		System.out.println(getSqrt(4, 69));

		System.out.println(getSqrt1(3, 27));
		System.out.println(getSqrt1(4, 69));
	}
}