package br.com.mobitbrasil.consumer.service;

import br.com.mobitbrasil.consumer.model.EquipmentInfo;
import br.com.mobitbrasil.consumer.repository.EquipmentInfoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@AllArgsConstructor
public class EquipmentInfoService {

    private EquipmentInfoRepository repository;

    @Transactional
    public EquipmentInfo save(EquipmentInfo equipmentInfo){
        equipmentInfo.setPersistDate(Instant.now());
        return repository.save(equipmentInfo);
    }

}
