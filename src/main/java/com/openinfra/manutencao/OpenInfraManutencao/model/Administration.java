package com.openinfra.manutencao.OpenInfraManutencao.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.io.Serializable;
import javax.validation.constraints.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idAdministrator"})
//essa classe tem o proposito de representar o modelod de usuario administrador
public class Administration implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrator;

    @NotBlank(message = "O campo nome nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo nome deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String nome;

    @NotBlank(message = "O campo login nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo login deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String login;

    @NotBlank(message = "O campo senha nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo  senha deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String senha;

    public Integer getIdAdministrator() {
        return idAdministrator;
    }

    public void setIdAdministrator(Integer idAdministrator) {
        this.idAdministrator = idAdministrator;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
