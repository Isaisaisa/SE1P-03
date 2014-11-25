package Repositories;

import Entities.Frage;
import Entities.Modul;

import java.util.List;

/**
 * Created by Louisa on 24.11.2014.
 */
public interface FrageRepository {

    public List<Frage> getRandomQuestion(Modul modul);

}
