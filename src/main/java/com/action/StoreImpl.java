package com.action;

import com.bean.Good;
import com.util.DBUtil;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 保存到数据库
 * Created by Lin on 2017/4/1.
 */
public class StoreImpl implements IStoreable{
    public void store(Good page) {
//        String dataUrl = page.getDateUrl();
        String goodId = page.getGoodId();
//        String goodName = page.getGoodName();
        String price = page.getPrice();

//        Map<String, String> values = page.getParam();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currtime = simpleDateFormat.format(new Date());

        //price = "122";
        DBUtil.update(DBUtil.INSERT_PPRICE,goodId,price,currtime);
        //DBUtil.update(DBUtil.INSERT_LOG,goodId,dataUrl,"哈哈",goodName,price,"哈哈",currtime);
    }
}
