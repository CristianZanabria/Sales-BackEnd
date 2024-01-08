package com.zdevs.exception;

import java.time.LocalDateTime;

public record CustomErrorResponseRecord(
        LocalDateTime dateTime,
        String message,
        String path
) {
}
