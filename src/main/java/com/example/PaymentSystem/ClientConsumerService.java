package com.example.PaymentSystem;

import java.util.Map;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class ClientConsumerService {

	public static String FILA_BANDEIRA_CLIENTE = "send_bandeira_cliente";
	
	public static void main(String[] args) throws Exception {
        System.out.println("Inicio Consumidor Cliente");
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel canal = connection.createChannel();
        DeliverCallback callback = (consumerTag, delivery) -> {
            String msg = new String(delivery.getBody());
            System.out.println(msg + "deu bom");
            Gson g = new Gson();
            Banco b = (Banco)g.fromJson(msg, Banco.class);
            System.out.println(b);
           
        };
        canal.queueDeclare(FILA_BANDEIRA_CLIENTE, true, false, false, (Map)null);
        canal.basicConsume(FILA_BANDEIRA_CLIENTE, true, callback, (consumerTag) -> {
        });
        System.out.println("Fim Consumidor Cliente");
    }

}
