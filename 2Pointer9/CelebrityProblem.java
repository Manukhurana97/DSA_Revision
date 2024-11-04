public class CelebrityProblem{

	public static int findCelebrity(int n, int[][] matrix){
		int[] knowMeCount = new int[n];
		int[] iknowCount = new int[n];

		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(matrix[i][j] == 1){
					knowMeCount[j] +=1;
					iknowCount[i] += 1;
				}
			}
		}

		for(int i=0;i<n;i++){
			if(knowMeCount[i] == n-1 && iknowCount[i] == 0) return i; 
		}

		return -1;
	}

	public static int findCelebrity1(int n, int[][] matrix){
		int top = 0, bottom = n-1;

		while(top<bottom){
			if(matrix[top][bottom] == 1){
				top++;
			}else if(matrix[bottom][top] == 1){
				bottom--;
			}else{
				top++;
				bottom--;
			}
		}

		if(top>bottom) return -1;

		int count = 0;
		for(int i=0;i<n;i++){
			if(matrix[top][i] != 0) return -1;
			count += matrix[i][top] == 1 ? 1 : 0;
		}

		return count == n - 1 ? top : -1;
	}


	public static void main(String[] args) {
		int[][] arr = {{0,1,1,0}, {0,0,0,0}, {0,1,0,0}, {1,1,0,0}};

		System.out.println("celebrity is "+ findCelebrity(arr.length, arr));
		System.out.println("celebrity is "+ findCelebrity1(arr.length, arr));
	}
}