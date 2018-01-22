package com.sofusit.poalimbootstrap.model;

import com.sofusit.poalimbootstrap.data.entity.Sign;
import lombok.Data;

@Data
public class SignResponse extends BaseResponse {

    private Boolean isSigned;

    public SignResponse(Sign sign) {
        this.isSigned = sign.getIsSigned();
    }
}
