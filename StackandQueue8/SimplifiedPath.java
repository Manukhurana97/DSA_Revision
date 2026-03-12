// https://leetcode.com/problems/simplify-path/

public class SimplifiedPath{
	public String simplifyPath(String path) {
        String[] str = path.split("/");
        Deque<String> queue = new ArrayDeque<>();

        for(String s: str) {
            if(s.equals("") || s.equals(".")) continue;
            if(s.equals("..")) {
                if(!queue.isEmpty()) {
                    queue.pollLast();
                }
                continue;
            }

            queue.addLast(s);
        }

        StringBuilder builder = new StringBuilder();
        while(!queue.isEmpty()) {
            builder.append("/").append(queue.pollFirst());
        }

        return builder.isEmpty() ? "/" : builder.toString();
    }
}