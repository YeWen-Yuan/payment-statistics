package show.ywy;

import cn.hutool.json.JSONUtil;
import cn.idev.excel.EasyExcel;
import org.apache.commons.io.input.ReaderInputStream;
import org.junit.Test;
import show.ywy.alipay.AliPayAccounting;
import show.ywy.wechat.WechatPayReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author yzs
 */
public class AlibabaTest {

    private final static String pathname = "/Users/yuanzhushou/Desktop/alipay_record_20250324_1708_1.csv";

    @Test
    public void test9() throws IOException {
        ArrayList<HashMap<String, Object>> cachedDataList = new ArrayList<>();

        // 指定编码读取文档
        InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "GBK");
        InputStream newInputStream = ReaderInputStream.builder().setCharset("UTF-8").setReader(reader).get();
        EasyExcel.read(newInputStream, new MapReader(cachedDataList)).doReadAll();

        for (HashMap<String, Object> stringObjectHashMap : cachedDataList) {
            System.out.println(JSONUtil.toJsonPrettyStr(stringObjectHashMap));
        }
    }


    @Test
    public void test8() throws IOException {

        // 指定编码读取文档
        InputStreamReader reader = new InputStreamReader(new FileInputStream(pathname), "GBK");
        InputStream newInputStream = ReaderInputStream.builder().setCharset("UTF-8").setReader(reader).get();
        List<AliPayAccounting> cachedDataList = new ArrayList<>();
        EasyExcel.read(newInputStream, AliPayAccounting.class, new WechatPayReader(cachedDataList))
                .headRowNumber(5).numRows(21).doReadAll();
        for (AliPayAccounting aliPayAccounting : cachedDataList) {
            System.out.println(JSONUtil.toJsonPrettyStr(aliPayAccounting));
        }
    }
}
