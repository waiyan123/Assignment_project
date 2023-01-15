package com.tunity.assignment.data.network.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;

public class SourceNetwork {

    @SerializedName(NetworkConstants.ID)
    public String id;
    @SerializedName(NetworkConstants.NAME)
    public String name;

    public SourceNetwork(String id, String name) {
        if(id!=null) this.id = id;
        else this.id = "0";
        if(name!=null) this.name = name;
        else this.name = "Unknown";
    }
}