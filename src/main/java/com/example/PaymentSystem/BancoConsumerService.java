package com.example.PaymentSystem;

import java.util.Map;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

public class BancoConsumerService {

	public static String FILA_BANDEIRA_BANCO = "send_bandeira_banco";
	
	public static void main(String[] args) throws Exception {
        System.out.println("Inicio Consumidor Banco");
        
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel canal = connection.createChannel();
        DeliverCallback callback = (consumerTag, delivery) -> {
            String msg = new String(delivery.getBody());
            System.out.println(msg + "Bandeira processa e envia para o banco de volta.");
            Gson g = new Gson();
            Banco b = (Banco)g.fromJson(msg, Banco.class);
            System.out.println(b);
            
        };
        canal.queueDeclare(FILA_BANDEIRA_BANCO, true, false, false, (Map)null);
        canal.basicConsume(FILA_BANDEIRA_BANCO, true, callback, (consumerTag) -> {
        });
        System.out.println("Fim Consumidor Cliente");
    }

}
