package ltd.ygao.oneblog.utils;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/17 11:08
 */
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum  GlobalErrorCode {
    SUCESS(200, "Success"),
    // 访问权限
    UNAUTHORIZED(401, "Unauthorized"),
    AUTH_UNKNOWN(401000, "登陆校验未知错误"),
    MOBILE_PHONE_VERIFY_CODE_ERROR(401001, "验证码错误"),
    MOBILE_PHONE_USER_NOT_EXIST(401002, "该手机号尚未注册"),
    CP_USER_NOT_EXISTS(401006, "获取用户信息失败"),
    CP_TOKEN_EXPIRED_OR_NOT_EXIST(401005, "微信授权信息已失效, 请重新登录"),
    BAD_CREDENTIALS(401003, "未设置密码"),
    PASSWORD_VERIFY_ERROR(401004, "密码错误"),
    INTERNAL_ERROR(500, "Server internal error"),
    UNKNOWN(-1, "Unknown error");
private static final Map<Integer ,GlobalErrorCode> values=
        new HashMap<Integer ,GlobalErrorCode>();
static {
    for (GlobalErrorCode ec : GlobalErrorCode.values()){
        values.put(ec.errorCode, ec);
    }
}
    private int errorCode;
    private String error;
    private GlobalErrorCode(int errorCode, String error) {
        this.errorCode = errorCode;
        this.error = error;
    }

    public static GlobalErrorCode valueOf(int code) {
        GlobalErrorCode ec = values.get(code);
        if (ec != null) {
            return ec;
        }
        return UNKNOWN;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getError() {
        return error;
    }

    public String render() {
        return errorCode + ":" + error;
    }
}
