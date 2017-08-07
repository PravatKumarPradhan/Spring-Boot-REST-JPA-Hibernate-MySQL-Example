package com.mq.connection;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Gulam Mustafa
 */
public class QueueSingletonConnection {

    private static final Logger logger = LoggerFactory.getLogger(QueueSingletonConnection.class);
    private static QueueSingletonConnection singleInstance;
    public ConnectionFactory connectionFactory;
    public Connection connection;

    private QueueSingletonConnection() {
        try {
            String user = ActiveMQConnection.DEFAULT_USER;
            String password = ActiveMQConnection.DEFAULT_PASSWORD;
            String brokerURI = ActiveMQConnectionFactory.DEFAULT_BROKER_URL;
            //  String brokerURI = "tcp://localhost:61616";
            logger.info("Create a Connection");
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, brokerURI);

            logger.info("Create a Connection");
            this.connection = connectionFactory.createConnection();
            this.connection.start();
            logger.info("Create a Connection");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static QueueSingletonConnection getInstance() {
        if (singleInstance == null) {
            synchronized (QueueSingletonConnection.class) {
                if (singleInstance == null) {
                    singleInstance = new QueueSingletonConnection();
                }
            }
        }
        return singleInstance;
    }
}
