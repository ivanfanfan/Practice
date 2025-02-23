package com.ivan;


import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.read.listener.ReadListener;
import com.alibaba.excel.util.ListUtils;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

//the simplest listener;
@Slf4j
class DemoDataListener implements ReadListener<DemoData> {

    private static  final int BATCH_COUNT = 100;

    private List<DemoData> cacheDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);


    @Override
    public void invoke(DemoData demoData, AnalysisContext analysisContext) {
      log.info("解析到一条数据：{}",demoData.toString());
      cacheDataList.add(demoData);
      if(cacheDataList.size() >= BATCH_COUNT){
          // 消费者消费结果，可以从方法传参数，进行实际消费
          System.out.println(cacheDataList.size());
          // 消费结束 清空cache
          cacheDataList = ListUtils.newArrayListWithExpectedSize(BATCH_COUNT);
      }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        //这里是最后缓存中剩下的数据处理
        System.out.println(cacheDataList.size());
        log.info("数据处理完成");
    }


}

@Data
@ToString
class DemoData {
    private String string;
    private Date date;
    private Double doubleData;
}
