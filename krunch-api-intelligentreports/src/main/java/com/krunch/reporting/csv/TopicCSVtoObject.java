package com.krunch.reporting.csv;

import com.krunch.reporting.excel.vo.TopicRankVO;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class TopicCSVtoObject {

    public static void main(String[] args) throws IOException {

        String fileName = "microservices_2021-05-19.csv";

        List<TopicRankVO> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(TopicRankVO.class)
                .build()
                .parse();

        beans.forEach(System.out::println);

    }

}
