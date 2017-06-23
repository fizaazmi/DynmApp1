package com.example.hp.dynmapp;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by hp on 19-06-2017.
 */

public interface Client {

    @GET("api/v5/jee-main/practice/")
    Call<JSONResponse1> getJSON1();

    @GET("api/v5/jee-main/practice/{subject}/")
        Call<JSONResponse> getJSON(@Path("subject")String subject);

    //@GET("api/v5/jee-main/practice/physics/units-and-dimensions/")
    @GET("api/v5/jee-main/practice/{subject}/{chapter}/")
    Call<JSONResponse2> getJSON2(@Path("subject")String subject,@Path("chapter")String chapter);


    }

