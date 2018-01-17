package org.fruct.oss.geopoint.base;

public interface TaskListener {
    void onSuccess();
    void onError(Throwable ex);
}
