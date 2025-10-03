package com.kaio.SmartApp.DTO.address;

import com.kaio.SmartApp.DTO.address.request.AddressEditRequest;
import com.kaio.SmartApp.DTO.address.response.AddressResponse;
import com.kaio.SmartApp.DTO.user.request.UserRequestDTO;
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

    public static Address userRequestToEntity(UserRequestDTO request){
        Address address = new Address();
        address.setZipCode(request.getZipcode());
        address.setAddress(request.getAddress());
        address.setNumber(request.getNumber());
        return address;
    }

    public static void upgrade(Address model, AddressEditRequest request){
        model.setZipCode(request.getZipcode());
        model.setAddress(request.getAddress());
        model.setNumber(request.getNumber());
    }
}
