public class MagneticForceBetweenTwoBalls{
public int maxDistance(int[] positions, int m) {
        int n = positions.length;
        int maxDistance = 0;

        Arrays.sort(positions);

        // min and max Gap possible b/w magnets
    

        int left = 0;
        int right = positions[n-1]-positions[0];
        
        while(left<=right){
            int gap = left + (right - left) / 2;

            int last = positions[0];
            int count = 1;
            for(int position = 1; position < n; position++){
                if(positions[position] - last >= gap){
                    last = positions[position];
                    count++;
                }

                if(count == m) break;
            }

            if(count >= m) {
                maxDistance = gap;
                left = gap + 1;
            }
            else{
                right = gap - 1;
            }
        }
        return maxDistance;
    }
    }