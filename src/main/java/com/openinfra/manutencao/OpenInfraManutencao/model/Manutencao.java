package com.openinfra.manutencao.OpenInfraManutencao.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode( of = {"idManutencao"})
public class Manutencao implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idManutencao;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataManutencao;

    @NotBlank(message = "O campo tipo nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo tipo deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String tipo;

    @NotBlank(message = "O campo descricao nao pode permanecer em branco!!")
    @Size(min = 2, max = 100, message = "O campo descricao deve ter no minimo 2 e no maximo 100 caracteres!!")
    private String descricao;

    @OneToOne
    @JoinColumn(name ="idUsuario")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name ="idMaqquina")
    private Maquina maquina;

    public Integer getIdManutencao() {
        return idManutencao;
    }

    public void setIdManutencao(Integer idManutencao) {
        this.idManutencao = idManutencao;
    }

    public LocalDate getDataManutencao() {
        return dataManutencao;
    }

    public void setDataManutencao() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("DD/MM/YYYY");
        String text = date.format(formatters);
        this.dataManutencao = LocalDate.parse(text, formatters);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Maquina getMaquina() {
        return maquina;
    }

    public void setMaquina(Maquina maquina) {
        this.maquina = maquina;
    }
}
