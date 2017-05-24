package mx.jovannypcg.shortener.links;

import android.content.res.Resources;

import java.util.List;

import mx.jovannypcg.shortener.rest.model.ApiShortLink;

public interface LinksView {
    void refreshList(List<ApiShortLink> items);
    void showProgress();
    void dismissProgress();
    void showMessage(String message);
    Resources getResources();
    void navigateToDestinationDetail(String slug);
}
