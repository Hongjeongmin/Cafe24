package com.base.cafe.model.result;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
/**
 * BaseResult 입니다.
 * 기본적인 형태는
 * {
 *     status: 0,
 *     data: {
 *         ...
 *     }
 * }
 */
public class BaseResult {
    private static final int SUCCESS = 0;
    private static final int FAIL = -1;
    int status;
    String message;
    Map<String, Object> data = new HashMap<>();

    public BaseResult() {
    }

    public static BaseResult isSuccess(String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.status = SUCCESS;

        if (message == null) {
            return baseResult;
        }

        baseResult.message = message;
        return baseResult;
    }

    public static BaseResult isSuccess() {
        return isSuccess("");
    }

    public static BaseResult isFail(String message) {
        BaseResult baseResult = new BaseResult();
        baseResult.status = FAIL;

        if (message == null) {
            return baseResult;
        }

        baseResult.message = message;
        return baseResult;
    }

    public static BaseResult isFail() {
        return isFail("");
    }

    public BaseResult add(String key, Object value) {
        data.put(key, value);
        return this;
    }
}
