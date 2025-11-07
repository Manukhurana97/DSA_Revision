// https://leetcode.com/problems/design-twitter/

import java.util.*;

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

        while(size-- > 0 && result.size()<9){
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



// -------------------------------------------------------------------------------------------------------
// using Linked list


class Tweet{
    int tweetId;
    int userId;

    Tweet(int userId, int tweetId){
        this.userId = userId;
        this.tweetId = tweetId;
    }
}

class Node{
    Tweet tweet;
    Node prev;
    Node next;

    Node(Tweet tweet) {
        this.tweet = tweet;
    }
}

class Twitter {

    Map<Integer, Set<Integer>> personWhoIFollow;
    Node head = null;
    Node tail = null;
    int size;

    public Twitter() {
        this.size = 0;
        personWhoIFollow = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        Node node = new Node(new Tweet(userId, tweetId));
        
        if(head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }

        size += 1;
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        Node current = tail;
        Set<Integer> set = personWhoIFollow.getOrDefault(userId, new HashSet<>());
        set.add(userId);

        while(current != null && result.size() < 10){
            if(set.contains(current.tweet.userId)){
                result.add(current.tweet.tweetId);
            }

            current = current.prev;
        }

        return result;
        
    }
    
    public void follow(int followerId, int followeeId) {
        personWhoIFollow.computeIfAbsent(followerId, k -> new HashSet<>()).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {  
        if(!personWhoIFollow.containsKey(followerId)) return;

        personWhoIFollow.get(followerId).remove(followeeId);
    }
}
