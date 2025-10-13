package com.kaio.SmartApp.DTO.servicos.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ServicoRequest {
    private String name;
    private String description;
    private float price;
    private int duration;
    private int proId;
}
