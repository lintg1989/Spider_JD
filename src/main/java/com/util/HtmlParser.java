package com.util;


import org.w3c.dom.Node;
import org.w3c.dom.traversal.NodeFilter;

import java.util.HashSet;
import java.util.Set;

/**
 * 完成对要分析的page包含的地址的提取
 * 将提取的地址放入到一个集合中去
 * Created by Lin on 2017/3/28.
 */
public class HtmlParser {
    private Set<String> links = new HashSet<String>();
    public Set<String> extraLinks(String path) {
        // 需要两个过滤器，一个过滤掉<frame src=>和<a href>标签
        NodeFilter nodeFilter = new NodeFilter() {
            public short acceptNode(Node node) {
                if (node.getTextContent().startsWith("fram src="))
                    return 1;
                return 0;
            }
        };
        return null;
    }
}
