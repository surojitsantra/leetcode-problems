class Twitter {
    
    private static class Tweet {
        public int tweetId;
        public int postTime;
        
        public Tweet(int tweetId, int postTime) {
            this.tweetId = tweetId;
            this.postTime = postTime;
        }
        
    }

    private Map<Integer, Set<Integer>> followees;
    private Map<Integer, Set<Tweet>> tweets;
    private int timestamp;
    private int maxFeed;
    
    public Twitter() {
        followees = new HashMap<>();
        tweets = new HashMap<>();
        timestamp = 1;
        maxFeed = 10;
    }
    
    public void postTweet(int userId, int tweetId) {
        //self follow
        follow(userId, userId);
        
        tweets.putIfAbsent(userId, new HashSet<>());
        tweets.get(userId).add(new Tweet(tweetId, timestamp++));
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        
        PriorityQueue<Tweet> maxHeap 
            = new PriorityQueue<>((a, b) -> b.postTime -a.postTime);
        
        for(Integer followeeId :followees.getOrDefault(userId, new HashSet<>())) {
            maxHeap.addAll(tweets.getOrDefault(followeeId, new HashSet<>()));
        }
        
        for(int i = 0; i < 10 && !maxHeap.isEmpty(); i++) {
            feed.add(maxHeap.poll().tweetId);
        }
        
        return feed;
    }
    
    public void follow(int followerId, int followeeId) {
        followees.putIfAbsent(followerId, new HashSet<>());
        followees.get(followerId).add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        followees.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */