package br.com.vicentetorres.spring.consumer.kafka;

import br.com.vicentetorres.spring.consumer.model.EquipmentInfo;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@EnableKafka
@Configuration
public class KafkaConfiguration {

    @Value("${host}")
    private String host;

    @Value("${consumer.group-id}")
    private String consumerGroup;

    @Bean
    public ConsumerFactory<String, EquipmentInfo> consumerFactory() {
        Map<String, Object> props = new HashMap<>();
        props.put(
                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                host);
        props.put(
                ConsumerConfig.GROUP_ID_CONFIG,
                consumerGroup);
        props.put(
                ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        props.put(
                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(EquipmentInfo.class));
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, EquipmentInfo> equipmentInfoConcurrentKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, EquipmentInfo> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }
}
