package hc.util.excel.demo;

import java.util.Date;
import java.util.List;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.util.ListUtils;

import hc.util.excel.data.DemoData;
import hc.util.excel.util.TestFileUtil;
import org.junit.jupiter.api.Test;

public class SimpleWrite {


    @Test
    public void simpleWrite() {
        // since: 3.0.0-beta1
        String fileName = TestFileUtil.getPath() + "simpleWrite" + System.currentTimeMillis() + ".xlsx";
        System.out.println(fileName);
        // 这里 需要指定写用哪个class去写，然后写到第一个sheet，名字为模板 然后文件流会自动关闭
        // 如果这里想使用03 则 传入excelType参数即可
        EasyExcel.write(fileName, DemoData.class)
                .sheet("模板")
                .doWrite(() -> {
                    // 分页查询数据
                    return data();
                });
    }


    private List<DemoData> data() {
        List<DemoData> list = ListUtils.newArrayList();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }
}

