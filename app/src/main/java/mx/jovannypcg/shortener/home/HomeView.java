package mx.jovannypcg.shortener.home;

import android.content.res.Resources;

/**
 * Specifies the methods HomeActivity should implement in
 * order to be treated just as a view.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public interface HomeView {
    /** Shows the progress dialog linked to the class that implements this interface. */
    void showProgress();

    /** Dismisses the progress dialog linked to the class that implements this interface. */
    void dismissProgress();

    /**
     * Shows up a toast message with the given argument.
     * @param message Message to show up as toast.
     */
    void showMessage(String message);

    /** Gets a reference to the Resources object, contained in the activity. */
    Resources getResources();

    /** Gets a system service. */
    Object getSystemService(String name);

    /** Retrieves the text entered by the user from the edit text. */
    String getDestination();

    /** Retrieves the short link from the view. */
    String getShortLink();

    /**
     * Displays an error message in the edit text for the destination when
     * the user attempts to submit an invalid string (url).
     */
    void showDestinationError(String message);

    /**
     * By default the layout which contains the text view that shows the shorter link
     * is invisible. This method changes that visibility using the integer sent as
     * argument.
     *
     * Valid values: View.GONE, View.VISIBLE, View.INVISIBLE.
     *
     * @param visibility Visibility for the layout.
     */
    void setShorterLinkLayoutVisibility(int visibility);

    /**
     * Sets the string sent as argument to the shorter link text view.
     *
     * @param shorterLink Link to show in the shorter link text view.
     */
    void setShorterLink(String shorterLink);
}
