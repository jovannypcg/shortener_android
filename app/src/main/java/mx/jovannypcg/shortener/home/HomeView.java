package mx.jovannypcg.shortener.home;

import android.content.res.Resources;

public interface HomeView {
    void showProgress();
    void dismissProgress();
    void showMessage(String message);
    Resources getResources();
    String getDestination();
    void showDestinationEmptyError();
    void setShorterLinkLayoutVisibility(int visibility);
    void setShorterLink(String shorterLink);
}
