package com.kaio.SmartApp.DTO.address;

import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.entity.Address;

public class AddressMapper {

    public static AddressResponse toResponse(Address model){
        return new AddressResponse(
            model.getId(), 
            model.getZipCode(), 
            model.getAddress(), 
            model.getNumber()
            );
    }

}
