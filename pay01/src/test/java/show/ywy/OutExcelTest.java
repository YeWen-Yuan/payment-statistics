package show.ywy;

import cn.hutool.system.SystemUtil;
import cn.idev.excel.EasyExcel;
import cn.idev.excel.FastExcel;
import cn.idev.excel.read.listener.PageReadListener;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.apache.commons.io.input.ReaderInputStream;
import org.junit.Test;
import show.ywy.wechat.WeChatPayAccounting;
import show.ywy.template.AccountingData;
import show.ywy.alipay.AliPayAccounting;
import show.ywy.wechat.WechatPayReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yzs
 */
public class OutExcelTest {
    private final static String pathname = "/Users/yuanzhushou/Desktop/alipay_record_20250324_1708_1.csv";
    private final static String pathNameVx = "/Users/yuanzhushou/Desktop/微信支付账单(20250305-20250324)——【解压密码可在微信支付公众号查看】.csv";


    public List<AccountingData> data() throws IOException {
        // 指定编码读取文档
        @Cleanup InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "GBK");
        @Cleanup InputStream newInputStream = ReaderInputStream.builder().setCharset("UTF-8").setReader(reader).get();
        List<AliPayAccounting> cachedDataList = new ArrayList<>();
        EasyExcel.read(newInputStream, AliPayAccounting.class, new WechatPayReader(cachedDataList)).headRowNumber(5).numRows(21).doReadAll();
        ArrayList<WeChatPayAccounting> cachedDataLis2t = new ArrayList<>();
        FastExcel.read(pathNameVx, WeChatPayAccounting.class, new PageReadListener<WeChatPayAccounting>(cachedDataLis2t::addAll))
                .headRowNumber(17).sheet().doRead();
        List<AccountingData> result = new ArrayList<>();

        for (AliPayAccounting aliPayAccounting : cachedDataList) {
            result.add(aliPayAccounting.toAccountingData());
        }

        for (WeChatPayAccounting weChatPayAccounting : cachedDataLis2t) {
            result.add(weChatPayAccounting.toAccountingData());
        }
        return result;
    }

    String outPath = "/Users/yuanzhushou/IdeaProjects/payment-statistics/out/";

    @Test
    public void test70() {
        System.out.println(SystemUtil.getUserInfo().getCurrentDir() + "simpleFill.xlsx");
    }

    @Test
    @SneakyThrows
    public void test50() {
        List<AccountingData> data = data();
        System.out.println("insert size = " + data.size());
        FastExcel.write(outPath + "simpleFill3.xlsx")
                .withTemplate("/Users/yuanzhushou/Downloads/Duck_Muban.xlsx")
                .sheet()
                .doFill(data);
    }
}
