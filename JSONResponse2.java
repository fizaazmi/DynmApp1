package com.example.hp.dynmapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hp on 21-06-2017.
 */

public class JSONResponse2 {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    class Data {
        @SerializedName("goals")
        private List<AndroidVer> goals;

        public List<AndroidVer> getGoals() {
            return goals;
        }

    }
}
/*
public class JSONResponse2 {
    @SerializedName("data")
    private JSONResponse.Data data;

    public JSONResponse.Data getData() {
        return data;
    }

    class Data {
        @SerializedName("goals")
        private List<AndroidVer> goals;

        public List<AndroidVer> getGoals() {
            return goals;
        }

    }
}*/
