package br.edu.fafic.ppi.atv1.main;

import br.edu.fafic.ppi.atv1.dao.CampeonatoDAO;
import br.edu.fafic.ppi.atv1.dao.EquipeDAO;
import br.edu.fafic.ppi.atv1.dao.JogadorDAO;
import br.edu.fafic.ppi.atv1.dao.TecnicoDAO;
import br.edu.fafic.ppi.atv1.domain.*;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {

        //Criando equipes
        Equipe psg = new Equipe();
        EquipeDAO equipeDAO = new EquipeDAO();
        psg.setNome("PSG");

        Equipe fla = new Equipe();
        fla.setNome("FLA");

        //Criando campeonatos
        Campeonato uefa = new Campeonato();
        CampeonatoDAO campeonatoDAO = new CampeonatoDAO();
        uefa.setNome("UEFA");

        Campeonato brasileirao = new Campeonato();
        brasileirao.setNome("Brasileirao");

        //Criando jogadores
        Jogador ney = new Jogador();
        JogadorDAO jogadorDAO = new JogadorDAO();

        ney.setNome("Neymar");
        ney.setPosicao("Ponta Esquerda");
        ney.setStatus(false);

        Jogador messi = new Jogador();
        messi.setNome("Messi");
        messi.setPosicao("Atacante");
        messi.setStatus(false);

        Jogador cr7 = new Jogador();
        cr7.setNome("Cr7");
        cr7.setPosicao("Atacante");
        cr7.setStatus(false);

        //Criando os tecnicos
        Tecnico jesus = new Tecnico();
        TecnicoDAO tecnicoDAO = new TecnicoDAO();

        jesus.setNome("Jesus");
        jesus.setEquipe(null);

        Tecnico tite = new Tecnico();
        tite.setNome("Tite");
        tite.setEquipe(null);


        //Gravando entidades no banco de dados
        equipeDAO.saveOrUpdate(fla);
        equipeDAO.saveOrUpdate(psg);
        jogadorDAO.saveOrUpdate(ney);
        jogadorDAO.saveOrUpdate(messi);
        jogadorDAO.saveOrUpdate(cr7);
        tecnicoDAO.saveOrUpdate(jesus);
        tecnicoDAO.saveOrUpdate(tite);
        campeonatoDAO.saveOrUpdate(uefa);
        campeonatoDAO.saveOrUpdate(brasileirao);


        //Relacionando todos os jogadores em um determinado time pelo nome
        Equipe equipe = equipeDAO.findByName("equipeByNome", "FLA");
        List<Jogador> jogadores = jogadorDAO.findAll("jogadores");
        System.out.println(jogadores);
        equipe.setJogadores(jogadores);
        equipeDAO.saveOrUpdate(equipe);
        jogadores.forEach(jogador -> {

            jogador.setEquipe(equipe);
            jogador.setStatus(true);
            jogadorDAO.saveOrUpdate(jogador);

        });


        //Relacionando tecnico em um determinado time pelo nome e relacioando o time no tecnico pelo nome.
        Tecnico equipeDoTecnico = tecnicoDAO.findByName("tecnicoByNome", "Jesus");
        System.out.println(equipeDoTecnico);
        Equipe tecnicoDaEquipe = equipeDAO.findByName("equipeByNome", "PSG");
        System.out.println(tecnicoDaEquipe);
        equipeDoTecnico.setEquipe(tecnicoDaEquipe);
        tecnicoDaEquipe.setTecnico(equipeDoTecnico);
        tecnicoDAO.saveOrUpdate(equipeDoTecnico);
        equipeDAO.saveOrUpdate(tecnicoDaEquipe);


        //Relacionando equipes em um campeonato e relacionando o campeonato nas equipes
        Equipe equipeFla = equipeDAO.findByName("equipeByNome", "FLA");
        Campeonato campeonatoUefa = campeonatoDAO.findByName("campeonatoEquipe", "UEFA");
        campeonatoUefa.setEquipes(Arrays.asList(equipeFla));
        equipeFla.setCampeonatos(Arrays.asList(campeonatoUefa));
        campeonatoDAO.saveOrUpdate(campeonatoUefa);
        equipeDAO.saveOrUpdate(equipeFla);


        //CONSULTAS
        //Consultas Equipe
        //Consultando Equipe por nome
        Equipe equipeByNome = equipeDAO.findByName("equipeByNome", "PSG");
        System.out.println(equipeByNome);
        //Consultando Equipe por nome do jogador
        Equipe equipeByPlayer = equipeDAO.findByEquipePlayer("timeByJogador", "Neymar");
        System.out.println(equipeByPlayer);
        //Consultando equipes pelo nome do campeonato
        List<Equipe> equipesDoCampeonato = equipeDAO.findList("equipesByCampeonato", "UEFA");
        System.out.println(equipesDoCampeonato);


        //Consultas Campeonato
        //Consultando equipes inscritas no campeonato pelo o nome do campeonato
        List<Campeonato> campByEquipe = campeonatoDAO.findList("campeonatoEquipe", "UEFA");
        System.out.println(campByEquipe.toString());


        //Consultas Jogador
        //Consultando jogador por nome
        Jogador jogador1 = jogadorDAO.findByName("jogadorByNome", "Messi");
        System.out.println(jogador1);
        //Consultando jogadores pelo status
        List<Jogador> jogador2 = jogadorDAO.findPlayerStatus("jogadorByStatus", true);
        System.out.println(jogador2);
        //Consultando jogadores pelo nome da equipe
        List<Jogador> jogador3 = jogadorDAO.findList("jogadoresByEquipe", "PSG");
        System.out.println(jogador3);


        //Consultas Tecnico
        //Consultando o tecnico por nome
        Tecnico tecnicoByNome = tecnicoDAO.findByName("tecnicoByNome", "Jesus");
        System.out.println(tecnicoByNome);
        //Consultando o tecnico pelo nome da equipe que ele esteja atuando
        Equipe equipeByTecnico = equipeDAO.findByName("tecnicoByEquipe", "psg");
        System.out.println(equipeByTecnico.getTecnico().getNome());


    }
}
