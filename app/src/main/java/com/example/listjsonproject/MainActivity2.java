package com.example.listjsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity2 extends AppCompatActivity {
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = getIntent().getExtras();
        id = bundle.getString("id");
        new GetWeather().execute();
    }

    class GetWeather extends AsyncTask<Void,Void, JSONObject> {


        @Override
        protected JSONObject doInBackground(Void... voids) {
            API api = new API("http://80.254.124.90/weather/?city=" + id); //вставить ссылку 80.254.124.90 + ids
            JSONObject jsonObject = api.getJsonString();
            return jsonObject;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {
            super.onPostExecute(jsonObject);

            try {
                String title = jsonObject.getString("title");
                String temperature = jsonObject.getJSONObject("weather").getString("temperature");
                String description = jsonObject.getJSONObject("weather").getString("weather_type");
                String dampness = jsonObject.getJSONObject("weather").getString("dampness");

                TextView tvTitle = findViewById(R.id.tvTitle);//название станицы
                TextView tvTemp = findViewById(R.id.tvTemp);//температура
                TextView tvDescription = findViewById(R.id.tvDescription);//описание погоды
                TextView tvDampness = findViewById(R.id.tvDampness);//влажность

                tvTitle.setText(title);


                tvTemp.setText("Температура: " + temperature);
                //tvTemp.setText(temperature);

                tvDescription.setText("Тип погоды: " + description);
                //tvDescription.setText(description);


                tvDampness.setText("Влажность: " + dampness);
                //tvDampness.setText(dampness);


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}