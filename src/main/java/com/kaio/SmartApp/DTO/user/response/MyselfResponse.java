package com.kaio.SmartApp.DTO.user.response;

import com.kaio.SmartApp.DTO.address.response.AddressResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class MyselfResponse {
    private int id;
    private String completeName;
    private String phone;
    private String email;
    private String document;
    private int type;
    private AddressResponse address;
}
