package br.com.zup.libraryZup.controllers.Author.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthorUpdateDTO {

    @NotNull(message = "O ID é obrigatório.")
    private Long id;

    @NotBlank(message = "O primeiro nome é obrigatório.")
    @Size(min = 3, max = 20, message = "O primeiro nome deve ter entre 3 e 20 caracteres.")
    private String firstName;

    @NotBlank(message = "O sobrenome é obrigatório.")
    @Size(min = 3, max = 20, message = "O sobrenome deve ter entre 3 e 20 caracteres.")
    private String lastName;

    @NotNull(message = "O ano de nascimento é obrigatório.")
    private Integer yearOfBirth;

    private Integer yearOfDeath;

    private List<Long> bookIds;

    public AuthorUpdateDTO() {}
}
