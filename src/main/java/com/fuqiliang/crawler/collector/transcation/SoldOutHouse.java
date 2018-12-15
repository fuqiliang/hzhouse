package com.fuqiliang.crawler.collector.transcation;

import com.geccocrawler.gecco.annotation.Gecco;
import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.RequestParameter;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;


@Gecco(matchUrl="https://hz.lianjia.com/chengjiao/{houseId}",
        pipelines="soldOutHousePipeline", timeout=30000)
public class SoldOutHouse implements HtmlBean {

    @RequestParameter("houseId")
    private String id;

    @Text
    @HtmlField(cssPath = ".house-title div.wrapper")
    private String name;

    @Text
    @HtmlField(cssPath = ".house-title div.wrapper > span")
    private String soldOutDate;

    @Text
    @HtmlField(cssPath = "span.dealTotalPrice > i")
    private String totalPrice;

    @Text
    @HtmlField(cssPath = "div.price > b")
    private String unitPrice;

    @Text
    @HtmlField(cssPath = "div.msg > span:nth-child(1) > label ")
    private String expectedPrice;

    @Text
    @HtmlField(cssPath = "#introduction > div.introContent > div.base > div.content > ul ")
    private SoldOutHouseDetail detail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoldOutDate() {
        return soldOutDate;
    }

    public void setSoldOutDate(String soldOutDate) {
        this.soldOutDate = soldOutDate;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getExpectedPrice() {
        return expectedPrice;
    }

    public void setExpectedPrice(String expectedPrice) {
        this.expectedPrice = expectedPrice;
    }

    public SoldOutHouseDetail getDetail() {
        return detail;
    }

    public void setDetail(SoldOutHouseDetail detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "SoldOutHouse{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", soldOutDate='" + soldOutDate + '\'' +
                ", totalPrice='" + totalPrice + '\'' +
                ", unitPrice='" + unitPrice + '\'' +
                ", expectedPrice='" + expectedPrice + '\'' +
                ", detail=" + detail +
                '}';
    }
}
