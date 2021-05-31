package com.example.adviseractivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.http.GET;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WeatherAlarm#newInstance} factory method to
 * create an instance of this fragment.
 */

class Pos{
    int xPos;
    int yPos;
}

public class WeatherAlarm extends Fragment {

    //변수선언


    //행정구역 격자 좌표 찾기
    private Pos findXY (String addr){
        Pos temp= new Pos();
        switch(addr){
            case"중구":{temp.xPos = 97; temp.yPos = 74; break;}
            case"서구":{temp.xPos = 97; temp.yPos = 74; break;}
            case"동구":{temp.xPos = 98; temp.yPos = 75; break;}
            case"영도구":{temp.xPos = 98; temp.yPos = 74; break;}
            case"부산진구":{temp.xPos = 97; temp.yPos = 75; break;}
            case"동래구":{temp.xPos = 98; temp.yPos = 76; break;}
            case"남구":{temp.xPos = 98; temp.yPos = 75; break;}
            case"북구":{temp.xPos = 96; temp.yPos = 76; break;}
            case"해운대구":{temp.xPos = 99; temp.yPos = 75; break;}
            case"사하구":{temp.xPos = 96; temp.yPos = 74; break;}
            case"금정구":{temp.xPos = 98; temp.yPos = 77; break;}
            case"강서구":{temp.xPos = 96; temp.yPos = 76; break;}
            case"연제구":{temp.xPos = 98; temp.yPos = 76; break;}
            case"수영구":{temp.xPos = 99; temp.yPos = 75; break;}
            case"사상구":{temp.xPos = 96; temp.yPos = 75; break;}
            case"기장군":{temp.xPos = 100; temp.yPos = 77; break;}
        }
        return temp;
    }


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WeatherAlarm() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WeatherAlarm.
     */
    // TODO: Rename and change types and number of parameters
    public static WeatherAlarm newInstance(String param1, String param2) {
        WeatherAlarm fragment = new WeatherAlarm();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        //API에서 JSON 정보 받아오기
        /*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apis.data.go.kr/1360000/VilageFcstInfoService/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherInterface weatherInterface = retrofit.create(WeatherInterface.class);

        weatherInterface.getWeatherData(1,10,"JSON","20210531","0200",98,76).enqueue(new Callback<WeatherData>() {
            @Override
            public void onResponse(Call<WeatherData> call, Response<WeatherData> response) {
                if(response.isSuccessful()){
                    Log.d("api", response.body().toString());
                    Log.d("api",response.body().response.body.items.item.toString());
                    Log.d("api",response.body().response.body.items.item.get(0).category);
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d("api fail",t.getMessage());
            }
        });
        */


        return inflater.inflate(R.layout.fragment_weather_alarm, container, false);
    }


}