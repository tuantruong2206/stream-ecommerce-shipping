package vn.tat.ecommerce.shipping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;
import vn.tat.ecommerce.common.base.enumeration.Status;

import java.time.Instant;

@Data
@ToString
@Builder
@AllArgsConstructor

public class OrderDTO {

    public OrderDTO() {}
    private String userid;
    private Long basketId;
    private Double amount;
    private Status status;
    private Instant createdAt;
    private Instant updatedAt;

}
