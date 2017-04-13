package com.action;

import com.bean.Good;
import com.util.PageUtil;

/**
 * Created by Lin on 2017/4/1.
 */
public class DownloadImpl implements IDownloadable {

    public Good download(String url) {
        Good page = new Good();
        String content = PageUtil.getContent(url);
        page.setContent(content);
        return page;
    }
}
