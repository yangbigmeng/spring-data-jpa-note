package note.response;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by YM on 2017/6/11.
 */
public class ControllerResponse<T> {

    public ControllerResponse (int status, String message, T response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    @JsonProperty("status")
    private int status;

    @JsonProperty("message")
    private String message;

    @JsonProperty("cost_time")
    private long costTime;

    @JsonProperty("response")
    private T response;

    public long getCostTime() {
        return costTime;
    }

    public void setCostTime(long costTime) {
        this.costTime = costTime;
    }
}
