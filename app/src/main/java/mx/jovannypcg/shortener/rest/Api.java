package mx.jovannypcg.shortener.rest;

import java.util.List;

import mx.jovannypcg.shortener.rest.model.ApiShortLink;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {
    @POST("v1/shortlinks")
    Call<ApiShortLink> createShortLink(@Body ApiShortLink request);
    @GET("v1/shortlinks")
    Call<List<ApiShortLink>> getShortLinks();
    @GET("{slug}")
    Call<ApiShortLink> getDestination(@Path("slug") String slug);
}
