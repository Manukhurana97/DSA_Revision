class Node{
    int userId;
    int tweetId;
    int index;

    Node(int userId, int tweetId, int index){
        this.userId = userId;
        this.tweetId = tweetId;
        this.index = index;
    }
}

public class Twitter {

    Map<Integer, Set<Integer>> followingList;
    PriorityQueue<Node> tweets;
    int index = 0;

    public Twitter() {
        followingList = new HashMap<>();
        tweets = new PriorityQueue<>((a, b) -> b.index - a.index);
    }
    
    public void postTweet(int userId, int tweetId) {
        tweets.add(new Node(userId, tweetId, index++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> peopleWhoUserFollow = followingList.getOrDefault(userId, new HashSet<>());
        peopleWhoUserFollow.add(userId);
        
        PriorityQueue<Node> temp = new PriorityQueue<>((a, b) -> b.tweetId - a.tweetId);
        int size = tweets.size();
        List<Integer> result = new ArrayList<>();

        while(size-- > 0 && result.size()<10){
            Node current = tweets.poll();
            
            if (peopleWhoUserFollow.contains(current.userId)) result.add(current.tweetId);
        
            temp.add(current);
        }
        tweets.addAll(temp);

        return result;
    }
    
    public void follow(int followerId, int followeeId) {
        followingList.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        if(followingList.containsKey(followerId))
            followingList.get(followerId).remove(followeeId);
    }
}
