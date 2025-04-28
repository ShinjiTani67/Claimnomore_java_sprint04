package fiap.com.br.demo.service;

import fiap.com.br.demo.dto.DentistDTO;
import fiap.com.br.demo.entity.Dentist;
import fiap.com.br.demo.repository.DentistRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DentistService {

    private final DentistRepository repository;

    private DentistDTO convertToDTO(Dentist dentist) {
        DentistDTO dto = new DentistDTO();
        dto.setUuid(dentist.getUuid());
        dto.setName(dentist.getName());
        dto.setCPF(dentist.getCPF());
        dto.setEmail(dentist.getEmail());
        return dto;
    }

    private Dentist convertToEntity(DentistDTO dto) {
        Dentist dentist = new Dentist();
        dentist.setUuid(dto.getUuid());
        dentist.setName(dto.getName());
        dentist.setCPF(dto.getCPF());
        dentist.setEmail(dto.getEmail());
        return dentist;
    }

    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist dentist = convertToEntity(dentistDTO);
        dentist = repository.save(dentist);
        return convertToDTO(dentist);
    }

    public List<DentistDTO> getAllDentists() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(UUID uuid) {
        repository.deleteById(uuid);
    }

    public DentistDTO findByUuid(UUID uuid) {
        Optional<Dentist> dentist = repository.findById(uuid);
        if (dentist.isPresent()) {
            return convertToDTO(dentist.get());
        }
        throw new RuntimeException("Dentista com id " + uuid + " não encontrado");
    }
}
