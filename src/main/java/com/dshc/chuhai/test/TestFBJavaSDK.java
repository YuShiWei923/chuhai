package com.dshc.chuhai.test;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.Campaign;

import java.util.Arrays;

public class TestFBJavaSDK {
    private static String accesstoken = "EAAKpzJnM2LoBANIYnv2ZAIVFbqQ7prZAZBMUy3siWVfKZC39XdMbqIuIKXfTdXztuzNwcgGpssy0YZCYjxbnsUbQvTQzOHdR2ZCvcOQnqycKnN8yGrssOgb8ZAcQxvYb7HsMxReeciju0GM6PpKmAdLWgnAzwysKBHCId9Kbmk8C45p89TU6zgsOM5OBVUHCvRvurIx7XOl6OzWyVeFKgw3ICJQBKNnowtxPSaLXfAncoZBo2DgDLmSEJCMam1ndjAAZD";

    private static String appsecret = "ccc29740c3b7767b7d17741f60dc4ade";


    public static final APIContext context = new APIContext(
            accesstoken,
            appsecret
    ).enableDebug(true);

    //public static final APIContext context = new APIContext(accesstoken).enableDebug(true);

    public static void main(String[] args)
    {
        AdAccount account = new AdAccount("2474347719357584", context);
        try {
            APINodeList<Campaign> camps = account.getCampaigns().requestAllFields().execute();
            if( camps == null ){
                System.out.println("APIRequestGetCampaigns is null");
            }
            APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
            for(Campaign campaign : campaigns) {
                System.out.println(campaign.getFieldName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




