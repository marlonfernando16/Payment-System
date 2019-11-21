package com.example.PaymentSystem;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class BancoProducerService {
	
	
	public void createQueue(String pagamento_json) throws Exception{
		System.out.println("Inicio Produtor Banco");
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);

        try (Connection connection = connectionFactory.newConnection();Channel channel = connection.createChannel()) {
        	Gson g = new Gson();
            Banco b = (Banco)g.fromJson(pagamento_json, Banco.class);
        	((com.rabbitmq.client.Channel) channel).queueDeclare(b.getBandeira(),true, false, false, null);
            ((com.rabbitmq.client.Channel) channel).basicPublish("",b.getBandeira(), MessageProperties.PERSISTENT_TEXT_PLAIN, pagamento_json.getBytes());
            System.out.println("Enviando mensagem para fila do visa: " + pagamento_json);

        }
        System.out.println("Fim Produtor Banco");

    }
}
