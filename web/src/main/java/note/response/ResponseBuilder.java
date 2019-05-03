package note.response;

/**
 * Created by YM on 2017/6/11.
 */
public class ResponseBuilder {

    public static <T> ControllerResponse<T> buildSuccess(T response) {
        return new ControllerResponse<>(0, "ok", response);
    }

    public static <T> ControllerResponse<T> buildFailed(T response, String message) {
        return new ControllerResponse<>(-1, message, response);
    }
}
