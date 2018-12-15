package com.fuqiliang.crawler.collector.transcation;

import com.geccocrawler.gecco.GeccoEngine;

public class SoldOutCollector {
    public static void main(String... args){

        GeccoEngine engine = GeccoEngine.create()
                .classpath("com.fuqiliang.crawler")
                .start("https://hz.lianjia.com/chengjiao/pg/1/")
                .thread(5)
                .loop(false);

        for (int i = 1 ; i <= 3; i++) {
            engine.start("https://hz.lianjia.com/chengjiao/pg" + i +  "/");
        }

        engine.run();
    }
}
