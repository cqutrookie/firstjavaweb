package com.lxy.oa.service.exeception;

public class BussinessException extends RuntimeException{
        private String code;//异常的编码

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;//异常提示消息
        public BussinessException(String code,String message){
            super(code+":"+message);
            this.code=code;
            this.message=message;
        }
}
