package com.action;

import com.bean.Page;

/**
 * Created by Lin on 2017/4/1.
 */
public interface IDownloadable {
    Page download(String url);
}
