package show.ywy;

import show.ywy.reader.ExcelAdapter;
import show.ywy.writer.ExcelWriterAdapter;
import show.ywy.writer.impl.DuckExcelWriterAdapter;

import java.util.List;

/**
 * @author yzs
 */
public class ReadFromExcel {
    public static void readAndWriteToExcel(ExcelWriterAdapter excelWriterAdapter, ExcelAdapter... excelReadAdapter) {
        List<Object> collect = excelWriterAdapter.getCollection();
        for (ExcelAdapter excelAdapter : excelReadAdapter) {
            collect.addAll(excelAdapter.read());
        }
        excelWriterAdapter.write();
    }
}
