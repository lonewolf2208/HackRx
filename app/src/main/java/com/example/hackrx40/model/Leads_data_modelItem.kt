package com.example.hackrx40.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Leads_data_modelItem(
    val company_name: String,
    val company_names: String,
    val company_size: String,
    val email: String,
    val function: String,
    val id: Int,
    val industry: String,
    val institute: String,
    val keywords: String,
    val name: String,
    val state_progress: Int,
    val title: String ,
    val lead_score:String
):Parcelable