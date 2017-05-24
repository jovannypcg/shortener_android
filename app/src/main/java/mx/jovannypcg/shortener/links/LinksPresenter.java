package mx.jovannypcg.shortener.links;

public interface LinksPresenter {
    void submitRequest();
    void handleClickedSlug(String slug);
}
