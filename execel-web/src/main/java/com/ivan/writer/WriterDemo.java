package com.ivan.writer;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import lombok.Data;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * @author Wang yifan
 */

//@SpringBootTest
public class WriterDemo {
    public List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }

    @Test
    public void testWrite() {
        String absolutePath = "D:\\ivan-project\\Practice\\execel-web\\src\\main\\java\\com\\ivan\\writer";

        String fileName =  absolutePath + "simpleWriteTest1" + System.currentTimeMillis() + ".xlsx";
        EasyExcel.write(fileName, DemoData.class).sheet("sheet参数").doWrite(data());
    }

    @Test
    public void testWrite2() {
        String absolutePath = "D:\\ivan-project\\Practice\\execel-web\\src\\main\\java\\com\\ivan\\writer";
        String fileName =  absolutePath + "simpleWriteTest2" + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
        excelWriter.write(data(), writeSheet);
        excelWriter.finish();
    }
//    @GetMapping("download")
    public void download(HttpServletResponse response) throws IOException {
        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());
    }

    /*
    根据参数只导出指定列
     */
    @Test
    public void excludeOrIncludeWrite() {
        String absolutePath = "D:\\ivan-project\\Practice\\execel-web\\src\\main\\java\\com\\ivan\\writer";
        String fileName = absolutePath + "excludeOrIncludeWrite " + System.currentTimeMillis() + ".xlsx";

        Set<String> excludeColumnFiledNames = Set.of("date");
//sheet 1.
        EasyExcel.write(fileName,DemoData.class)
                .excludeColumnFiledNames(excludeColumnFiledNames)
                .sheet("排除")
                .doWrite(data());

//sheet 2 include
        EasyExcel.write(fileName,DemoData.class)
                .includeColumnFiledNames(Set.of("date"))
                .sheet("包括")
                .doWrite(data());

    }

}



























