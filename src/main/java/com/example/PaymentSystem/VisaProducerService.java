package com.example.PaymentSystem;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class VisaProducerService {

	public void createQueue(String pagamento) throws Exception{
		ConnectionFactory connectionFactory = new ConnectionFactory();

		connectionFactory.setHost("localhost");
		connectionFactory.setPort(5672);

		String NOME_FILA = "send_bandeira_banco";
		try(           
				Connection connection = connectionFactory.newConnection();
				Channel channel = connection.createChannel()) {
			channel.basicPublish("", NOME_FILA,MessageProperties.PERSISTENT_TEXT_PLAIN, pagamento.getBytes());
			System.out.println("Mensagem de Pagamento: " + pagamento);
			channel.queueDeclare(NOME_FILA, true, false, false, null);
		}
	}
	
}
	