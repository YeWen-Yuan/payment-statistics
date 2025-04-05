package show.ywy.wechat;

import cn.hutool.core.date.DateUtil;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;
import show.ywy.template.AccountingData;

import java.util.Date;

@Data
public class WeChatPayAccounting {
    @ExcelProperty(value = "交易时间", index = 0)
    private Date tradeTime;

    @ExcelProperty(value = "交易类型", index = 1)
    private String tradeType;

    @ExcelProperty(value = "交易对方", index = 2)
    private String tradingPartner;

    @ExcelProperty(value = "商品", index = 3)
    private String commodity;

    @ExcelProperty(value = "收/支", index = 4)
    private String incomeOrExpense;

    @ExcelProperty(value = "金额(元)", index = 5)
    private String amount;

    @ExcelProperty(value = "支付方式", index = 6)
    private String paymentMethod;

    @ExcelProperty(value = "当前状态", index = 7)
    private String currentStatus;

    @ExcelProperty(value = "交易单号", index = 8)
    private String tradeOrderNumber;

    @ExcelProperty(value = "商户单号", index = 9)
    private String merchantOrderNumber;

    @ExcelProperty(value = "备注", index = 10)
    private String remarks;

    public AccountingData toAccountingData() {
        AccountingData accountingData = new AccountingData();
        accountingData.setAccountingDate(DateUtil.formatDate(tradeTime));
        accountingData.setAccountingTime(DateUtil.formatTime(tradeTime));
        accountingData.setCategory(tradeType);
        accountingData.setAccountingType(incomeOrExpense);
        accountingData.setAmount(Double.valueOf(amount.replaceAll("¥","")));
        accountingData.setRemarks(tradingPartner + commodity);
        return accountingData;
    }
}    
