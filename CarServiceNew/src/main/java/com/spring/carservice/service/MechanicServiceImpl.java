package com.spring.carservice.service;

import com.spring.carservice.dto.MechanicDto;
import com.spring.carservice.domain.Mechanic;
import com.spring.carservice.dto.MechanicSearchDto;
import com.spring.carservice.repository.MechanicRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class MechanicServiceImpl implements MechanicService {
    private MechanicRepository mechanicRepository;

    public MechanicServiceImpl(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @Transactional
    @Override
    public MechanicDto add(MechanicDto mechanicDto) {
        return toDto(mechanicRepository.save(fromDto(mechanicDto)));
    }

    @Transactional
    @Override
    public MechanicDto getById(Long Id) {
        return toDto(mechanicRepository.getOne(Id));
    }

    @Transactional
    @Override
    public MechanicDto update(MechanicDto mechanicDto) {
        return toDto(mechanicRepository.save(fromDto(mechanicDto)));

    }

    @Transactional
    @Override
    public void delete(Long id) {
        mechanicRepository.delete(mechanicRepository.getOne(id));
    }

    @Transactional
    @Override
    public MechanicDto getFreeMechanic() {
        List<Mechanic> mechanics = mechanicRepository.findAll();
        Mechanic mechanic;
        if (mechanics.size() > 0) {
            mechanic = mechanics.get(new Random().nextInt(mechanics.size()));
        } else {
            throw new RuntimeException("There is no mechanic in our service. Please add mechanic by /save");
        }
        return toDto(mechanic);
    }

    /**
     * @param mechanicSearchDto принимаем модель для поиска
     * @param pageable          параметры для страницы
     * @return список механиков в формате страницы
     */
    @Override
    public Page<MechanicDto> getMechanics(MechanicSearchDto mechanicSearchDto, Pageable pageable) {
        return mechanicRepository.findAll(getSpecification(mechanicSearchDto), pageable).map(mechanic -> toDto(mechanic));
    }

    private Specification<Mechanic> getSpecification(MechanicSearchDto mechanicSearchDto) {
        return (root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (mechanicSearchDto.getFirstName() != null) {
                predicates.add(root.get("firstName").in(mechanicSearchDto.getFirstName()));
            }

            if (mechanicSearchDto.getLastName() != null) {
                predicates.add(builder.lower(root.get("lastName")).in(mechanicSearchDto.getLastName()));
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
        };
    }

    private Mechanic fromDto(MechanicDto mechanicDto) {
        return new Mechanic(mechanicDto.getId(),
                mechanicDto.getFirstName(),
                mechanicDto.getLastName());
    }

    private MechanicDto toDto(Mechanic mechanic) {
        return new MechanicDto(mechanic.getId(),
                mechanic.getFirstName(),
                mechanic.getLastName());
    }
}
