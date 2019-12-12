package com.dshc.chuhai.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.lang.reflect.Type;

import com.facebook.ads.sdk.APIContext;
import com.facebook.ads.sdk.APIException;
import com.facebook.ads.sdk.APINodeList;
import com.facebook.ads.sdk.Ad;
import com.facebook.ads.sdk.AdAccount;
import com.facebook.ads.sdk.AdSet;
import com.facebook.ads.sdk.Campaign;
import com.facebook.ads.sdk.Targeting;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GetFBAdDetails {

    public static final String ACCES_TOKEN = "EAAKpzJnM2LoBAEWyp4y8biKtKCevFn0Xro9v5UdcF4ghzH3ayVF6AypYZBZB98oUTc3FZCA9pv3AoA3y9a4d3t20KS1qZCElR078CQxIfJ6DOlsNjIPAU4LkOPzeUz3ZCZC1MaEZCtVozhNvkjZAo6T4Fpdfl5zsML7AoZCmINToK2wFzkP4JR63OiV9uikShs6IZD";
    public static final String APP_SECRET = "ccc29740c3b7767b7d17741f60dc4ade";
    public static final String ACCOUNT_ID = "2474347719357584";

    public static void main(String[] args) {
        APIContext context = new APIContext(ACCES_TOKEN,APP_SECRET).enableDebug(true);;
        AdAccount account = new AdAccount(ACCOUNT_ID, context);
        Gson gson = new Gson();

        try {
            APINodeList<Campaign> campaigns = account.getCampaigns().requestAllFields().execute();
            APINodeList<AdSet> adsets = account.getAdSets().requestAllFields().execute();
            APINodeList<Ad> ads = account.getAds().requestAllFields().execute();

            for (Campaign campaign : campaigns) {
                System.out.println("====================================================================");
                System.out.println("Campaign Id           : " + campaign.getId());
                System.out.println("Campaign Name         : " + campaign.getFieldName());
                System.out.println("Campaign Objective    : " + campaign.getFieldObjective());
                System.out.println("Campaign Time Created : " + campaign.getFieldCreatedTime());
                System.out.println("Buying Type           : " + campaign.getFieldBuyingType());
                System.out.println("Budget Rebalance      : " + campaign.getFieldBudgetRebalanceFlag());
                for (AdSet adset : adsets) {
                    System.out.println("====================================================================");
                    if (campaign.getId().equals(adset.getFieldCampaignId())) {
                        String targeting = adset.getFieldTargeting().toString();
                        System.out.println("Adset Id              : " + adset.getId());
                        System.out.println("Adset Name            : " + adset.getFieldName());
                        System.out.println("Adset Goal            : " + adset.getFieldOptimizationGoal());
                        System.out.println("Adset Time Created    : " + adset.getFieldCreatedTime());
                        System.out.println("Budget Remaining      : Rp." + adset.getFieldBudgetRemaining());
                        System.out.println("Daily Budget          : Rp." + adset.getFieldDailyBudget());
                        System.out.println("Promoted Object : " + adset.getFieldTargeting());
                    }
                    for (Ad ad : ads) {
                        System.out.println("====================================================================");
                        if (campaign.getId().equals(adset.getFieldCampaignId())
                                && adset.getId().equals(ad.getFieldAdsetId())) {
                            System.out.println("Adsnyaaaaaa " + ad.getId());
                            System.out.println("Adsnyaaaaaa " + ad.getFieldName());
                            System.out.println("Adsnyaaaaaa " + ad.getFieldBidInfo());
                        }

                    }
                }
            }
        } catch (APIException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
