public class SplitArrayintoFibonacciSequence {
	public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        if(num.length() < 3) return result;

        recursion(0, num, new ArrayList<Integer>(), result);
        return result;
    }

    public boolean recursion(int i, String num, List<Integer> list, List<Integer> result) {
        if(i == num.length()) {
            if(list.size() >= 3){
                result.addAll(list);
                return true;
            }
            return false;
        }
        

        for(int j=i+1; j<=num.length(); j++) {
            long val = Long.parseLong(num.substring(i, j));
            if(val > Integer.MAX_VALUE || j>i+1 && num.charAt(i) == '0') break;
            if(list.size() >= 2 && list.get(list.size()-2) + list.get(list.size()-1) != val) continue;
            
            list.add((int)val);
            if (recursion(j, num, list, result)) return true;
            list.remove(list.size()-1);
        }

        return false;
    }

}