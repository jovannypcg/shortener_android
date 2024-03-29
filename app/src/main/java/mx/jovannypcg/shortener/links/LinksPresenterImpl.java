package mx.jovannypcg.shortener.links;

import java.util.List;

import mx.jovannypcg.shortener.BuildConfig;
import mx.jovannypcg.shortener.R;
import mx.jovannypcg.shortener.rest.Api;
import mx.jovannypcg.shortener.rest.ApiClient;
import mx.jovannypcg.shortener.rest.model.ApiShortLink;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Contains the logic to deal with short links in LinksActivity.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public class LinksPresenterImpl implements LinksPresenter {
    private LinksView view;
    private Api api;

    public LinksPresenterImpl(LinksView view) {
        this.view = view;

        api = ApiClient.getClient().create(Api.class);
    }

    @Override
    public void submitRequest() {
        view.showProgress();
        api.getShortLinks().enqueue(new Callback<List<ApiShortLink>>() {
            @Override
            public void onResponse(retrofit2.Call<List<ApiShortLink>> call, Response<List<ApiShortLink>> response) {
                handleResponse(response);
                view.dismissProgress();
            }

            @Override
            public void onFailure(retrofit2.Call<List<ApiShortLink>> call, Throwable t) {
                view.showMessage(view.getResources().getString(R.string.something_went_wrong));
                view.dismissProgress();
            }
        });
    }

    @Override
    public void handleClickedSlug(String slug) {
        view.navigateToDestinationDetail(slug);
    }

    public void handleResponse(Response<List<ApiShortLink>> response) {
        List<ApiShortLink> linksFromResponse = response.body();
        view.refreshList(linksFromResponse);
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
