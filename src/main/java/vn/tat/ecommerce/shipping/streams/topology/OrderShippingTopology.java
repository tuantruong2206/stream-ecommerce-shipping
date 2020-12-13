package vn.tat.ecommerce.shipping.streams.topology;

import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Serialized;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import vn.tat.ecommerce.common.base.dto.OrderVerified;
import vn.tat.ecommerce.common.base.enumeration.Status;
import vn.tat.ecommerce.shipping.dto.OrderDTO;
import vn.tat.ecommerce.shipping.streams.OrderShippingStream;


import java.util.Date;

@EnableBinding(OrderShippingStream.class)
public class OrderShippingTopology {

    private final Logger log = LoggerFactory.getLogger(OrderShippingTopology.class);

    private final static String SERVICE_NAME = "SHIPPING_ORDER_VERIFIED";

    @StreamListener
    @SendTo(OrderShippingStream.OUTPUT)
    public KStream<Byte, OrderVerified> shippingOrderProcess(@Input(OrderShippingStream.INPUT)KStream<Byte, OrderDTO> inputOrderStream) {
        inputOrderStream.foreach((key, value) -> log.info("SHIPPING ORDER VERIFIED {}", value));
        return inputOrderStream.filter((key, value) -> !value.getUserid().contains("111")).map((key, value) -> new KeyValue<>(null, new OrderVerified(value.getUserid(), Status.VERIFIED, 0L, SERVICE_NAME,new Date(), new Date())));
    }


}
