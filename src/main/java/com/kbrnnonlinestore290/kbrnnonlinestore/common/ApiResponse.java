package com.kbrnnonlinestore290.kbrnnonlinestore.common;

import java.time.LocalDateTime;

/**
 *  ApiResponse.java is a Data Class (record) that is used to return a response to the client.
 *  If the response is successful, getTimeStamp responds with the time the response succeeded.
 */

public record ApiResponse(boolean success, String message) {

    public String getTimeStamp() {
        return LocalDateTime.now().toString();
    }
}
