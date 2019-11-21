# Payment-System

## Relatório 

A solução implementada neste trabalho foi através de mensageria usando o RabbitMQ para Gegenciar filas entre as aplicações. 
Foi escolhida pois se tratam de transações financeiras, dados sensíveis, como também muitos clientes podem requisitar o banco
ao mesmo tempo. Se as aplicações do banco e da respectiva bandeira não estiverem disponíveis no momento, os dados ainda serão 
mantidos na fila, para depois serem processados e retornados por essas aplicações. Já em uma arquitetura cliente-servidor, 
esses dados se perderiam caso uma dessas aplicações estivesses fora do ar e fossem requisitadas.


## Testes JMeter

* ### Fila Durável:
![Screenshot](/src/main/resources/static/durable.jpg)

* ### Fila Não Durável:
![Screenshot](/src/main/resources/static/nodurable.png)

## Feito Com:

* [ Spring Framework ](https://spring.io/)
* [ RabbbitMQ ](https://www.rabbitmq.com/)

## Autores:

* [ Marlon Fernando ](https://github.com/marlonfernando16)
* [ John Oliver ](https://github.com/johnOliver23/)
