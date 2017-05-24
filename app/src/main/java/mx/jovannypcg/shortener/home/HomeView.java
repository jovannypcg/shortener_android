package mx.jovannypcg.shortener.home;

public interface HomeView {
    void showProgress();
    void dismissProgress();
    void showToast(String message);
}
