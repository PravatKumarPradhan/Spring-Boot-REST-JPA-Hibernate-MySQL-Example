package com.payment.parser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.payment.bean.PaymentReceivedBean;
import com.payment.constant.Constant;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author mustafa
 */
public class ExcelParser {

    static Logger log = Logger.getLogger(ExcelParser.class);

    public static PaymentReceivedBean paymentProcess(Row row) {
        PaymentReceivedBean paymentReceivedBean = new PaymentReceivedBean();
        try {
            Cell cell = row.getCell(Constant.CUSTOMER_NO_COL);
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                if (cell.getStringCellValue().isEmpty()) {
                    return null;
                } else if (cell.getStringCellValue() == null) {
                    return null;
                }
                paymentReceivedBean.setCustomerId(StringUtils.deleteWhitespace(cell.getStringCellValue()));
            } else {
                paymentReceivedBean.setCustomerId(StringUtils.deleteWhitespace(String.valueOf(cell.getNumericCellValue())));
            }
            if (paymentReceivedBean.getCustomerId().isEmpty() || paymentReceivedBean.getCustomerId() == null) {
                return null;
            }
            //Manufacture Data Excel Colum Name B(java reading posstion 1)

            cell = row.getCell(Constant.CUSTOMER_BILL_PAY_DATE_COL);

            if (DateUtil.isCellDateFormatted(row.getCell(Constant.CUSTOMER_BILL_PAY_DATE_COL))) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
                String cellValue = sdf.format(cell.getDateCellValue());
                paymentReceivedBean.setCustomerBillingDate(cell.getDateCellValue());
            }

            if (paymentReceivedBean.getCustomerBillingDate() == null) {
                return null;
            }

            cell = row.getCell(Constant.CUSTOMER_BILL_PAY_AMOUNT);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
              if (cell.getNumericCellValue() == 0) {
                    return null;
                }
                paymentReceivedBean.setPayAmount(BigDecimal.valueOf(cell.getNumericCellValue()));
            }
            if (paymentReceivedBean.getPayAmount() == null) {
                return null;
            }

        } catch (Exception e) {
            log.info("excel Process problem::" + e);
            return null;
        }

        return paymentReceivedBean;
    }

}
