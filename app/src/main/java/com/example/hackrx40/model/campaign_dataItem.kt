package com.example.hackrx40.model

import com.example.hackrx40.model.MarketingTemplate

data class campaign_dataItem(
    val duration: String,
    val id: Int,
    val impressions: String,
    val marketing_templates: List<MarketingTemplate>,
    val percentage_change: String,
    val target: Target,
    val total_likes: String
)