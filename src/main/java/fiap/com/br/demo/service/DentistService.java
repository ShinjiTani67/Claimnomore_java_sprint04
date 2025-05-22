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
        dto.setId(dentist.getId());
        dto.setName(dentist.getName());
        dto.setCpf(dentist.getCpf());
        dto.setEmail(dentist.getEmail());
        dto.setAddress(dentist.getAddress());
        dto.setCro(dentist.getCro());
        dto.setBirthdate(dentist.getBirthdate());
        return dto;
    }

    private Dentist convertToEntity(DentistDTO dto) {
        Dentist dentist = new Dentist();
        dentist.setId(dto.getId());
        dentist.setName(dto.getName());
        dentist.setCpf(dto.getCpf());
        dentist.setEmail(dto.getEmail());
        dentist.setAddress(dto.getAddress());
        dentist.setCro(dto.getCro());
        dentist.setBirthdate(dto.getBirthdate());
        return dentist;
    }

    public DentistDTO save(DentistDTO dentistDTO) {
        Dentist dentist = convertToEntity(dentistDTO);
        dentist = repository.save(dentist);
        return convertToDTO(dentist);
    }

    public List<DentistDTO> getAllDentist() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void deleteById(String id) {

        repository.deleteById(id);
    }

    public DentistDTO findById(String id) {
        Optional<Dentist> dentist = repository.findById(id);
        if (dentist.isPresent()) {
            return convertToDTO(dentist.get());
        }
        throw new RuntimeException("Dentista com id " + id + " não encontrado");
    }
}
