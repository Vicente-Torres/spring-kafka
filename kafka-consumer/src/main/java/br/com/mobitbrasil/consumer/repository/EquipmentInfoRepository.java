package br.com.mobitbrasil.consumer.repository;

import br.com.mobitbrasil.consumer.model.EquipmentInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface EquipmentInfoRepository extends MongoRepository<EquipmentInfo, Long> {

}
