package Component;

import Entities.*;
import Interface.KFragestellungService;
import Interface.KModulService;
import Repositories.FrageRepository;
import Repositories.FrageRepositoryImpl;
import Services.PersistenceService;

import javax.swing.text.Document;
import java.util.List;

/**
 * Created by KamikazeOnRoad on 03.11.2014.
 */
public class KFragestellungServiceImpl implements KFragestellungService {


    public KFragestellungServiceImpl(PersistenceService persistenceService, KModulService modul) {

    }


    @Override
    public Document showCorrectAnswer(int frageNummer) {
        return null;
    }

    @Override
    public List<FrageImpl> getRandomQuestion(ModulImpl modul) {
        FrageRepository repo = new FrageRepositoryImpl();
        return repo.getRandomQuestion(modul);
    }

    @Override
    public boolean isAnswerCorrect(MultipleChoiceFrage frage) {
        return false;
    }

    @Override
    public boolean isAnswerCorrect(SingleChoiceFrage frage) {
        return false;
    }

    @Override
    public boolean isAnswerCorrect(BinaereAnkreuzFrage frage) {
        return false;
    }
}
