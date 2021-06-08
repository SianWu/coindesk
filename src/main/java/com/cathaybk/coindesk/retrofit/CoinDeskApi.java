package com.cathaybk.coindesk.retrofit;

import com.cathaybk.coindesk.entity.CoinDesk;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface CoinDeskApi {
  @GET
  Call<CoinDesk> getdata(@Url String url);
}
