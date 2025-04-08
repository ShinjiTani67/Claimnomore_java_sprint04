package service;

import entity.Dentist;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DentistRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class DentistService {

    @Autowired
    private DentistRepository dentistRepository;

    public List<Dentist> getAllDentists() {
        return dentistRepository.findAll();
    }

    public Optional<Dentist> getDentistById(UUID uuid) {
        return dentistRepository.findById(uuid);
    }

    public Dentist saveDentist(Dentist dentist) {
        return (Dentist) dentistRepository.save(dentist); // Removed unnecessary cast
    }

    public void deleteDentist(UUID uuid) {

        dentistRepository.deleteById(uuid);
    }

}
