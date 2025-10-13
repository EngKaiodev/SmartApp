package com.kaio.SmartApp.DTO.servicos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class ServicoResponse {
    private int id;
    private String name;
    private String description;
    private float price;
    private int duration;
}
