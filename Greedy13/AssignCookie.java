public class AssignCookie{
	public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int child = g.length -1, cookie = s.length -1;
        int index = 0;

        while(child >=0 && cookie>=0){
           if(g[child] <= s[cookie]){
                index++;
                cookie--;
           }
           child--;
           
        }

        return index;
    }


    // --------------------------------------------------------------------

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