package mx.jovannypcg.shortener.links;

import android.content.res.Resources;

import java.util.List;

import mx.jovannypcg.shortener.rest.model.ApiShortLink;

/**
 * Specifies the methods LinksActivity should implement
 * to be treated as a view.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public interface LinksView {
    /**
     * Refreshes the list view with the items sent as argument.
     *
     * @param items Items to add in the list view.
     */
    void refreshList(List<ApiShortLink> items);

    /** Shows the progress dialog. */
    void showProgress();

    /** Dismisses the progress dialog. */
    void dismissProgress();

    /**
     * Shows a toast with the given message.
     *
     * @param message Message to show up.
     */
    void showMessage(String message);

    /**
     * Gets the activity resources.
     *
     * @return Activity resources object.
     */
    Resources getResources();

    /**
     * Navigates to the activity that shows short link details.
     *
     * @param slug Slug to retrieve the info.
     */
    void navigateToDestinationDetail(String slug);
}
