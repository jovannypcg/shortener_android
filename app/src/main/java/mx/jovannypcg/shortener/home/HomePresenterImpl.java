package mx.jovannypcg.shortener.home;

import android.util.Log;
import android.view.View;

import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.rest.Api;
import mx.jovannypcg.shortener.rest.ApiClient;
import mx.jovannypcg.shortener.rest.model.ApiShortLink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class HomePresenterImpl implements HomePresenter {
    private HomeView homeView;
    private Api api;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;

        api = ApiClient.getClient().create(Api.class);
    }

    @Override
    public void submitShorten() {
        if (homeView.getDestination().isEmpty()) {
            homeView.showDestinationEmptyError();
            return;
        }

        ApiShortLink request = new ApiShortLink();
        request.setDestination(homeView.getDestination());

        homeView.showProgress();
        Call<ApiShortLink> createShortLinkCall = api.createShortLink(request);
        createShortLinkCall.enqueue(new Callback<ApiShortLink>() {
            @Override
            public void onResponse(Call<ApiShortLink> call, Response<ApiShortLink> response) {
                Log.i("***** ", response.body().toString());

                switch (response.code()) {
                    case 200:
                        Log.i("***** ", response.body().toString());

                        homeView.setShorterLinkLayoutVisibility(View.VISIBLE);
                        homeView.setShorterLink(response.body().getSlug());

                        break;
                    default:
                        onFailure(call, new Throwable());
                }
            }

            @Override
            public void onFailure(Call<ApiShortLink> call, Throwable t) {
                Log.i("=====", t.toString());
                homeView.getResources().getString(R.string.something_went_wrong);
                homeView.dismissProgress();
            }
        });
    }
}
