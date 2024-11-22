package br.com.zup.libraryZup.controllers.Book.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookUpdateDTO {

    @NotNull(message = "O ID é obrigatório.")
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Size(min = 2, message = "O título deve ter pelo menos 2 caracteres.")
    private String title;

    @NotBlank(message = "A descrição é obrigatória.")
    private String description;

    private List<Long> authorIds;

    public BookUpdateDTO() {}
}
