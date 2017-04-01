package com;

import com.action.IDownloadable;
import com.action.IProcessable;
import com.action.IStoreable;
import com.bean.Page;

/**
 * Created by Lin on 2017/4/1.
 */
public class Spider {
    private IDownloadable downloadable;
    private IProcessable processable;
    private IStoreable storeable;

    //下载页面源码
    public Page download(String url) {
        return downloadable.download(url);
    }

    //解析页面源码
    public void process(Page page) {
        processable.process(page);
    }

    //解析后数据保存到数据库
    public void store(Page page) {
        storeable.store(page);
    }

    public IDownloadable getDownloadable() {
        return downloadable;
    }

    public void setDownloadable(IDownloadable downloadable) {
        this.downloadable = downloadable;
    }

    public IProcessable getProcessable() {
        return processable;
    }

    public void setProcessable(IProcessable processable) {
        this.processable = processable;
    }

    public IStoreable getStoreable() {
        return storeable;
    }

    public void setStoreable(IStoreable storeable) {
        this.storeable = storeable;
    }
}
