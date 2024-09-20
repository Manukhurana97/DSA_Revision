public class RemoveOuterMostArray{
	public String removeOuterParentheses(String s) {
		int startIndex = 0;

		char[] arr = s.toCharArray();

		int count = 0;
		String result = "";

		for(int i = 0; i < s.length(); i++){
			if(arr[i] == '(') count += 1;
			else{
				count -= 1;
				if(count == 0){
					result += s.substring(startIndex+1, i);
					startIndex = i + 1;
				}
			}
		}
		return result;
		
	}
}