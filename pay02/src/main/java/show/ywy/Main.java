package show.ywy;

import show.ywy.reader.impl.AlipayExcelAdapter;
import show.ywy.reader.impl.WeChatExcelAdapter;
import show.ywy.writer.impl.DuckExcelWriterAdapter;

public class Main {

    public static void main(String[] args) {
        ReadFromExcel.readAndWriteToExcel(
                new DuckExcelWriterAdapter(""),
                new AlipayExcelAdapter(""),
                new WeChatExcelAdapter("","")
        );
    }
}
