package com.store;

import java.util.LinkedList;

/**
 * UrlQueue数据结构用来储存需要进行分析的Url
 * Created by Lin on 2017/3/23.
 */
public class UrlQueue {

    private LinkedList<String> urlQueue = new LinkedList<String>();


    void inQueue(String url) {
        urlQueue.addLast(url);
    }

    String outQueue() {
        return urlQueue.removeFirst();
    }

    boolean queueIsEmpty() {
        return urlQueue.isEmpty();
    }

    int queueNum() {
        return urlQueue.size();
    }

    // 判断队列是否包含某元素
    public boolean contains(String url) {
        return urlQueue.contains(url);
    }
}
