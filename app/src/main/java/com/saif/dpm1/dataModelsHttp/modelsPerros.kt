package com.saif.dpm1.dataModelsHttp

import com.google.gson.annotations.SerializedName

data class modelsPerros (@SerializedName("status") var status: String,
                         @SerializedName("message")var images: List<String>
){
}

