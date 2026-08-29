// https://leetcode.com/problems/pascals-triangle-ii/

public class PascalTriangle2 {
    public List<Integer> getRow(int r) {
        return getRowValues(r);
    }

    public List<Integer> getRowValues(int r) {
        List<Integer> result = new ArrayList<>();

        for(int c=0; c<=r; c++){
            if(c == 0 || r == c) {
                result.add(1);
                continue;
            }

            result.add(getCellValue(r, c));
        }

        return result;
    }

    public int getCellValue(int r, int c) {
        long result = 1;
        for(int i=0; i<c; i++) {
            result = result * (r - i) / (i+1);
        }
    
        return (int) result;
    }
}