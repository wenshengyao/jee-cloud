package xyz.jee.frame.web.domain.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * http统一返回值
 * @param <T>
 */
@Data
public class ResultDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private T data;

    private String msg;

    private Integer code;

    private Date time;

    private ResultDTO() {
        this.code = CodeEnum.SUCCESS.getValue();
        this.msg = "success";
        this.time = new Date();
    }

    private ResultDTO(T data) {
        this.data = data;
        this.code = CodeEnum.SUCCESS.getValue();
        this.msg = "success";
        this.time = new Date();
    }

    private ResultDTO(String msg) {
        this.code = CodeEnum.FAIL.getValue();
        this.msg = msg;
        this.time = new Date();
    }

    public static <T> ResultDTO SUCCESS(T data){
        return new ResultDTO<T>(data);
    }

    public static <T> ResultDTO SUCCESS(){
        return new ResultDTO<T>();
    }

    public static <T> ResultDTO FAIL(Throwable throwable) {
        return new ResultDTO<T>(throwable.getMessage());
    }
    public static <T> ResultDTO FAIL(String msg) {
        return new ResultDTO<T>(msg);
    }

    enum CodeEnum{
        SUCCESS(200),
        FAIL(500);
        private Integer value;
        CodeEnum(Integer value){
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
}
