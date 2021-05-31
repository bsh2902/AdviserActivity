package com.example.adviseractivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;



public interface WeatherInterface {


    @GET("getVilageFcst/")
    Call<WeatherData> getWeatherData(
            //@Query("serviceKey") String service_key,
            @Query("pageNo") int page_no,
            @Query("numOfRows") int num_of_rows,
            @Query("dataType") String data_type,
            @Query("base_data") String base_data,
            @Query("base_time") String base_time,
            @Query("nx") int nx,
            @Query("ny") int ny
    );
}

class WeatherData{
    RESPONSE response;
}

class RESPONSE{
    HEADER header;
    BODY body;
}

class HEADER{
    int resultCode;
    String resultMsg;
}

class BODY{
    String dataType;
    ITEMS items;
}

class ITEMS{
    List<ITEM> item;
}

class ITEM{
    String category;
    int fcstValue;
}
