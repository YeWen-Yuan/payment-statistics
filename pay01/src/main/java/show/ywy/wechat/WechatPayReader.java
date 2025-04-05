package show.ywy.wechat;

import cn.hutool.core.lang.Console;
import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.event.AnalysisEventListener;

import java.util.List;

/**
 * @author yzs
 */
public class WechatPayReader extends AnalysisEventListener<WechatPayAccounting> {
    private static final int BATCH_COUNT = 25;

    public WechatPayReader(List<WechatPayAccounting> cachedDataList) {
        this.cachedDataList = cachedDataList;
    }

    private final List<WechatPayAccounting> cachedDataList;

    @Override
    public void invoke(WechatPayAccounting data, AnalysisContext analysisContext) {
        cachedDataList.add(data);
        if (cachedDataList.size() >= BATCH_COUNT) {
            saveData();
            cachedDataList.clear();
        }
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
