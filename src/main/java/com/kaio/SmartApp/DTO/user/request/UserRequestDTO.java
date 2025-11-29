package com.kaio.SmartApp.DTO.user.request;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDTO {

    @NotBlank(message = "Nome completo é obrigatório")
    @Size(min = 3, max = 150, message = "Nome completo deve ter entre 3 e 150 caracteres")
    private String complete_name;

    @NotBlank(message = "Senha é obrigatória")
    @Size(min = 6, message = "Senha deve ter no mínimo 6 caracteres")
    private String password;

    @NotBlank(message = "Telefone é obrigatório")
    @Pattern(regexp = "\\d{10,11}", message = "Telefone deve conter 10 ou 11 dígitos numéricos")
    private String phone;

    @NotBlank(message = "E-mail é obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    @NotBlank(message = "Documento é obrigatório")
    private String document;

    @NotNull(message = "Tipo é obrigatório")
    @Min(value = 0, message = "Tipo deve ser no mínimo 0, 0 -> admin, 1 -> profissional, 2 -> cliente")
    @Max(value = 2, message = "Tipo deve ser no máximo 2, 0 -> admin, 1 -> profissional, 2 -> cliente")
    private Integer type; // 0 -> admin, 1 -> profissional, 2 -> cliente

    private String alterName;
    private String description;

    @NotNull(message = "Cep é obrigatório")
    @Length(min = 8, max = 8,message = "O Cep deve ter 8 dígitos")
    private String zipcode;
    @NotNull(message = "O endereço é obrigatório")
    private String address;
    @NotNull(message = "O número é obrigatório")
    private String number;
    private String tokenFCM;
}
