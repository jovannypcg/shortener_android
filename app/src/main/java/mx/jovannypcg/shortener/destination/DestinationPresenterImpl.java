package mx.jovannypcg.shortener.destination;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;

import mx.jovannypcg.shortener.BuildConfig;
import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.rest.Api;
import mx.jovannypcg.shortener.rest.ApiClient;
import mx.jovannypcg.shortener.rest.model.ApiShortLink;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Contains the logic to deal with short links in DestinationActivity.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public class DestinationPresenterImpl implements DestinationPresenter {
    private Api api;
    private DestinationView view;

    public DestinationPresenterImpl(DestinationView view) {
        this.view = view;
        this.api = ApiClient.getClient().create(Api.class);
    }

    @Override
    public void requestDetails() {
        String slug = (String) view.getExtra("slug");

        view.showProgress();
        api.getDestination(slug).enqueue(new Callback<ApiShortLink>() {
            @Override
            public void onResponse(Call<ApiShortLink> call, Response<ApiShortLink> response) {
                view.setDestination(response.body().getDestination());
                view.setShortLink(getFullShortLink(response.body().getSlug()));
                view.dismissProgress();
            }

            @Override
            public void onFailure(Call<ApiShortLink> call, Throwable t) {
                view.dismissProgress();
            }
        });
    }

    @Override
    public void copyShortLinkToClipboard() {
        ClipboardManager clipboard =
                (ClipboardManager) view.getSystemService(Context.CLIPBOARD_SERVICE);

        ClipData clip = ClipData.newPlainText("Copied Text", view.getShortLink());
        clipboard.setPrimaryClip(clip);

        view.showMessage(view.getResources().getString(R.string.copied_to_clipboard));
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
