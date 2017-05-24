package mx.jovannypcg.shortener.rest.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents a short link in JSON format.
 *
 * @author  Jovanny Pablo Cruz Gomez
 *          Software Engineer
 *          jovannypcg@yahoo.com
 */
public class ApiShortLink {
    @SerializedName("id")
    private Integer id;
    @SerializedName("slug")
    private String slug;
    @SerializedName("destination")
    private String destination;

    public ApiShortLink() {}
    public ApiShortLink(Integer id, String slug, String destination) {
        this.id = id;
        this.slug = slug;
        this.destination = destination;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Override
    public String toString() {
        return this.id + " -> " + this.slug + " -> " + this.destination;
    }
}
