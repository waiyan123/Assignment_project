package com.tunity.assignment.data.network.retrofit.response;

import com.google.gson.annotations.SerializedName;
import com.tunity.assignment.data.network.retrofit.util.NetworkConstants;

public class SourceNetwork {

    @SerializedName(NetworkConstants.ID)
    public String id;
    @SerializedName(NetworkConstants.NAME)
    public String name;

    public SourceNetwork(String id, String name) {
        this.id = id;
        this.name = name;
    }
}