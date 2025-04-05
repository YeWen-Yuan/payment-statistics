package show.ywy.template;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class AccountingData {

    @ExcelProperty("记账日期")
    private String accountingDate;

    @ExcelProperty("记账时间（可不填）")
    private String accountingTime;

    @ExcelProperty("分类（转账无需填写分类）")
    private String category;

    @ExcelProperty("记账类型")
    private String accountingType;

    @ExcelProperty("金额（勿填正负号、0）")
    private Double amount;

    @ExcelProperty("流出账户")
    private String outflowAccount;

    @ExcelProperty("流入账户")
    private String inflowAccount;

    @ExcelProperty("备注")
    private String remarks;

}
