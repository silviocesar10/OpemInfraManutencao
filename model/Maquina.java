package com.openinfra.manutencao.OpenInfraManutencao.model;

import jakarta.persistence.OneToOne;
import lombok.*;
import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idMaquina"})
public class Maquina implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMaquina;

    @NotBlank(message = "O campo nome nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo nome deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String nome;

    @NotBlank(message = "O campo modelo nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo descricao deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String modelo;

    //Assume que a maquina seja Windows e detem um productkey associado a ela
    @NotBlank(message = "O campo productKey nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo de prdouctKey deve ter no minimo 2 e no maximo 200 caracteres!!")
    private String productKey;

    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    public Integer getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(Integer idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProductKey() {
        return productKey;
    }

    public void setProductKey(String productKey) {
        this.productKey = productKey;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
