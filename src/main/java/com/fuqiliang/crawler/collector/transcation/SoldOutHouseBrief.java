package com.fuqiliang.crawler.collector.transcation;

import com.geccocrawler.gecco.annotation.Href;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.spider.HtmlBean;

public class SoldOutHouseBrief implements HtmlBean {

    @Href(click = true)
    @HtmlField(cssPath=".title > a")
    private String briefInfo;

    public String getBriefInfo() {
        return briefInfo;
    }

    public void setBriefInfo(String briefInfo) {
        this.briefInfo = briefInfo;
    }
}
