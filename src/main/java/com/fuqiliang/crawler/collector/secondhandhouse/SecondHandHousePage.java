package com.fuqiliang.crawler.collector.secondhandhouse;

import com.alibaba.fastjson.JSONObject;
import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.JSONPath;
import com.geccocrawler.gecco.annotation.Request;
import com.geccocrawler.gecco.request.HttpRequest;
import com.geccocrawler.gecco.spider.JsonBean;
import org.jsoup.helper.StringUtil;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Gecco(matchUrl="http://jjhygl.hzfc.gov.cn/webty/WebFyAction_getGpxxSelectList.jspx",
        pipelines="secondHouseListPipeline", timeout=30000)
public class SecondHandHousePage implements JsonBean {
    @Request
    private HttpRequest request;

    @JSONPath("$.list")
    private List<JSONObject> houseList;

    @JSONPath("$.pageinfo")
    private String pageInfo;

    public List<JSONObject> getHouseList() {
        return houseList;
    }

    public void setHouseList(List<JSONObject> houseList) {
        this.houseList = houseList;
    }

    public String getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(String pageInfo) {
        this.pageInfo = pageInfo;
    }

    public HttpRequest getRequest() {
        return request;
    }

    public void setRequest(HttpRequest request) {
        this.request = request;
    }

    public int getTotalPageCount() {
        if (pageInfo == null || pageInfo.isEmpty()) {
            return 0;
        }

        int totalPage = 1;
        Pattern pattern = Pattern.compile("(?<=doPage\\()[^\\)]+");
        Matcher matcher = pattern.matcher(pageInfo);
        while(matcher.find()){
            String match = matcher.group();
            if (StringUtil.isNumeric(match)){
                totalPage = Math.max(totalPage, Integer.parseInt(match));
            }
        }

        return totalPage;

    }

    @Override
    public String toString() {
        return "SecondHandHouse{" +
                "houseList=" + houseList +
                ", pageInfo='" + pageInfo + '\'' +
                '}';
    }
}
