package com.example.PaymentSystem;


import java.util.Map;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;


public class VisaConsumerService {
	
    public static void main(String[] args) throws Exception {
        
    	System.out.println("Inicio Consumidor Visa");
        
    	String FILA_BANCO_VISA = "visa";
        
    	ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        Connection connection = connectionFactory.newConnection();
        Channel canal = connection.createChannel();
        canal.queueDeclare(FILA_BANCO_VISA, true, false, false, (Map)null);
        
        
        DeliverCallback callback = (consumerTag, delivery) -> {
            String msgJson = new String(delivery.getBody());
            System.out.println("Recebendo mensagem da fila: " + msgJson);
            
            Gson g = new Gson();
            Banco b = (Banco)g.fromJson(msgJson, Banco.class);

            System.out.println(b.toString());

            String msgretorno = "Pagamento com cartao "+ b.getBandeira() + " realizado com sucesso!";
            System.out.println(msgretorno);
            
            try {
                new VisaProducerService().createQueue(msgJson);
            }catch (Exception e){
                System.out.println(e);
            }

        };
        canal.basicConsume(FILA_BANCO_VISA, true, callback, (consumerTag) -> {
        });
        System.out.println("Fim Consumidor Visa");
    }
}	
