package hc.util.excel.demo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @Author: hc
 * @CreateTime: 2023-07-27  10:42
 * @Description: 复杂头数据.这里最终效果是第一行就一个主标题，第二行分类
 **/
@Data
public class ComplexHeadData {
    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;
}
