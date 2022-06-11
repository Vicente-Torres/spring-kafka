package br.com.mobitbrasil.consumer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.Instant;

@Document
@ToString
public class EquipmentInfo {

    @Id
    private Long id;

    @JsonProperty("codigoEquipamento")
    private String equipmentCode;

    @JsonProperty("temperaturaHD")
    private BigDecimal hardDiskTemperature;

    @JsonProperty("usoRAM")
    private BigDecimal usedRamPercentage;

    @JsonProperty("dataLeitura")
    private Instant readDate;

    @Setter
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Instant persistDate;
}
