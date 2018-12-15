package com.fuqiliang.crawler.collector.secondhandhouse;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

/**
 * "accountid": 0,
 * 		"accountname": "",
 * 		"cjsj": "2018-12-04",
 * 		"cqmc": "下沙",
 * 		"cqsj": 0,
 * 		"cyrybh": "",
 * 		"czfs": 0,
 * 		"dqlc": "",
 * 		"fbzt": 1,
 * 		"fczsh": "杭房权证经移字第14867729号",
 * 		"fwtybh": "181204378161",
 * 		"fwyt": 0,
 * 		"fwytValue": "",
 * 		"gisx": "",
 * 		"gisy": "",
 * 		"gpfyid": 2553827,
 * 		"gphytgsj": "",
 * 		"gpid": 94351057,
 * 		"gplxrcode": 0,
 * 		"gplxrdh": "",
 * 		"gplxrxm": "王继虎",
 * 		"gply": 0,
 * 		"gpzt": 3,
 * 		"gpztValue": "挂牌成功",
 * 		"hxs": 0,
 * 		"hxt": 0,
 * 		"hxw": 0,
 * 		"hyid": 0,
 * 		"hyjzsj": "",
 * 		"isnew": 0,
 * 		"jzmj": 89.57,
 * 		"mdmc": "杭州高铭房地产经纪有限公司",
 * 		"qyid": 0,
 * 		"qyzt": 0,
 * 		"scgpshsj": "2018-12-10",
 * 		"sellnum": 0,
 * 		"sqhysj": "",
 * 		"szlc": "",
 * 		"szlcname": "",
 * 		"tygpbh": "25538271670",
 * 		"wtcsjg": 240,
 * 		"wtdqts": 0,
 * 		"wtxybh": "2018120407171056",
 * 		"wtxycode": 0,
 * 		"wtxyid": 0,
 * 		"xqid": 0,
 * 		"xqmc": "宋都·东郡国际",
 * 		"xzqh": 33,
 * 		"xzqhname": "杭州市",
 * 		"zzcs": ""
 */
public class SecondHouse {
    private String postDate; //scgpshsj
    private String division; //cqmc
    private String houseCentificationId; //fczsh
    private String uniqueId; //fwtybh
    private int square; //jzmj
    private String proxy; //mdmc
    private int price; //wtcsjg
    private String houseName; //xqmc
    private String recordId; //gpid

    public SecondHouse(JSONObject json){
        this.setPostDate(json.getString("scgpshsj"));
        this.setDivision(json.getString("cqmc"));
        this.setHouseCentificationId(json.getString("fczsh"));
        this.setUniqueId(json.getString("fwtybh"));
        this.setSquare(json.getIntValue("jzmj"));
        this.setProxy(json.getString("mdmc"));
        this.setPrice(json.getIntValue("wtcsjg"));
        this.setHouseName(json.getString("xqmc"));
        this.setRecordId(json.getString("gpid"));
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getHouseCentificationId() {
        return houseCentificationId;
    }

    public void setHouseCentificationId(String houseCentificationId) {
        this.houseCentificationId = houseCentificationId;
    }

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    public String getProxy() {
        return proxy;
    }

    public void setProxy(String proxy) {
        this.proxy = proxy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Override
    public String toString() {
        return "SecondHouse{" +
                "postDate='" + postDate + '\'' +
                ", division='" + division + '\'' +
                ", houseCentificationId='" + houseCentificationId + '\'' +
                ", uniqueId='" + uniqueId + '\'' +
                ", square=" + square +
                ", proxy='" + proxy + '\'' +
                ", price=" + price +
                ", houseName='" + houseName + '\'' +
                ", recordId='" + recordId + '\'' +
                '}';
    }
}
