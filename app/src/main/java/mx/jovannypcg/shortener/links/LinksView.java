package mx.jovannypcg.shortener.links;

import android.content.res.Resources;

public interface LinksView {
    void refreshList(String[] items);
    void showProgress();
    void dismissProgress();
    void showMessage(String message);
    Resources getResources();
    void navigateToWebBrowser(String url);
}
