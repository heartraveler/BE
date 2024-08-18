package heartraveler.server.global.common.exception;

import heartraveler.server.global.common.ErrorResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import heartraveler.server.global.common.ApiResponse;

@Getter
@AllArgsConstructor
public enum GlobalErrorCode implements ErrorResponseCode {
    VALIDATION_FAILED(HttpStatus.BAD_REQUEST, "ERROR4000", "입력값에 대한 검증에 실패했습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "ERROR5000", "서버에 문제가 발생했습니다. 잠시 후 다시 시도해주세요.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ApiResponse<Void> getErrorResponse() {
        return ApiResponse.onFailure(code, message);
    }

}