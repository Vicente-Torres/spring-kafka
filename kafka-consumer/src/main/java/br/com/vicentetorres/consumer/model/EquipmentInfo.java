package br.com.vicentetorres.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.Instant;

@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class EquipmentInfo {

    @Id
    @EqualsAndHashCode.Include
    private Long id;

    @JsonProperty("codigoEquipamento")
    private String equipmentCode;

    @JsonProperty("temperaturaHD")
    private BigDecimal hardDiskTemperature;

    @JsonProperty("usoRAM")
    private BigDecimal usedRamPercentage;

    @Getter
    @JsonProperty("dataLeitura")
    private Instant readDate;

    @Getter
    @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant persistDate;

    @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long latency;
}
