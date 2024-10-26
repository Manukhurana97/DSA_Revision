public class AssignCookie{
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = g.length -1, cookie = s.length -1;
        int count = 0;

        while(child >=0 && cookie>=0){
           if(g[child] <= s[cookie]){
                count++;
                cookie--;
           }
           child--;
           
        }

        return count;
    }


    // --------------------------------------------------------------------

    // c: [ 1 2 3 4] g: [1 2 3 4]
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0, cookie = 0;

        while(child < g.length){
            while(cookie < s.length && g[child] > s[cookie]) 
                cookie++;

            if(cookie == s.length) break;
            cookie++;
            child++;
       }

        return child;
    }
}