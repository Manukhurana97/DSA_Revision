public class MergeTriplet{
	public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] result = new int[3];
        
        for(int[] triplet: triplets){
            boolean flag = true;
            for(int i=0;i<3;i++){
                if(triplet[i]>target[i]) {
                    flag = false;
                    break;
                };
            }

            if(flag){
                for(int i=0;i<3;i++){
                    if(triplet[i] == target[i]){
                        result[i] = triplet[i];
                    }
                }
            }
        }

        return Arrays.equals(target, result);
    }
}