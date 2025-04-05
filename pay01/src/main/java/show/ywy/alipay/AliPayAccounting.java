package show.ywy.alipay;

import cn.hutool.core.date.DateUtil;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;
import show.ywy.template.AccountingData;

import java.util.Date;

@Data
public class AliPayAccounting {
    @ExcelProperty(value = "交易号", index = 0)
    private String transactionNumber;

    @ExcelProperty(value = "商家订单号", index = 1)
    private String merchantOrderNumber;

    @ExcelProperty(value = "交易创建时间", index = 2)
    private Date transactionCreationTime;

    @ExcelProperty(value = "付款时间", index = 3)
    private Date paymentTime;

    @ExcelProperty(value = "最近修改时间", index = 4)
    private Date lastModifiedTime;

    @ExcelProperty(value = "交易来源地", index = 5)
    private String transactionSource;

    @ExcelProperty(value = "类型", index = 6)
    private String type;

    @ExcelProperty(value = "交易对方", index = 7)
    private String tradingPartner;

    @ExcelProperty(value = "商品名称", index = 8)
    private String productName;

    @ExcelProperty(value = "金额（元）", index = 9)
    private Double amount;

    @ExcelProperty(value = "收/支", index = 10)
    private String incomeOrExpense;

    @ExcelProperty(value = "交易状态", index = 11)
    private String transactionStatus;

    @ExcelProperty(value = "服务费（元）", index = 12)
    private Double serviceFee;

    @ExcelProperty(value = "成功退款（元）", index = 13)
    private Double successfulRefund;

    @ExcelProperty(value = "备注", index = 14)
    private String remarks;

    @ExcelProperty(value = "资金状态", index = 15)
    private String fundStatus;


    public AccountingData toAccountingData() {
        AccountingData accountingData = new AccountingData();
        accountingData.setAccountingDate(DateUtil.formatDate(transactionCreationTime));
        accountingData.setAccountingTime(DateUtil.formatTime(transactionCreationTime));
        accountingData.setCategory(tradingPartner);
        accountingData.setAccountingType(incomeOrExpense);
        accountingData.setAmount(amount);
        accountingData.setRemarks(productName);
        return accountingData;
    }
}    
