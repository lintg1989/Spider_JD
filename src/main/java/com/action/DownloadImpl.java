package com.action;

import com.bean.Page;
import com.util.PageUtil;

/**
 * Created by Lin on 2017/4/1.
 */
public class DownloadImpl implements IDownloadable {
    public Page download(String url) {
        Page page = new Page();
        String content = PageUtil.getContent(url);
        page.setContent(content);
        page.setDateUrl(url);
        return page;
    }
}
