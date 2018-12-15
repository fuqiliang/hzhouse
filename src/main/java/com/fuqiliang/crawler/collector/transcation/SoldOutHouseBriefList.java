package com.fuqiliang.crawler.collector.transcation;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.PipelineName;
import com.geccocrawler.gecco.pipeline.Pipeline;
import com.geccocrawler.gecco.request.HttpGetRequest;
import com.geccocrawler.gecco.scheduler.DeriveSchedulerContext;
import com.geccocrawler.gecco.spider.HtmlBean;

import java.util.List;

@Gecco(matchUrl="https://hz.lianjia.com/chengjiao/pg{page}/",
        pipelines="soldOutBriefListPipeline", timeout=30000)
public class SoldOutHouseBriefList implements HtmlBean {

    @HtmlField(cssPath=".listContent li .info .title")
    private List<SoldOutHouseBrief> soldOutHouseList;

    public List<SoldOutHouseBrief> getSoldOutHouseList() {
        return soldOutHouseList;
    }

    public void setSoldOutHouseList(List<SoldOutHouseBrief> soldOutHouseList) {
        this.soldOutHouseList = soldOutHouseList;
    }
}
