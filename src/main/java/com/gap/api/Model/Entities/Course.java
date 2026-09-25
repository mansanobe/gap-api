package com.gap.api.Model.Entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Immutable;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Immutable
@Table(name="courses")
public class Course {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name="name", nullable = false, unique = true)
    private String name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id", referencedColumnName = "id", unique = true)
    private User director;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coordinator_id", referencedColumnName = "id", unique = true)
    private User coordinator;

    @OneToOne(fetch =  FetchType.LAZY)
    @JoinColumn(name = "secretary_id", referencedColumnName = "id", unique = true)
    private User secretary;

     /**
         Como course e user apontam uma para a outra de duas formas diferentes,
         corre um grande risco de gerar um loop infinito na hora de retornar
         isso numa API. O Spring vai tentar converter o Curso, que tem um Coordenador,
         que pertence a um Curso, que tem um Coordenador... até a memória acabar.
         Ja devemos usar dto para retorno de qualquer jeito, mas nesse caso aqui
         principalmente para evitar problemas.
     **/

    @OneToMany(mappedBy = "course")
    private List<User> users = new ArrayList<>();


}
