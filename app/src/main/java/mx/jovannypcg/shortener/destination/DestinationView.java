package mx.jovannypcg.shortener.destination;

public interface DestinationView {
    Object getExtra(String key);
    void setDestination(String link);
    void setShortLink(String link);
    void showProgress();
    void dismissProgress();
}
