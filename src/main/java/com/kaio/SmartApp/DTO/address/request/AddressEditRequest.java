package com.kaio.SmartApp.DTO.address.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AddressEditRequest {
    private int userId;
    private String zipcode;
    private String address;
    private String number;
}
