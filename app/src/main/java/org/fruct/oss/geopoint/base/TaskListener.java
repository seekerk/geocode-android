package org.fruct.oss.geopoint.base;

import sofia_kp.SIBResponse;

public interface TaskListener {
    void onSuccess(SIBResponse response);
    default void onError(Exception ex) {
        ex.printStackTrace();
    }
}
