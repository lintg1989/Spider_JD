import com.Spider;
import com.action.DownloadImpl;
import com.action.ProcessImpl;
import com.action.StoreImpl;
import com.bean.Good;
import com.util.DBUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lin on 2017/4/1.
 */
public class SpiderTest {

    //保存待下载的页面
    private static List<String> links = new ArrayList<String>();
    //保存已经下载过的集合
    private static List<String>linkPool = new ArrayList<String>();

    public static void crew(String url){

    }

    public static void main(String[] args) throws Exception {
        Spider spider = new Spider();

        //给接口注入实现类
        spider.setDownloadable(new DownloadImpl());
        spider.setProcessable(new ProcessImpl());
        spider.setStoreable(new StoreImpl());

        String url = "http://item.jd.com/1593512.html";
        //  http://p.3.cn/prices/mgets?callback=jQuery8265772&type=1&area=1&pdtk=&pduid=149138153772380930161&pdpin=&pdbp=0&skuIds=J_941794

        List<String> goodIdList = DBUtil.selectSQL(DBUtil.SELECT_GOODS);


        DBUtil.deletePriceTable();

        int i=0;
        for (String goodId:goodIdList) {
            url =  "http://item.jd.com/"+goodId+".html";
            //url = "http://p.3.cn/prices/mgets?callback=jQuery8265772&type=1&area=1&pdtk=&pduid=149138153772380930161&pdpin=&pdbp=0&skuIds=J_"+goodId;
//            Good page = spider.download(url);
//            if (page == null) {
//                links.add(url);
//                continue;
//            }
            Good page =new Good();
            System.out.println(goodId);
            page.setGoodId(goodId);
            spider.process(page);
            spider.store(page);
            System.out.println("获取第"+i+++"个价格");
        }

        for (String link:links) {
            System.out.println("抓取失败连接："+link);
        }

    }
}
