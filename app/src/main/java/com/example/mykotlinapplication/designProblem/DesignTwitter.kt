package com.example.mykotlinapplication.designProblem


import java.util.*

import java.util.*

class Twitter {
    private var timeStamp = 0

    inner class Tweet(val id: Int) {
        val time: Int = timeStamp++
        var next: Tweet? = null
    }

    inner class User(val id: Int) {
        val followed = HashSet<Int>()
        var head: Tweet? = null

        init {
            follow(id) // follow yourself
        }

        fun follow(userId: Int) {
            followed.add(userId)
        }

        fun unfollow(userId: Int) {
            if (userId != id) followed.remove(userId)
        }

        fun post(tweetId: Int) {
            val t = Tweet(tweetId)
            t.next = head
            head = t
        }
    }

    private val userMap = HashMap<Int, User>()

    fun postTweet(userId: Int, tweetId: Int) {
        userMap.putIfAbsent(userId, User(userId))
        userMap[userId]!!.post(tweetId)
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val res = mutableListOf<Int>()
        if (!userMap.containsKey(userId)) return res

        val pq = PriorityQueue<Tweet> { a, b -> b.time - a.time }

        for (uid in userMap[userId]!!.followed) {
            val t = userMap[uid]?.head
            if (t != null) pq.offer(t)
        }

        while (pq.isNotEmpty() && res.size < 10) {
            val t = pq.poll()
            res.add(t.id)
            if (t.next != null) pq.offer(t.next)
        }
        return res
    }

    fun follow(followerId: Int, followeeId: Int) {
        userMap.putIfAbsent(followerId, User(followerId))
        userMap.putIfAbsent(followeeId, User(followeeId))
        userMap[followerId]!!.follow(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userMap[followerId]?.unfollow(followeeId)
    }
}

fun main() {
    val twitter = Twitter()

    twitter.postTweet(1, 5)
    println("User 1's feed: ${twitter.getNewsFeed(1)}") // [5]

    twitter.follow(1, 2)
    twitter.postTweet(2, 6)
    println("User 1's feed after following 2: ${twitter.getNewsFeed(1)}") // [6, 5]

    twitter.unfollow(1, 2)
    println("User 1's feed after unfollowing 2: ${twitter.getNewsFeed(1)}") // [5]
}








