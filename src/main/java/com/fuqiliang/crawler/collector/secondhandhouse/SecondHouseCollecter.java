package com.fuqiliang.crawler.collector.secondhandhouse;

import com.fuqiliang.crawler.util.Constants;
import com.geccocrawler.gecco.GeccoEngine;
import com.geccocrawler.gecco.request.HttpPostRequest;

public class SecondHouseCollecter {
    public static void main(String... args){
        HttpPostRequest startRequest = new HttpPostRequest(Constants.SECOND_HAND_HOUSE_URL);
        startRequest.setFields(Constants.buildSendHandHousPostFields(4780));
        GeccoEngine.create()
                .classpath("com.fuqiliang.crawler")
                .start(startRequest)
                .thread(5)
                .loop(true)
                .run();
    }
}
