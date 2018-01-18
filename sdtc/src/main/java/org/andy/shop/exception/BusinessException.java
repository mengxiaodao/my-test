package org.andy.shop.exception;

/**
 * 自定义业务异常类
 * Created by Mc
 *
 * @create 2018-01-18 15:08
 **/
public class BusinessException extends RuntimeException{
    private String retCd ;  //异常对应的返回码
    private String msgDes;  //异常对应的描述信息

    public BusinessException(){
        super();
    }
    public BusinessException(String message) {
        super(message);
        msgDes = message;
    }

    public BusinessException(String retCd, String msgDes) {
        super();
        this.retCd = retCd;
        this.msgDes = msgDes;
    }

    public String getRetCd() {
        return retCd;
    }

    public String getMsgDes() {
        return msgDes;
    }

    public static void throwMessage(String msgDes){
        throw new BusinessException(msgDes);
    }
}
