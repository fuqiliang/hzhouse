package com.fuqiliang.crawler.collector.secondhandhouse;

import com.alibaba.fastjson.JSONObject;
import com.fuqiliang.crawler.store.mysql.Dao;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpPostRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@PipelineName("secondHouseListPipeline")
public class SecondHandHousePagePipeline implements Pipeline<SecondHandHousePage> {

    private static Logger logger = LoggerFactory.getLogger(SecondHandHousePagePipeline.class);

    @Override
    public void process(SecondHandHousePage bean) {
        int currentPage = Integer.parseInt(
                ((HttpPostRequest)bean.getRequest()).getField("page"));

        int totalPage = bean.getTotalPageCount();
        System.out.println("totalPage:" + totalPage);

        List<JSONObject> houseList = bean.getHouseList();
        List<SecondHouse> secondHousesList = new LinkedList<>();
        for (JSONObject jsonObject : houseList) {
            SecondHouse house = new SecondHouse(jsonObject);
            secondHousesList.add(house);
        }

        try {

            Dao.insertScondHouses(secondHousesList);
//            if (currentPage == 1) {
//                for (int next = currentPage; next <= totalPage; next++) {
//                    HttpPostRequest nextRequest = new HttpPostRequest();
//                    nextRequest.setUrl(bean.getRequest().getUrl());
//                    Map<String, String> fields = ((HttpPostRequest) bean.getRequest()).getFields();
//                    fields.p1ut("page", next + "");
//                    nextRequest.setFields(fields);
//
//                    DeriveSchedulerContext.into(nextRequest);
//                }
//            }

            HttpPostRequest nextRequest = new HttpPostRequest();
            nextRequest.setUrl(bean.getRequest().getUrl());
            Map<String, String> fields = ((HttpPostRequest) bean.getRequest()).getFields();
            fields.put("page", currentPage + 1 + "");
            nextRequest.setFields(fields);

            DeriveSchedulerContext.into(nextRequest);

        } catch (SQLException e) {
            logger.error("insertScondHouses to db failed, stop crawler");
        }

        logger.info("Done for secondHouse page " + currentPage + ", found " + houseList.size() + " records.");

    }

}
