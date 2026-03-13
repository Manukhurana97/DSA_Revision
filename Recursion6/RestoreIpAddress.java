public class RestoreIpAddress {
	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        recursion(0, s, new ArrayList(), result);
        return result;
    }

    private void recursion(int i, String s, List list, List<String> result) {
        if(list.size() > 4) return;
        if(i==s.length()) {
            if(list.size() == 4) {
                String str = String.join(".", list);
                result.add(str);
            }
            return;
        }

        for(int j=i; j<s.length() && j < i + 3; j++) {
            String str = s.substring(i, j+1);
            if((str.length() > 1 && str.charAt(0) == '0') || Integer.parseInt(s.substring(i, j+1)) > 255) continue;

            list.add(str);
            recursion(j+1, s, list, result);
            list.remove(list.size()-1);
        }
    }
}