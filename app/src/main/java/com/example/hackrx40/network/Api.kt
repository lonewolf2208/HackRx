package com.example.hackrx40.network

import com.example.hackrx40.model.Scraperdataclass
import com.example.hackrx40.model.SendConnection
import com.example.hackrx40.model.Get_Templates_Data
import com.example.hackrx40.model.campaign_data
import com.example.hackrx40.model.Leads_data_model
import com.example.hackrx40.model.sendCampaign.SendCampaignData
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST


interface Api {

 @GET("/campaigns")
 fun getCampaigns(): Call<campaign_data>

 @GET("/leads")
 fun getLeads():Call<Leads_data_model>

 @GET("/campaign-template")
 fun getTemplates():Call<Get_Templates_Data>

 @POST("/campaigns")
 fun sendCampaigns(@Body data: SendCampaignData):Call<ResponseBody>
 @POST("/scraper/")
 fun senddata(@Body scraperdataclass: Scraperdataclass) : Call<ResponseBody>

 @POST("/connection-request/")
 fun sendConnection(@Body data: SendConnection):Call<ResponseBody>
}