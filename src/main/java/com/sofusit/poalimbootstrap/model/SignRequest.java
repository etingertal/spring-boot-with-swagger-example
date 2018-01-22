package com.sofusit.poalimbootstrap.model;

import com.sofusit.poalimbootstrap.data.entity.Sign;
import lombok.Data;

@Data
public class SignRequest extends BaseRequest {

    private String id;
    private String name;
    private Boolean isSigned;

    public Sign toSign() {
        Sign sign = new Sign();
        sign.setId(this.getId());
        sign.setName(this.getName());
        sign.setIsSigned(this.getIsSigned());
        return sign;
    }
}
