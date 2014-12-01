package Repositories;

import Entities.FrageImpl;
import Entities.ModulImpl;

import java.util.List;

/**
 * Created by Louisa on 24.11.2014.
 */
public interface FrageRepository {

    public List<FrageImpl> getRandomQuestion(ModulImpl modul);

}
