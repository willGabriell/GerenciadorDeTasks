package org.esig.mavenproject1.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import org.esig.mavenproject1.enums.Priority;
import org.esig.mavenproject1.enums.Responsibles;
import org.esig.mavenproject1.enums.Status;

@Entity
@Table(name = "tasks")
public class Tasks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "title")
    private String titulo;
    
    @Column(name = "description")
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "responsible")
    private Responsibles responsavel;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority prioridade;
    
    @Column(name = "deadline")
    @Temporal(TemporalType.DATE)
    private Date deadline;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Responsibles getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsibles responsavel) {
        this.responsavel = responsavel;
    }

    public Priority getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Priority prioridade) {
        this.prioridade = prioridade;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
