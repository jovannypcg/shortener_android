package mx.jovannypcg.shortener.home;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;

import mx.jovannypcg.shortener.BuildConfig;
import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.rest.Api;
import mx.jovannypcg.shortener.rest.ApiClient;
import mx.jovannypcg.shortener.rest.model.ApiShortLink;
import mx.jovannypcg.shortener.util.URL;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Contains the logic to deal with short links in HomeActivity.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public class HomePresenterImpl implements HomePresenter {
    private HomeView homeView;
    private Api api;

    public HomePresenterImpl(HomeView homeView) {
        this.homeView = homeView;

        api = ApiClient.getClient().create(Api.class);
    }

    @Override
    public void submitShorten() {
        if (!URL.isValid(homeView.getDestination())) {
            homeView.showDestinationError(homeView.getResources().getString(R.string.enter_a_valid_url));
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

    @Override
    public void copyShortLinkToClipboard() {
        ClipboardManager clipboard =
                (ClipboardManager) homeView.getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clip = ClipData.newPlainText("Copied Text", homeView.getShortLink());
        clipboard.setPrimaryClip(clip);

        homeView.showMessage(homeView.getResources().getString(R.string.copied_to_clipboard));
    }

    /**
     * Gets the full shorter link based on the API URL and the slug sent
     * as argument.
     *
     * @param slug Slug for the full link.
     * @return Full shorter link.
     */
    private String getFullShortLink(String slug) {
        return BuildConfig.API_HOST.concat(slug);
    }
}
