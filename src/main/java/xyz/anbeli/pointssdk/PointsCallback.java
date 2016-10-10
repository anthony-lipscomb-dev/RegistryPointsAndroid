package xyz.anbeli.pointssdk;

/**
 * Created by anthonylipscomb on 10/9/16.
 */

public interface PointsCallback<T> {
    void success(T data);
    void error(Throwable error);
}
