package br.edu.fafic.ppi.atv1.domain;


import lombok.*;

import javax.persistence.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("J")
//@Data
@Getter
@Setter


@NamedQueries({
        @NamedQuery(name = "jogadores", query = "select j from Jogador j"),//todos jogadores
        @NamedQuery(name = "jogadorByNome", query = "select e from Jogador e where e.nome =:parametro"), //buscar jogador pelo nome
        @NamedQuery(name = "jogadorByStatus", query = "select e from Jogador e where e.status =:parametro"), //buscar jogador pelo status
        @NamedQuery(name = "jogadoresByEquipe", query = "select e from Jogador e join e.equipe equipe where equipe.nome =:parametro"),//pelo nome da equipe to pegando os jogadores
})
public class Jogador extends Pessoa {

    private String posicao;
    private Boolean status; //reserva = false, titular = true

    @ManyToOne
    private Equipe equipe;

    @Override
    public String toString() {
        return "Jogador{" +
                "posicao='" + posicao + '\'' +
                ", status=" + status +
                ", nome='" + nome + '\'' +
                '}';
    }
}
