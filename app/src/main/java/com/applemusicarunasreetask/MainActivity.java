package com.applemusicarunasreetask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MusicAdapter musicAdapter;
    private APIInterface apiInterface;
    TextView label;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        label = findViewById(R.id.label);
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(MainActivity.this,1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        getMusicResults();
    }


    public void getMusicResults(){
        apiInterface = ApiClient.getClient().create(APIInterface.class);
        /**
         GET List Resources
         **/
        Call<MusicResponse> call = apiInterface.doGetListResources();
        call.enqueue(new Callback<MusicResponse>() {
            @Override
            public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response) {
                Log.d("TAG",response.code()+"");

                MusicResponse resource = response.body();
                List<MusicResponse.Feed.MusicDetails> musicDetailsList = resource.getFeed().getResults();
                String updatedDate = resource.getFeed().getUpdated();
                    String dateText = updatedDate.split("T")[0];
                label.setText("Apple New Music Release for "+getFormattedDate(dateText));
                musicAdapter = new MusicAdapter(MainActivity.this, musicDetailsList);
                recyclerView.setAdapter(musicAdapter);
            }

            @Override
            public void onFailure(Call<MusicResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }


    private String getFormattedDate(String dateText){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = fmt.parse(dateText);
            SimpleDateFormat fmtOut = new SimpleDateFormat("MM/dd/yyyy");
            return fmtOut.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
       return null;

    }
}
