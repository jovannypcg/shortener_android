package mx.jovannypcg.shortener.home;

import android.view.View;

import mx.jovannypcg.shortener.BuildConfig;
import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.rest.Api;
import mx.jovannypcg.shortener.rest.ApiClient;
import mx.jovannypcg.shortener.rest.model.ApiShortLink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        homeView.setShorterLinkLayoutVisibility(View.INVISIBLE);

        Call<ApiShortLink> createShortLinkCall = api.createShortLink(request);
        createShortLinkCall.enqueue(new Callback<ApiShortLink>() {
            @Override
            public void onResponse(Call<ApiShortLink> call, Response<ApiShortLink> response) {
                switch (response.code()) {
                    case 200:
                        homeView.setShorterLinkLayoutVisibility(View.VISIBLE);
                        homeView.setShorterLink(getFullShortLink(response.body().getSlug()));
                        break;
                    default:
                        onFailure(call, new Throwable());
                }

                homeView.dismissProgress();
            }

            @Override
            public void onFailure(Call<ApiShortLink> call, Throwable t) {
                homeView.showMessage(homeView.getResources().getString(R.string.something_went_wrong));
                homeView.dismissProgress();
            }
        });
    }

    private String getFullShortLink(String slug) {
        return BuildConfig.API_HOST.concat(slug);
    }
}
