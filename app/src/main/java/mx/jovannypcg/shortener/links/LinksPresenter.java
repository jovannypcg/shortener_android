package mx.jovannypcg.shortener.links;

/**
 * Provides the methods which contain the logic to handle LinksActivity.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public interface LinksPresenter {
    /** Handles the request to retrieve the bunch of short links from the api. */
    void submitRequest();

    /**
     * Action to execute when an item in the list view is clicked.
     *
     * @param slug Slug contained in the list view (by position).
     */
    void handleClickedSlug(String slug);
}
