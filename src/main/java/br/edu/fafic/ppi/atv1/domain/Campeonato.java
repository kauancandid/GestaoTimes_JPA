package br.edu.fafic.ppi.atv1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@Data
@Getter
@Setter

@NamedQueries({
        @NamedQuery(name = "campeonatoEquipe", query = "select c from Campeonato c where c.nome =:paramentro")

})
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_campeonato")
    private UUID id;
    private String nome;

    @ManyToMany()
    private List<Equipe> equipes;

    @Override
    public String toString() {
        return "Campeonato{" +
                "nome='" + nome + '\'' +
                '}';
    }
}