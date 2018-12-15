package com.fuqiliang.crawler.collector.transcation;

import com.fuqiliang.crawler.store.mysql.Dao;
import com.fuqiliang.crawler.util.Util;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@PipelineName("soldOutHousePipeline")
public class SoldOutHousePipeline implements Pipeline<SoldOutHouse> {
    private static final String DATEFORMATTER = "yyyy.MM.dd";
    private static Logger logger = LoggerFactory.getLogger(SoldOutHousePipeline.class);

    @Override
    public void process(SoldOutHouse bean) {

//        Boolean isPollForNew = Boolean.valueOf(System.getProperty("pollForNew", "true"));
//        if (isPollForNew) {
//            LocalDate today = LocalDate.now();
//            LocalDate updateDay = Util.format(DATEFORMATTER, bean.getSoldOutDate());
//            if (updateDay.isAfter(today.minusDays(1))) {
//                insert(bean);
//            }
//        } else {
//            insert(bean);
//        }

        insert(bean);

        logger.info("insert soldOutHouse[" + bean.getId() + "] ");
    }

    private void insert(SoldOutHouse soldOutHouse){
        try {
            Dao.insertSoldOutHouse(soldOutHouse);
        } catch (SQLException e) {
            logger.error("insert soldOutHouse[" + soldOutHouse.getId() + "] failed", e);
        }
    }
}
