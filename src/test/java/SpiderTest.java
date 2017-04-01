import com.Spider;
import com.action.DownloadImpl;
import com.action.ProcessImpl;
import com.action.StoreImpl;
import com.bean.Page;

import java.io.IOException;

/**
 * Created by Lin on 2017/4/1.
 */
public class SpiderTest {

    public static void main(String[] args) throws Exception {
        Spider spider = new Spider();

        //给接口注入实现类
        spider.setDownloadable(new DownloadImpl());
        spider.setProcessable(new ProcessImpl());
        spider.setStoreable(new StoreImpl());

        String url = "http://item.jd.com/1593512.html";
        Page page = spider.download(url);
        spider.process(page);
        spider.store(page);
    }
}
