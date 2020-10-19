package vn.tat.ecommerce.shipping.streams;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import vn.tat.ecommerce.common.base.dto.OrderVerified;
import vn.tat.ecommerce.shipping.dto.OrderDTO;

public interface OrderShippingStream {

    public final String INPUT = "order-in";

    public final String OUTPUT = "order-verified-out";

    @Input(INPUT)
    KStream<?, OrderDTO> inboundOrder();

    @Output(OUTPUT)
    KStream<?, OrderVerified> outboundOrderVerified();

}
