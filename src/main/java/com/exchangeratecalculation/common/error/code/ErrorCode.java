package com.exchangeratecalculation.common.error.code;

import lombok.Getter;

@Getter
public enum  ErrorCode {

    //EXCHANGE
    EXCHANGE_SERVER_ERROR(500,"E005001","현재 환율을 조회할 수 없습니다.");

    private int status;
    private String code;
    private String message;

    ErrorCode(int status, String code, String message){
        this.status = status;
        this.code = code;
        this.message = message;
    }
}
