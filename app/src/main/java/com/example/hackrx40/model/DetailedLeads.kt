package com.example.hackrx40.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailedLeads(
    val allSkills: String,
    val baseUrl: String,
    val birthday: String,
    val civilityFromDropContact: String,
    val company: String,
    val company2: String,
    val companyUrl: String,
    val companyUrl2: String,
    val companyWebsite: String,
    val connectionDegree: String,
    val connectionsCount: String,
    val connectionsUrl: String,
    val description: String,
    val email: String,
    val endorsement1: String,
    val endorsement2: String,
    val endorsement3: String,
    val endorsement4: String,
    val endorsement5: String,
    val endorsement6: String,
    val firstName: String,
    val fullName: String,
    val headline: String,
    val id: Int,
    val imgUrl: String,
    val jobDateRange: String,
    val jobDateRange2: String,
    val jobDescription: String,
    val jobDescription2: String,
    val jobDuration: String,
    val jobDuration2: String,
    val jobLocation: String,
    val jobLocation2: String,
    val jobTitle: String,
    val jobTitle2: String,
    val lastName: String,
    val linkedinProfile: String,
    val linkedinProfileUrl: String,
    val linkedinSalesNavigatorUrl: String,
    val location: String,
    val mail: String,
    val mailFromDropcontact: String,
    val mutualConnectionsText: String,
    val mutualConnectionsUrl: String,
    val profileId: String,
    val qualificationFromDropContact: String,
    val school: String,
    val school2: String,
    val schoolDateRange: String,
    val schoolDateRange2: String,
    val schoolDegree: String,
    val schoolDegree2: String,
    val schoolDescription: String,
    val schoolUrl: String,
    val schoolUrl2: String,
    val skill1: String,
    val skill2: String,
    val skill3: String,
    val skill4: String,
    val skill5: String,
    val skill6: String,
    val subscribers: String,
    val timestamp: String,
    val twitter: String,
    val twitterProfileUrl: String,
    val userId: String,
    val vmid: String,
    val website: String,
    val websiteFromDropContact: String
):Parcelable