package com.kaio.SmartApp.DTO.address.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AddressResponse {
    private int id;
    private String zipCode;
    private String address;
    private String number;
}
