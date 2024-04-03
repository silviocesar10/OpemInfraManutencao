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
@EqualsAndHashCode( of = {"idUsuario"})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @NotBlank(message = "O campo nome nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo nome deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String nome;

    @NotBlank(message = "O campo login nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo login deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String login;

    @NotBlank(message = "O campo senha nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo  senha deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String senha;

    @NotBlank(message = "O campo setor nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo setor deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String setor;

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}
