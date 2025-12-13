package com.example.mykotlinapplication.arrayProblem


fun search(nums: IntArray, target: Int): Int {

    var l = 0
    var r = nums.size - 1

    while(l<=r){
        val mid = (l+r) / 2

        if(target == nums[mid])
        {
            return mid
        }

        if(nums[l]<=nums[mid]){
            if(target>nums[mid] || target<nums[l]){
                l = mid + 1
            }else{
                r = mid - 1
            }
        }else{
            if(target<nums[mid] || target>nums[r]){
                r = mid - 1
            }else{
                l = mid + 1
            }
        }

    }

    return -1
}

// Main function to test the implementation
fun main() {
    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 0
    val result = search(nums, target)
    println("Target $target found at index: $result")
}









