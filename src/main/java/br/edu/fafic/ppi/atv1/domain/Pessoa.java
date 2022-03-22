package br.edu.fafic.ppi.atv1.domain;


import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo", discriminatorType = DiscriminatorType.STRING)
//@Builder

@NamedQueries({
        //buscando por todas as pessoas cadastradas no banco(por query)
        //@NamedQuery(name= "equipe.GetName", query= "select p from Equipe p.nome where.nome = :p"),


})
public abstract class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    protected String nome;


}
