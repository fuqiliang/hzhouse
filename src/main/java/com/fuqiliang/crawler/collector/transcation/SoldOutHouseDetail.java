package com.fuqiliang.crawler.collector.transcation;

import com.geccocrawler.gecco.annotation.HtmlField;
import com.geccocrawler.gecco.annotation.Text;
import com.geccocrawler.gecco.spider.HtmlBean;

public class SoldOutHouseDetail implements HtmlBean {
    @Text
    @HtmlField(cssPath = "li:nth-child(1)")
    private String layout;

    @Text
    @HtmlField(cssPath = "li:nth-child(2)")
    private String floor;

    @Text
    @HtmlField(cssPath = "li:nth-child(3)")
    private String square;

    @Text
    @HtmlField(cssPath = "li:nth-child(4)")
    private String structure;

    @Text
    @HtmlField(cssPath = "li:nth-child(7)")
    private String direction;

    @Text
    @HtmlField(cssPath = "li:nth-child(8)")
    private String age;

    @Text
    @HtmlField(cssPath = "li:nth-child(9)")
    private String fixture;

    @Text
    @HtmlField(cssPath = "li:nth-child(12)")
    private String elevator;

    @Text
    @HtmlField(cssPath = "li:nth-child(13)")
    private String usageYear;

    @Text
    @HtmlField(cssPath = "li:nth-child(14)")
    private String hasElevator;

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getFixture() {
        return fixture;
    }

    public void setFixture(String fixture) {
        this.fixture = fixture;
    }

    public String getElevator() {
        return elevator;
    }

    public void setElevator(String elevator) {
        this.elevator = elevator;
    }

    public String getUsageYear() {
        return usageYear;
    }

    public void setUsageYear(String usageYear) {
        this.usageYear = usageYear;
    }

    public String getHasElevator() {
        return hasElevator;
    }

    public void setHasElevator(String hasElevator) {
        this.hasElevator = hasElevator;
    }

    @Override
    public String toString() {
        return "SoldOutHouseDetail{" +
                "layout='" + layout + '\'' +
                ", floor='" + floor + '\'' +
                ", square='" + square + '\'' +
                ", structure='" + structure + '\'' +
                ", direction='" + direction + '\'' +
                ", age='" + age + '\'' +
                ", fixture='" + fixture + '\'' +
                ", elevator='" + elevator + '\'' +
                ", usageYear='" + usageYear + '\'' +
                ", hasElevator='" + hasElevator + '\'' +
                '}';
    }
}
