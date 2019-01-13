package com.applemusicarunasreetask;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

public interface APIInterface {
    @GET("v1/us/apple-music/new-releases/all/100/explicit.json")
    Call<MusicResponse> doGetListResources();//
}
