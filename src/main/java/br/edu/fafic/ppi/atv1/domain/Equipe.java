package br.edu.fafic.ppi.atv1.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
//@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@NamedQueries({
        @NamedQuery(name = "equipeByNome", query = "select e from Equipe e where e.nome =:parametro"), //buscar equipe pelo nome
        @NamedQuery(name= "tecnicoByEquipe", query = "select e from Equipe e where e.nome =:parametro"), //buscar nome tecnico pelo nome da equipe
        @NamedQuery(name= "timeByJogador", query = "select e from Equipe e join e.jogadores jogador where jogador.nome =:parametro"),//pelo nome do jogador to pegando o time dele
        @NamedQuery(name= "equipesByCampeonato", query = "select e from Equipe e join e.campeonatos campeonato where campeonato.nome =:parametro") //trazendo nomes dos times que estão no campeonato
})
public class Equipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_equipe")
    private UUID id;
    private String nome;

    @OneToMany
    private List<Jogador> jogadores;

    @OneToOne
    private Tecnico tecnico;

    @ManyToMany
    private List<Campeonato> campeonatos;

    @Override
    public String toString() {
        return "Equipe{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
