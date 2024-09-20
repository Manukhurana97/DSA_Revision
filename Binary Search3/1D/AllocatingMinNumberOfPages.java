public class AllocatingMinNumberOfPages{

	public static int countStudent(int[] arr, int pages){
		int pagesStudent = 0;
		int student  = 0;
		for(var i: arr){
			if(i + pagesStudent <= pages){
				pagesStudent += i;
			}else{
				student+=1;
				pagesStudent = i;
			}
		}

		return student;
	}

	public static int getMaxPages(int[] arr, int m){

		if(arr.length == 1) return arr[0];
		if(arr.length<=m) return -1;

		int minPages = 0;
		int maxPages = 0;

		for(var i: arr){
			minPages = Math.max(minPages, i);
			maxPages += i;
		}
		if(m == 1) return maxPages;

		int maxPagesThatCanbeAssign = minPages;

		for(int i=minPages;i<=maxPages;i++){
			if(countStudent(arr, i) == m){
				maxPagesThatCanbeAssign = i;
			}
		}

		return maxPagesThatCanbeAssign+1;
	}

	public static int getMaxPages1(int[] arr, int m){

		if(arr.length == 1) return arr[0];
		if(arr.length<=m) return -1;

		int minPages = 0;
		int maxPages = 0;

		for(var i: arr){
			minPages = Math.max(minPages, i);
			maxPages += i;
		}
		if(m == 1) return maxPages;
	

		int left = minPages;
		int right = maxPages;

		while(left<right){
			int mid = (left + right)/2;

			if(countStudent(arr, mid)<m){
				right = mid-1;
			}else{
				left = mid+1;
			}
		}

		return left+1;
	}



	public static void main(String[] args) {
		int[] arr = {12, 34, 67, 90};
		int[] arr1 = {25, 46, 28, 49, 24};
		
		System.out.println(getMaxPages(arr, 2));
		System.out.println(getMaxPages(arr1, 4));


		
		System.out.println(getMaxPages1(arr, 2));
		System.out.println(getMaxPages1(arr1, 4));

	}
}