// https://leetcode.com/problems/candy/

public class Candy{
	public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n]; 
        int[] right = new int[n]; 


        left[0] = 1;
        for(int i=1; i<n; i++){
           left[i] = ratings[i] > ratings[i - 1] ? left[i-1] + 1 : 1;
        }

        right[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            right[i] = ratings[i] > ratings[i + 1] ? right[i+1] + 1 : 1; 
        }

        int sum = 0;
        for(int i=0; i<n; i++){
            sum += Math.max(left[i], right[i]);
        }

        return sum;
    }



    // ----------------------- optimize ----------------------------------------------------------

    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n]; 
        int sum = 0;


        left[0] = 1;
        for(int i=1; i<n; i++){
           left[i] = ratings[i] > ratings[i - 1] ? left[i-1] + 1 : 1;
        }

        for(int i=n-2;i>=0;i--){
            left[i] =  Math.max(left[i],  ratings[i] > ratings[i + 1] ? left[i+1] + 1 : 1); 

            sum += left[i+1];
        }

        sum+=left[0];

        return sum;
    }	


    // ------------------------------------Slope approach---------------------------------------


//  1 2 3 0 0 5 4 3 2 1 
//  1 2 3 1 1 5 1 1 1 1 left  
//  1 1 2 1 1 5 4 3 2 1 right
//  1+2+3+1+1+5+4+3+2+1: 23

// 1 2 3 4 1 2 3 4: 20


    public int candy(int[] arr) {
        int i=1;
        int sum = 1;

        while(i < arr.length){
            if(arr[i - 1] == arr[i]){
                sum+=1;
                i++;
                continue;
            }

            // fact: last element is smaller then current then only downwords starts
            int up = 1;
            while(i<arr.length && arr[i-1]<arr[i]){
                sum+=++up;
                i++;
            }

            // fact: last element is bigger then current then only downwords starts
            int down=1;
            while(i<arr.length && arr[i-1]>arr[i]){
               sum+=down++;
                i++;
            }

            if(up < down){
                sum += down- up;
            }

        }
        return sum;
    }

}