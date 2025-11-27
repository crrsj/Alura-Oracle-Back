package br.com.oracle.entity;


import br.com.oracle.enums.Categoria;
import br.com.oracle.enums.Certificacao;
import br.com.oracle.enums.Statusinscricao;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Data
public class Participante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataInscricao = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
    @NotBlank(message = "não pode estar em brenco")
    private String nome;
    @NotBlank(message = "não pode estar em brenco")
    private String telefone;
    @Email
    @NotBlank(message = "não pode estar em brenco")
    private String emai;
    @Enumerated(EnumType.STRING)
    private Categoria categoria;
    @Enumerated(EnumType.STRING)
    private Certificacao certificacao;
    @Enumerated(EnumType.STRING)
    private Statusinscricao status;
}
