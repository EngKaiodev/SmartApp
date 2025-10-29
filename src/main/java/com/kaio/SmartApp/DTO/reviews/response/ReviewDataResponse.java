package com.kaio.SmartApp.DTO.reviews.response;

public interface ReviewDataResponse {

    Long getTotal_avaliacoes();   
    Double getMedia_avaliacoes();  
    Long getNota_5();
    Long getNota_4();
    Long getNota_3();
    Long getNota_2();
    Long getNota_1();

}
