package mx.jovannypcg.shortener.destination;

/**
 * Provides the methods which contain the logic to handle HomeActivity.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public interface DestinationPresenter {
    /** Hanldes the request to the api related to slug details. */
    void requestDetails();

    /** Gets the text from the short link text view and copies it to the clipboard */
    void copyShortLinkToClipboard();
}
