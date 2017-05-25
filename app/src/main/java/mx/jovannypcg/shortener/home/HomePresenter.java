package mx.jovannypcg.shortener.home;

/**
 * Provides the methods which contain the logic to handle HomeActivity.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public interface HomePresenter {
    /** Sends the request to the API and shows the result in the view */
    void submitShorten();

    /** Gets the text from the short link text view and copies it to the clipboard */
    void copyShortLinkToClipboard();
}
