package fiap.com.br.demo.service;

import fiap.com.br.demo.entity.Dentist;
import fiap.com.br.demo.repository.DentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@Service
@AllArgsConstructor
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public Optional<Dentist> getDentistById(Long id) {
        return dentistRepository.findById(String.valueOf(id));
    }

    public Dentist saveDentist(Dentist dentist) {
        return (Dentist) dentistRepository.save(dentist); // Removed unnecessary cast
    }

    public void deleteDentist(Long id) {

        dentistRepository.deleteById(String.valueOf(id));
    }

}
