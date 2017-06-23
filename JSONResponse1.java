package com.example.hp.dynmapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by hp on 19-06-2017.
 */

public class JSONResponse1 {

    @SerializedName("data")
    private Data data;

    public Data getData() {
       return data;
    }

    class Data{
        @SerializedName("subjects")
        private List<AndroidVer> subjects;

        public List<AndroidVer> getAndroid()
        {
            return subjects;
        }

    }
}

