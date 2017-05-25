package mx.jovannypcg.shortener.destination;

import android.content.res.Resources;

/**
 * Specifies the methods DestinationActivity should implement to
 * be treated as a view.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public interface DestinationView {
    /**
     * Retrieves an extra value from the activity intent.
     * @param key Key to get the value.
     * @return Value from intent's extra.
     */
    Object getExtra(String key);

    /** Gets a reference to the Resources object, contained in the activity. */
    Resources getResources();

    /** Gets a system service. */
    Object getSystemService(String name);

    /**
     * Sets text in the text view for destination.
     * @param link Link to be set in the text view.
     */
    void setDestination(String link);

    /**
     * Sets text in the text view for short link.
     * @param link Link to be set in the text view.
     */
    void setShortLink(String link);

    /**
     * Gets the text contained in the text view for short link.
     *
     * @return Link in text view.
     */
    String getShortLink();

    /** Shows progress dialog. */
    void showProgress();

    /** Dismisses progress dialog. */
    void dismissProgress();

    /**
     * Shows up a toast message with the given argument.
     * @param message Message to show up as toast.
     */
    void showMessage(String message);
}
