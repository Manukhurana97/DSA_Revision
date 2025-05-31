// https://www.geeksforgeeks.org/generate-binary-strings-without-consecutive-1s/

import java.util.*;

// 1. generate all substring
// 2. validate if prev and current both have 1 , invalid case , make flag false, break
// 3. add missing "0"
// 4. reverse the string string we are appending "0" in last

public class GenerateAllBinaryStrings{

	public List<String> generate(int k){
		int n = 1<<k; // total string

		List<String> result = new ArrayList<>();
		generate(n, k, result);
		return result;
	}

	public void generate(int n, int k, List<String> result){

		for(int i=0; i<n; i++){
			StringBuilder builder = new StringBuilder();
			
			boolean flag = true;
			int j=i, prevBit = 0;

			while(j!=0){
				int currBit = (j&1);

				if(currBit == 1 && prevBit == 1){ // if previous 
					flag = false;
					break;
				}

				prevBit = currBit;
				builder.append(currBit);
				j>>=1;
			}

			if(flag){
				while(builder.length() < k){
					builder.append('0'); // Append missing `0`s
				}
				
				result.add(builder.reverse().toString());}
		}

	}

	public static void main(String[] args) {
		GenerateAllBinaryStrings obj = new GenerateAllBinaryStrings();
		System.out.println(obj.generate(4));
	}
	
}