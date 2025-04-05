package show.ywy;

import cn.hutool.core.lang.Console;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;

import java.util.HashMap;
import java.util.List;

/**
 * @author yzs
 */
public class MapReader extends AnalysisEventListener<HashMap<String,Object>> {
    private static final int BATCH_COUNT = 25;

    public MapReader(List<HashMap<String,Object>> cachedDataList) {
        this.cachedDataList = cachedDataList;
    }

    private final List<HashMap<String,Object>> cachedDataList;

    @Override
    public void invoke(HashMap<String,Object> data, AnalysisContext analysisContext) {
        cachedDataList.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        // 确保全部数据被处理
        saveData();
    }


    private void saveData() {
        // 实际业务处理逻辑
        Console.log("存储 {} 条数据", cachedDataList.size());
    }

}
