package br.com.vicentetorres.spring.consumer.kafka.consumer;

import br.com.vicentetorres.spring.consumer.model.EquipmentInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.Instant;

@Slf4j
@Component
public class EquipmentInfoConsumer {

    @Value("${container.name}")
    private String containerName;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "${consumer.group-id}", containerFactory = "equipmentInfoConcurrentKafkaListenerContainerFactory")
    public void listen(ConsumerRecord<String, EquipmentInfo> record) {
        var equipmentInfo = record.value();
        equipmentInfo.setPersistDate(Instant.now());
        equipmentInfo.setLatency(Duration.between(equipmentInfo.getReadDate(), equipmentInfo.getPersistDate()).toMillis());
        log.info("Nova menssagem: [{}] {}", containerName, record.value());
    }

}
