package zyj.yihong.leetcode.random_select.oct;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

// 355 设计推特
public class Twitter {

    private Map<Integer, User> userMap;
    private Map<Integer, Long> twitterTime;
    private AtomicLong atomicLong = new AtomicLong();

    public Twitter() {
        userMap = new HashMap<>();
        twitterTime = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User user = userMap.get(userId);
        if (user == null) {
            user = new User();
            userMap.put(userId, user);
        }
        user.twitterIdList.addFirst(tweetId);
        twitterTime.put(tweetId, atomicLong.addAndGet(1));
    }

    public List<Integer> getNewsFeed(int userId) {
        User user = userMap.getOrDefault(userId, new User());
        LinkedList<Integer> curTwitterIdList = new LinkedList<>();
        for (int i = 0; i < user.twitterIdList.size() && i < 10; i++) {
            curTwitterIdList.add(user.twitterIdList.get(i));
        }

        for (Integer follower : user.followerSet) {
            if (follower == userId) {
                continue;
            }

            LinkedList<Integer> tempTwitter = new LinkedList<>();
            User followerUser = userMap.getOrDefault(follower, new User());
            LinkedList<Integer> followerUserTwitterList = followerUser.twitterIdList;

            int index1 = 0;
            int index2 = 0;

            // 添加关注者推特链表有数据的情况
            if (index2 < followerUserTwitterList.size()) {
                while (index1 < curTwitterIdList.size() && index2 < followerUserTwitterList.size()) {
                    Long twitterTime1 = twitterTime.get(curTwitterIdList.get(index1));
                    Long twitterTime2 = twitterTime.get(followerUserTwitterList.get(index2));
                    if (twitterTime1 > twitterTime2) {
                        tempTwitter.add(curTwitterIdList.get(index1));
                        index1++;
                    } else {
                        tempTwitter.add(followerUserTwitterList.get(index2));
                        index2++;
                    }

                    // 如果当前两个链表组合超过10条，则后续不用继续处理，直接退出
                    if (tempTwitter.size() == 10) {
                        break;
                    }
                }
            }

            // 处理完两个链表可能出现处理完其中一条，但是不满足10条的情况
            if (tempTwitter.size() < 10 && index1 < curTwitterIdList.size()) {
                for (; index1 < curTwitterIdList.size() && tempTwitter.size() < 10; index1++) {
                    tempTwitter.add(curTwitterIdList.get(index1));
                }
            }

            if (tempTwitter.size() < 10 && index2 < followerUserTwitterList.size()) {
                for (; index2 < followerUserTwitterList.size() && tempTwitter.size() < 10; index2++) {
                    tempTwitter.add(followerUserTwitterList.get(index2));
                }
            }

            curTwitterIdList = new LinkedList<>(tempTwitter);
        }

        return curTwitterIdList;
    }

    public void follow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user == null) {
            user = new User();
            userMap.put(followerId, user);
        }

        user.followerSet.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User user = userMap.get(followerId);
        if (user == null) {
            user = new User();
            userMap.put(followerId, user);
        }
        user.followerSet.remove(followeeId);
    }


    static class User {
        public Set<Integer> followerSet;
        public LinkedList<Integer> twitterIdList;

        public User() {
            followerSet = new HashSet<>();
            twitterIdList = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        String[] opt = {"postTweet", "follow", "follow", "getNewsFeed", "postTweet", "getNewsFeed", "getNewsFeed", "unfollow", "getNewsFeed", "getNewsFeed", "unfollow", "getNewsFeed", "getNewsFeed"};
        int[][] data = {{1, 5}, {1, 2}, {2, 1}, {2}, {2, 6}, {1}, {2}, {2, 1}, {1}, {2}, {1, 2}, {1}, {2}};
        Twitter twitter = new Twitter();
        for (int i = 0; i < opt.length; i++) {
            String s = opt[i];
            if (s.equals("postTweet")) {
                twitter.postTweet(data[i][0], data[i][1]);
            } else if (s.equals("follow")) {
                twitter.follow(data[i][0], data[i][1]);
            } else if (s.equals("getNewsFeed")) {
                List<Integer> newsFeed = twitter.getNewsFeed(data[i][0]);
                System.out.println(newsFeed);
            } else if (s.equals("unfollow")) {
                twitter.unfollow(data[i][0], data[i][1]);
            }
        }


    }
}

