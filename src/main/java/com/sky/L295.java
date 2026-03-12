package com.sky;

import java.util.PriorityQueue;

public class L295 {

    class MedianFinder {
        PriorityQueue<Integer> MaxHeap;
        PriorityQueue<Integer> MinHeap;

        public MedianFinder() {
            MaxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            MinHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        }

        public void addNum(int num) {
            if (MaxHeap.isEmpty() || MaxHeap.peek() >= num) { // 将小于等于中位数的存储在大顶堆
                MaxHeap.offer(num);
                if (MaxHeap.size() - MinHeap.size() > 1)  // 一直进入小于中位数的值
                    MinHeap.offer(MaxHeap.poll());
            } else { // 将大于中位数的元素存储在小顶堆
                MinHeap.offer(num);
                if (MinHeap.size() - MaxHeap.size() > 0)
                    MaxHeap.offer(MinHeap.poll());
            }
        }

        public double findMedian() {
            return (MaxHeap.size() + MinHeap.size()) % 2 == 0 ? (MaxHeap.peek() + MinHeap.peek()) / 2.0 : MaxHeap.peek();
        }
    }
}
