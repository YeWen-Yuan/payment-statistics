package show.ywy;

import cn.idev.excel.EasyExcel;
import cn.idev.excel.FastExcel;
import cn.idev.excel.read.listener.PageReadListener;
import org.junit.Test;
import show.ywy.wechat.WeChatPayAccounting;
import show.ywy.alipay.AlipayReader;

import java.io.File;
import java.util.ArrayList;

/**
 * @author yzs
 */
public class WxTest {

    String pathname = "/Users/yuanzhushou/Desktop/微信支付账单(20250305-20250324)——【解压密码可在微信支付公众号查看】.csv";

    @Test
    public void test01() {

        FastExcel.read(pathname, WeChatPayAccounting.class, new PageReadListener<WeChatPayAccounting>(dataList -> {
            for (WeChatPayAccounting demoData : dataList) {
                System.out.println(demoData);
            }
        })).headRowNumber(17).sheet().doRead();
    }

    @Test
    public void test30() {
        ArrayList<WeChatPayAccounting> cachedDataList = new ArrayList<>();
        EasyExcel.read(new File(pathname), WeChatPayAccounting.class, new AlipayReader(cachedDataList)).headRowNumber(16)
                .doReadAll();
        System.out.println(cachedDataList);
    }

}
