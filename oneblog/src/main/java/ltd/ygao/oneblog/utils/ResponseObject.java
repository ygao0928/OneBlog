package ltd.ygao.oneblog.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;

import java.util.Optional;
import java.util.function.Function;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/17 11:08
 */

public class ResponseObject<T> {
    private GlobalErrorCode status = GlobalErrorCode.SUCESS;
    private String moreInfo="";
    private T data;
    /** 正常返回，有数据 */
    public ResponseObject(T data) {
        this.data = data;
    }

    public ResponseObject(T data, String moreInfo, GlobalErrorCode status) {
        this.data = data;
        this.moreInfo = moreInfo;
        this.status = status;
    }

    public ResponseObject(T data, GlobalErrorCode status) {
        this.data = data;
        this.status = status;
    }

    /** 正常返回，无数据 */
    public ResponseObject() {}

    /** 错误状态返回 */
    public ResponseObject(GlobalErrorCode status) {
        this.moreInfo = status.getError();
        this.status = status;
    }

    /** 错误状态返回 */
    public ResponseObject(String moreInfo, GlobalErrorCode status) {
        this.moreInfo = moreInfo;
        this.status = status;
    }

    public static <T> ResponseObject<T> success(T t) {
        return new ResponseObject<>(t);
    }

    public static <T> ResponseObject<T> error(String moreInfo) {
        return error(moreInfo, GlobalErrorCode.INTERNAL_ERROR);
    }

    public static <T> ResponseObject<T> error(GlobalErrorCode status) {
        return error(status.getError(), status);
    }

    public static <T> Function<String, ResponseObject<T>> errorFunc(GlobalErrorCode status) {
        return msg -> error(msg, status);
    }

    public static <T> ResponseObject<T> error(String moreInfo, GlobalErrorCode status) {
        return new ResponseObject<>(moreInfo, status);
    }

    public static <T> ResponseObject<T> error(T t, GlobalErrorCode status) {
        return new ResponseObject<>(t, status);
    }



    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getErrorCode() {
        return status.getErrorCode();
    }

    public String getError() {
        return status.getError();
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public ResponseObject<T> withLog(Logger logger, Function<String, String> msgAppender) {
        final String msg = Optional.ofNullable(msgAppender).map(f -> f.apply(this.moreInfo))
                .orElse(this.moreInfo);
        logger.error(msg);
        return this;
    }
}
