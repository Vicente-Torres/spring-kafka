package br.com.mobitbrasil.consumer.kafka.consumer;

import br.com.mobitbrasil.consumer.model.EquipmentInfo;
import br.com.mobitbrasil.consumer.service.EquipmentInfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
@RequiredArgsConstructor
public class EquipmentInfoConsumer {

    @Value("${CONTAINER_NAME:dev}")
    private String containerName;

    private EquipmentInfoService equipmentInfoService;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${consumer.group-id}", containerFactory = "equipmentInfoConcurrentKafkaListenerContainerFactory")
    public void listen(EquipmentInfo equipmentInfo) {
        log.info("Nova menssagem {}", equipmentInfo.toString());
        var teste = equipmentInfoService.save(equipmentInfo);
    }

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${consumer.group-id}")
    public void listen2(ConsumerRecord<EquipmentInfo, String> equipmentInfo) {
        log.info("Nova menssagem {}", equipmentInfo.toString());
        var teste = equipmentInfoService.save(equipmentInfo);
    }

}
