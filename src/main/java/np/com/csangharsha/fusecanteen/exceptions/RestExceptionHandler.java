package np.com.csangharsha.fusecanteen.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiException> handleException(Exception exception) {
        ApiException apiException = new ApiException(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage(), exception);
        return buildResponseEntity(apiException);
    }

    private ResponseEntity<ApiException> buildResponseEntity(ApiException apiException) {
        return new ResponseEntity<>(apiException, apiException.getStatus());
    }

}
