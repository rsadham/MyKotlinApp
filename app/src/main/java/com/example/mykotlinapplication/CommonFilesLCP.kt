package com.example.mykotlinapplication

import com.example.mykotlinapplication.linkedListProblem.ListNode


/* Given an array of integers nums and an integer t, return indices of the two numbers such that they add up to t.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

1. Two Sum - Leetcode 1 - HashMap

https://leetcode.com/problems/two-sum/description/

*/
fun twoSum(nums: IntArray, t: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (i in nums.indices) {
        val complement = t - nums[i]
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[nums[i]] = i
    }
    return intArrayOf()
}

//brute force
fun twoSumBruteForce(nums: IntArray, t: Int): IntArray {
    val n = nums.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (nums[i] + nums[j] == t) {
                return intArrayOf(i, j)
            }
        }
    }

    return intArrayOf()
}

/* You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
2. Best Time to Buy and Sell Stock - Leetcode 121 - DP
https://www.youtube.com/watch?v=1pkOgXD63yU
*/
fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty()) return 0

    var minPrice = prices[0]
    var maxProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]  // Update the minimum price
        } else {
            val profit = prices[i] - minPrice
            if (profit > maxProfit) {
                maxProfit = profit  // Update profit only when we get better one
            }
        }
    }

    return maxProfit
}

//brute force
fun maxProfitBruteForce(prices: IntArray): Int {
    val n = prices.size
    var maxProfit = 0
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val profit = prices[j] - prices[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
        }
    }
    return maxProfit
}


/* Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
https://leetcode.com/problems/contains-duplicate/description/
3. Contains Duplicate - Leetcode 217
*/
fun containsDuplicate(nums: IntArray): Boolean {
    val seen = HashSet<Int>()

    for (num in nums) {
        if (num in seen) return true
        seen.add(num)
    }
    return false
}

//bruteForce
fun containsDuplicateBruteForce(nums: IntArray): Boolean {
    val n = nums.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            if (nums[i] == nums[j]) {
                return true
            }
        }
    }

    return false
}

/*Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.
4.Product of Array Except Self - Leetcode 238
https://leetcode.com/problems/product-of-array-except-self/description/
 */

fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val result = IntArray(n)

    // Step 1: Fill result with prefix products
    var prefix = 1
    for (i in 0 until n) {
        result[i] = prefix
        prefix *= nums[i]
    }

    // Step 2: Multiply with suffix products
    var suffix = 1
    for (i in n - 1 downTo 0) {
        result[i] *= suffix
        suffix *= nums[i]
    }

    return result
}

/* 5.Maximum Subarray - Amazon Coding Interview Question - Leetcode 53
Given an integer array nums, find the subarray with the largest sum, and return its sum.
https://leetcode.com/problems/maximum-subarray/description/
*/
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currSum = nums[0]

    for (i in 1 until nums.size) {
        currSum = maxOf(nums[i], currSum + nums[i])
        maxSum = maxOf(maxSum, currSum)
    }

    return maxSum
}

/* Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.

Note that the product of an array with a single element is the value of that element.

https://leetcode.com/problems/maximum-product-subarray/
6.Maximum Product Subarray - Dynamic Programming - Leetcode 152
*/
fun maxProduct(nums: IntArray): Int {
    // Initialize maxProd, minProd and result as the first element of the array
    var maxProd = nums[0]
    var minProd = nums[0]
    var result = nums[0]

    // Traverse from the second element onwards
    for (i in 1 until nums.size) {
        val current = nums[i]
        // If current is negative, swap maxProd and minProd
        if (current < 0) {
            val temp = maxProd
            maxProd = minProd
            minProd = temp
        }
        // Calculate maxProd and minProd ending at current index
        maxProd = maxOf(current, maxProd * current)
        minProd = minOf(current, minProd * current)

        // Update result with the maximum product found so far
        result = maxOf(result, maxProd)
    }
    return result
}

/* Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.

https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
7.Find Minimum in Rotated Sorted Array - Binary Search - Leetcode 153*/
fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = (left + right) / 2

        // If mid element is greater than right element,
        // minimum is in the right side
        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else {
            // Minimum is in the left side including mid
            right = mid
        }
    }

    return nums[left] // left == right -> minimum element
}

/* There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer t, return the index of t if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
8.Search in rotated sorted array - Leetcode 33*/

fun search(nums: IntArray, t: Int): Int {

    var l = 0
    var r = nums.size - 1

    while (l <= r) {
        val mid = (l + r) / 2

        if (t == nums[mid]) {
            return mid
        }

        if (nums[l] <= nums[mid]) {
            if (t > nums[mid] || t < nums[l]) {
                l = mid + 1
            } else {
                r = mid - 1
            }
        } else {
            if (t < nums[mid] || t > nums[r]) {
                r = mid - 1
            } else {
                l = mid + 1
            }
        }

    }

    return -1
}

/* Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.
https://leetcode.com/problems/3sum/description/
9.3Sum - Leetcode 15
*/
fun threeSum(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    nums.sort()

    for (i in nums.indices) {
        // Skip duplicate values for i
        if (i > 0 && nums[i] == nums[i - 1]) continue

        var left = i + 1
        var right = nums.size - 1

        while (left < right) {
            val sum = nums[i] + nums[left] + nums[right]

            when {
                sum == 0 -> {
                    result.add(listOf(nums[i], nums[left], nums[right]))

                    // Move both pointers and avoid duplicates
                    left++
                    right--

                    while (left < right && nums[left] == nums[left - 1]) left++
                    while (left < right && nums[right] == nums[right + 1]) right--
                }

                sum < 0 -> left++
                else -> right--
            }
        }
    }

    return result
}

/* You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
https://leetcode.com/problems/container-with-most-water/description/
10.Container with Most Water - Leetcode 11
*/
fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxArea = 0

    while (left < right) {
        val width = right - left
        val currentHeight = minOf(height[left], height[right])
        val area = width * currentHeight
        maxArea = maxOf(maxArea, area)

        // Move the smaller pointer inward
        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}

/* Given two integers a and b, return the sum of the two integers without using the operators + and -.
https://leetcode.com/problems/sum-of-two-integers/description/
11.Sum of Two Integers - Leetcode 371*/

fun getSum(a: Int, b: Int): Int {
    var x = a
    var y = b

    while (y != 0) {
        val carry = (x and y) shl 1   // Calculate carry
        x = x xor y                   // Add without carry
        y = carry                     // Move carry to next iteration
    }

    return x
}

/* Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
https://leetcode.com/problems/number-of-1-bits/description/
12.Number of 1 Bits - Leetcode 191
*/
fun hammingWeight(n: Int): Int {
    var count = 0
    var num = n

    while (num != 0) {
        num = num and (num - 1)  // Remove the rightmost 1 bit
        count++
    }
    return count
}

/*
Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
https://leetcode.com/problems/counting-bits/description/
13.Counting Bits - Dynamic Programming - Leetcode 338
*/
fun countBits(n: Int): IntArray {
    val dp = IntArray(n + 1)
    var offset = 1

    for (i in 1..n) {
        if (offset * 2 == i) {
            offset = i
        }
        dp[i] = 1 + dp[i - offset]
    }

    return dp
}

/* Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.
https://leetcode.com/problems/missing-number/description/
14.Missing Number - Blind 75 - Leetcode 268
*/
fun missingNumber(nums: IntArray): Int {
    var n = nums.size  // Start with n

    for (i in nums.indices) {
        n = n xor i  // XOR with index
        n = n xor nums[i]  // XOR with number
    }
    return n
}

/* Reverse bits of a given 32 bits signed integer.
https://leetcode.com/problems/reverse-bits/description/
15.Reverse Bits - Binary - Leetcode 190
*/
fun reverseBits(n: Int): Int {
    var num = n
    var result = 0

    for (i in 0 until 32) {
        result = result shl 1       // Shift result left to make space
        result = result or (num and 1) // Add last bit of num into result
        num = num ushr 1           // Shift num right (unsigned)
    }

    return result
}

/* You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
https://leetcode.com/problems/climbing-stairs/description/
16.Climbing Stairs - Dynamic Programming - Leetcode 70
*/
fun climbStairs(n: Int): Int {
    if (n <= 2) return n
    var first = 1
    var second = 2
    for (i in 3..n) {
        val third = first + second
        first = second
        second = third
    }
    return second
}

/* You are given an integer array coins representing coins of different denominations and an integer
amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of
money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.
https://leetcode.com/problems/coin-change/description/
17.Coin Change - Dynamic Programming Bottom Up - Leetcode 322
*/
fun coinChange(coins: IntArray, amount: Int): Int {
    val dp = IntArray(amount + 1) { amount + 1 } // initialize with "infinity"
    dp[0] = 0

    for (a in 1..amount) {
        for (c in coins) {
            if (a - c >= 0) {
                dp[a] = minOf(dp[a], 1 + dp[a - c])
            }
        }
    }

    return if (dp[amount] > amount) -1 else dp[amount]
}

/* Given an integer array nums, return the length of the longest strictly increasing subsequence.
https://leetcode.com/problems/longest-increasing-subsequence/description/
18.Longest Increasing Subsequence - Dynamic Programming - Leetcode 300
*/
fun lengthOfLIS(nums: IntArray): Int {
    val sub = mutableListOf<Int>()
    for (num in nums) {
        var i = sub.binarySearch(num)
        if (i < 0) i = -(i + 1)
        if (i == sub.size) sub.add(num)
        else sub[i] = num
    }
    return sub.size
}

/* Given two strings text1 and text2, return the length of their longest common subsequence.
If there is no common subsequence, return 0.
A subsequence of a string is a new string generated from the original string with
some characters (can be none) deleted without changing the relative order of the t characters.
For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.
https://leetcode.com/problems/longest-common-subsequence/
19.Longest Common Subsequence - Dynamic Programming - Leetcode 1143
*/
fun longestCommonSubsequence(text1: String, text2: String): Int {
    val n = text1.length
    val m = text2.length

    // DP table
    val dp = Array(n + 1) { IntArray(m + 1) }

    for (i in 1..n) {
        for (j in 1..m) {
            dp[i][j] = if (text1[i - 1] == text2[j - 1]) {
                1 + dp[i - 1][j - 1]
            } else {
                maxOf(dp[i - 1][j], dp[i][j - 1])
            }
        }
    }
    return dp[n][m]
}

/* Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a
space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.
https://leetcode.com/problems/word-break/description/
20.Word Break - Dynamic Programming - Leetcode 139*/
fun wordBreak(s: String, wordDict: List<String>): Boolean {
    val wordSet = wordDict.toSet()        // Faster O(1) lookups
    val n = s.length

    // dp[i] = true means substring s[0 until i] can be segmented
    val dp = BooleanArray(n + 1)
    dp[0] = true                          // empty string is always valid

    for (i in 1..n) {
        for (j in 0 until i) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                dp[i] = true
                break                     // no need to check more j's
            }
        }
    }

    return dp[n]
}

/* Given an array of distinct integers c and a t integer t, return a list of all unique combinations of c where the chosen numbers sum to t. You may return the combinations in any order.

The same number may be chosen from c an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to t is less than 150 combinations for the given input.
https://leetcode.com/problems/combination-sum/description/
21.Combination Sum - Backtracking - Leetcode 39*/
fun combinationSum(c: IntArray, t: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    c.sort()
    backtrack(c, 0, t, mutableListOf(), result)
    return result
}

fun backtrack(
    c: IntArray,
    start: Int,
    t: Int,
    path: MutableList<Int>,
    result: MutableList<List<Int>>
) {
    if (t == 0) {
        result.add(ArrayList(path))
        return
    }

    for (i in start until c.size) {
        val num = c[i]

        if (num > t) break  // 🔥 Pruning for efficiency

        path.add(num)
        backtrack(c, i, t - num, path, result)  // i (not i+1) → reuse allowed
        path.removeAt(path.size - 1)
    }
}

/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
https://leetcode.com/problems/house-robber/description/
22.House Robber - Leetcode 198*/
fun rob(nums: IntArray): Int {
    // If there are no houses, nothing to rob
    if (nums.isEmpty()) return 0

    var prev1 = 0 // Max money till previous house
    var prev2 = 0 // Max money till house before previous

    // Go through each house one by one
    for (num in nums) {
        val temp = prev1        // Save old prev1
        // Either rob this house (prev2 + num) or skip it (prev1)
        prev1 = maxOf(prev2 + num, prev1)
        prev2 = temp            // Move prev1 to prev2 for next round
    }

    // Finally, prev1 has the best total money
    return prev1
}

fun robAlternative(nums: IntArray): Int {

    if (nums.isEmpty()) return 0

    val n = nums.size

    val dp = IntArray(n + 1)
    dp[0] = 0
    dp[1] = nums[0]

    for (i in 2..n) {
        dp[i] = maxOf(dp[i - 1], dp[i - 2] + nums[i - 1])
    }

    return dp[n]
}

/* You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
https://leetcode.com/problems/house-robber-ii/description/
23.House Robber II - Dynamic Programming - Leetcode 213*/
fun robSecond(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) return 0
    if (n == 1) return nums[0]

    // Run normal house robber on a range
    fun robLinear(arr: IntArray): Int {
        var prev1 = 0
        var prev2 = 0
        for (num in arr) {
            val temp = prev1
            prev1 = maxOf(prev1, prev2 + num)
            prev2 = temp
        }
        return prev1
    }

    // Case 1: Exclude last house → nums[0..n-2]
    val case1 = robLinear(nums.copyOfRange(0, n - 1))

    // Case 2: Exclude first house → nums[1..n-1]
    val case2 = robLinear(nums.copyOfRange(1, n))

    return maxOf(case1, case2)
}

/* You have intercepted a secret message encoded as a string of numbers. The message is decoded via the following mapping:

"1" -> 'A'

"2" -> 'B'

...

"25" -> 'Y'

"26" -> 'Z'

However, while decoding the message, you realize that there are many different ways you can decode the message because some codes are contained in other codes ("2" and "5" vs "25").

For example, "11106" can be decoded into:

"AAJF" with the grouping (1, 1, 10, 6)
"KJF" with the grouping (11, 10, 6)
The grouping (1, 11, 06) is invalid because "06" is not a valid code (only "6" is valid).
Note: there may be strings that are impossible to decode.

Given a string s containing only digits, return the number of ways to decode it. If the entire string cannot be decoded in any valid way, return 0.

The test cases are generated so that the answer fits in a 32-bit integer.
https://leetcode.com/problems/decode-ways/description/
24.Decode Ways - Dynamic Programming - Leetcode 91*/
fun numDecodings(s: String): Int {
    if (s.isEmpty() || s[0] == '0') return 0

    var prev = 1  // dp[i-1]
    var prevPrev = 1 // dp[i-2]

    for (i in 1 until s.length) {
        var current = 0

        // Single digit decode (1–9)
        if (s[i] != '0') {
            current += prev
        }

        // Two digit decode (10–26)
        val twoDigit = (s[i - 1] - '0') * 10 + (s[i] - '0')
        if (twoDigit in 10..26) {
            current += prevPrev
        }

        prevPrev = prev
        prev = current
    }

    return prev
}

/* ValidAnagram
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
https://leetcode.com/problems/valid-anagram/description/
*/

//bruteForce
fun isAnagramBruteForce(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }
    val a = s.toCharArray()
    val b = t.toCharArray()
    a.sort()
    b.sort()
    return a.contentEquals(b)
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val count = IntArray(26)
    for (i in s.indices) {
        count[s[i] - 'a']++
        count[t[i] - 'a']--
    }
    for (c in count) {
        if (c != 0) return false
    }
    return true
}

/* Longest Substring without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
*/
fun lengthOfLongestSubstring(s: String): Int {
    val map = HashMap<Char, Int>()  // stores last index of character
    var left = 0
    var maxLen = 0

    for (right in s.indices) {
        val ch = s[right]

        // if character already seen, move left pointer
        if (map.containsKey(ch)) {
            left = maxOf(left, map[ch]!! + 1)
        }

        map[ch] = right
        maxLen = maxOf(maxLen, right - left + 1)
    }

    return maxLen
}

/* Maximum Depth of Binary Tree
Given the root of a binary tree, return its maximum depth.

A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
 */
fun maxDepthOfRootTree(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    val left = root.left
    val right = root.right
    return 1 + maxOf(maxDepthOfRootTree(left), maxDepthOfRootTree(right))
}

/*Invert Binary Tree
 Given the root of a binary tree, invert the tree, and return its root.
 https://leetcode.com/problems/invert-binary-tree/description/
 */
fun invertTree(root: TreeNode?): TreeNode? {

    if (root == null) {
        return null
    }

    val left = invertTree(root.left)
    val right = invertTree(root.right)

    root.left = right
    root.right = left

    return root
}

/* Binary Search
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
https://leetcode.com/problems/binary-search/description/
*/
fun binarySearch(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            nums[mid] == target -> return mid
            nums[mid] < target -> left = mid + 1
            else -> right = mid - 1
        }

    }
    return -1
}

/* First Bad Version
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
https://leetcode.com/problems/first-bad-version/description/
*/
fun isBadVersion(n: Int): Boolean {
    return true
}

fun firstBadVersion(n: Int): Int {
    var left = 1
    var right = n

    while (left < right) {
        val mid = left + (right - left) / 2

        if (isBadVersion(mid)) {
            right = mid
        } else {
            left = mid + 1
        }
    }
    return left
}

/*Reverse Linked List
Given the head of a singly linked list, reverse the list, and return the reversed list.
https://leetcode.com/problems/reverse-linked-list/description/
*/
fun reverseList(node: ListNode): ListNode? {
    var prev: ListNode? = null
    var curr: ListNode? = node
    while (curr != null) {
        val nextTemp = curr.next
        curr.next = prev
        prev = curr
        curr = nextTemp
    }

    return prev
}

/*Linked List cycle
Given head, the head of a linked list, determine if the linked list has a cycle in it.

There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

Return true if there is a cycle in the linked list. Otherwise, return false.
https://leetcode.com/problems/linked-list-cycle/description/
*/
fun hasCycle(head: ListNode?): Boolean {
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            return true
        }
    }
    return false
}

/* Minimum size subarray sum
Given an array of positive integers nums and a positive integer target, return the minimal length of a subarray whose
sum is greater than or equal to target. If there is no such subarray, return 0 instead.
https://leetcode.com/problems/minimum-size-subarray-sum/
*/
fun minSizeSubarraySum(nums: IntArray, target: Int): Int {
    var left = 0
    var sum = 0
    var min = Int.MAX_VALUE

    for (i in nums.indices) {
        sum += nums[i]

        while (sum >= target) {
            min = minOf(min, i - left + 1)
            sum -= nums[left]
            left++
        }

    }
    return if (min == Int.MAX_VALUE) 0 else min

}

/* Fruits into baskets
You are visiting a farm that has a single row of fruit trees arranged from left to right. The trees are represented by an integer array fruits where fruits[i] is the type of fruit the ith tree produces.

You want to collect as much fruit as possible. However, the owner has some strict rules that you must follow:

You only have two baskets, and each basket can only hold a single type of fruit. There is no limit on the amount of fruit each basket can hold.
Starting from any tree of your choice, you must pick exactly one fruit from every tree (including the start tree) while moving to the right. The picked fruits must fit in one of your baskets.
Once you reach a tree with fruit that cannot fit in your baskets, you must stop.
Given the integer array fruits, return the maximum number of fruits you can pick.
https://leetcode.com/problems/fruit-into-baskets/description/
 */
fun maxFruits(fruits: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    var left = 0
    var max = 0

    for (i in fruits.indices) {
        map[fruits[i]] = map.getOrDefault(fruits[i], 0) + 1

        while (map.size > 2) {
            map[fruits[left]] = map[fruits[left]]!! - 1
            if (map[fruits[left]] == 0) {
                map.remove(fruits[left])
            }
            left++
        }
        max = maxOf(max, i - left + 1)
    }
    return max
}

/*
Subarray Sum Equals K
Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
A subarray is a contiguous non-empty sequence of elements within an array.
https://leetcode.com/problems/subarray-sum-equals-k/description/
*/
fun subarraySum(nums: IntArray, k: Int): Int {
    val map = mutableMapOf<Int, Int>()
    map[0] = 1
    var pSum = 0
    var count = 0
    for (i in nums) {
        pSum += i
        count += map.getOrDefault(pSum - k, 0)
        map[pSum] = map.getOrDefault(pSum, 0) + 1
    }
    return count
}

/*
Continuous Subarray Sum (Multiple of K)
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
https://leetcode.com/problems/continuous-subarray-sum/description/
 */
fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    // remainder -> first index
    val map = mutableMapOf<Int, Int>()
    map[0] = -1   // Important base case

    var sum = 0

    for (i in nums.indices) {
        sum += nums[i]

        val rem = if (k != 0) sum % k else sum

        if (map.containsKey(rem)) {
            val prevIndex = map[rem]!!
            if (i - prevIndex >= 2) {
                return true
            }
        } else {
            // store only first occurrence
            map[rem] = i
        }
    }
    return false
}

/*
Diameter of Binary Tree
Given the root of a binary tree, return the length of the diameter of the tree.

The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.

The length of a path between two nodes is represented by the number of edges between them.
https://leetcode.com/problems/diameter-of-binary-tree/description/
 */
fun diameterOfBinaryTree(root: TreeNode?): Int {
    var diameter = 0
    fun maxDepth(root:TreeNode?): Int{
        if(root == null) return 0

        val left = maxDepth(root.left)
        val right = maxDepth(root.right)

        diameter = maxOf(diameter,right+left)

        return 1+maxOf(left,right)
    }
    maxDepth(root)
    return diameter
}

















