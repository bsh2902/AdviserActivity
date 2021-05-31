package com.example.adviseractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    //static String APIKEY = "HEyK4no6dIj6pEs6Qw3Q%2FXnwiyH8MNJcMtcNplODjukvU1f8xdPMo7K2pVcATuJgx1%2BhD8aPCUofv617XqtqOw%3D%3D";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                    Log.d("api Data", response.body().response.body.toString());
                    //Log.d("api",response.body().response.body.items.item.toString());
                    //Log.d("api",response.body().response.body.items.item.get(0).category);
                    TextView weatherInfo1TextView = (TextView)findViewById(R.id.weather_info1);
                    weatherInfo1TextView.setText("connected");
                }
            }

            @Override
            public void onFailure(Call<WeatherData> call, Throwable t) {
                Log.d("api fail",t.getMessage());
            }
        });

    }
}