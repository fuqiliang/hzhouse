package com.fuqiliang.crawler.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static String SECOND_HAND_HOUSE_URL = "http://jjhygl.hzfc.gov.cn/webty/WebFyAction_getGpxxSelectList.jspx";

    public static Map<String, String> buildSendHandHousPostFields(int page){
        Map<String, String> fields = new HashMap<>();
        fields.put("signid","ff80808166484c980166486b4e0b0023");
        fields.put("threshold","ff80808166484c980166486b4e0b0021");
        fields.put("salt","ff80808166484c980166486b4e0b0022");
        fields.put("nonce","0");
        fields.put("hash","0448c9b2298cc81d7e0b7a2ab77fcd9261f956537b0939664985b08a1bc4ce20");
        fields.put("page", "" + page);

        return fields;
    }
}
