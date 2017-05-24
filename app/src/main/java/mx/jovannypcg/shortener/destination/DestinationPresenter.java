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
}
