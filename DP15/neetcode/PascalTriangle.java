// https://leetcode.com/problems/pascals-triangle/

public class PascalTriangle {
    public List<List<Integer>> generate(int n) {
    List<List<Integer>> result = new ArrayList<>();

    for (int i = 0; i < n; i++) { 
        result.add(getRow(i));
    }

    return result;
}


    private List<Integer> getRow(int r){
        List<Integer> list = new ArrayList<>();

        for(int c=0; c<=r; c++){
            if(c == 0 || c == r) list.add(1);
            else list.add(createPascalElement(r, c));
        }

        return list;
    }

    // r! / r-c! * c!
    private int createPascalElement(int r, int c) {
	    int row = 1;

	    for (int i = 0; i < c; i++) {
	        row *= (r - i); 
	        row /= (i + 1);
	    }

	    return row;
	}
}