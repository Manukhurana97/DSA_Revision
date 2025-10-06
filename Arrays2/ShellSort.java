public class ShellSort {

	public static int[] sort(int[] arr) {
		int n = arr.length;

		for(int gap = n/2; gap>0; gap/=2) {
			for(int i=gap; i<n; i++) {
				int temp = arr[i];

				int j;
				for(j=i; j>=gap && arr[j - gap] > temp; j-=gap) {
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = {5,4,3,2,1,0};
		var result = sort(arr);
		for(int i: result) {
			System.out.print(i+" ");
		}
	}
}