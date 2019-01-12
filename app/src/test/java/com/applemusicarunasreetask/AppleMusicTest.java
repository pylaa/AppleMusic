package com.applemusicarunasreetask;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class AppleMusicTest {

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    Retrofit retrofit;

    @Mock
    Call<MusicResponse> musicResponseCall;

    @Mock
    MusicResponse musicResponse;

    @Test
    public void testMusicService(){

        when(retrofit.create(APIInterface.class).doGetListResources()).thenReturn(Matchers.any(Call.class));

        assertNotEquals(musicResponse,null);

    }
}
