package br.edu.fafic.ppi.atv1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("T")
@Data

@NamedQueries({
        @NamedQuery(name = "tecnicoByNome", query = "select t from Tecnico t where t.nome =:parametro")//consulta namedquery, que vai buscar equipe pelo nome
})
public class Tecnico extends Pessoa{

    //@OneToOne(cascade = CascadeType.MERGE)
    @OneToOne()
    private Equipe equipe;

    @Override
    public String toString() {
        return "Tecnico{" +
                "nome='" + nome + '\'' +
                ", equipe=" + equipe +
                '}';
    }
}
