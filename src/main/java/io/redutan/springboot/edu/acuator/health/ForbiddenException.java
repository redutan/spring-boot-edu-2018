package io.redutan.springboot.edu.acuator.health;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author myeongju.jung
 */
@ResponseStatus(HttpStatus.FORBIDDEN)
class ForbiddenException extends RuntimeException {
    ForbiddenException(String ip) {
        super(ip);
    }
}
