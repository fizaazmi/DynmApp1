package com.example.hp.dynmapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hp on 16-06-2017.
 */

public class JSONResponse {

    @SerializedName("data")
    private Data data;

    public Data getData() {
        return data;
    }

    class Data {
        @SerializedName("chapters")
        private List<AndroidVer> chapters;

        public List<AndroidVer> getAndroid() {
            return chapters;
        }

    }
}


