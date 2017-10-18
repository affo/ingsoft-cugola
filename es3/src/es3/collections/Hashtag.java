package es3.collections;

/**
 * Created by affo on 17/10/17.
 */
public final class Hashtag {
    public final String content;

    public Hashtag(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "#" + content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hashtag hashtag = (Hashtag) o;

        return content != null ? content.equals(hashtag.content) : hashtag.content == null;
    }

    @Override
    public int hashCode() {
        return content != null ? content.hashCode() : 0;
    }
}
