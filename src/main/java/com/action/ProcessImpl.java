package com.action;

import com.bean.Page;
import com.util.PageUtil;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.xpath.XPathException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Lin on 2017/4/1.
 */
public class ProcessImpl implements IProcessable {
    public void process(Page page) {
        HtmlCleaner htmlCleaner = new HtmlCleaner();
        TagNode rootNode = htmlCleaner.clean(page.getContent());
        try {
           //获取商品号
            String url = page.getDateUrl();
            Pattern compile = Pattern.compile("http://item.jd.com/([0-9]]+).html");
            Matcher matcher = compile.matcher(url);
            String goodid = null;
            if (matcher.find()) {
                goodid = matcher.group(1);
                page.setGoodId(goodid);
            }

            //获取是商品价格
         //   String priceJson = PageUtil.getContent("http://p.3.cn/prices/get?skuid=J_" + goodid);
            String priceJson = PageUtil.getContent("http://p.3.cn/prices/get?skuid=J_1593512");
            JSONArray jsonArray = new JSONArray(priceJson);
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            String price =jsonObject.getString("p");
            page.setPrice(price);

        } catch (XPathException e) {
            e.printStackTrace();
        }
    }
}
