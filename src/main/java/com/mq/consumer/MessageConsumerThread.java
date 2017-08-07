package com.mq.consumer;

import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mq.connection.QueueSingletonConnection;
import com.smsgateway.SmsGateway;
import javax.jms.JMSException;
/**
 *
 * @author Gulam Mustafa
 */
public class MessageConsumerThread extends Thread {

    private static final Logger logger = LoggerFactory.getLogger(SmsGateway.class);

    public void run() {
        while (true) {
            try {
                // Create a Session
                Session session = QueueSingletonConnection.getInstance().connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                // Create the destination
                Destination destination = session.createQueue("sms");
                // Create a MessageConsumer from the Session to the Queue
                MessageConsumer consumer = session.createConsumer(destination);
                // Controller wait for 15 second for received  message 
                Message message = consumer.receive(600000);
                if (message instanceof TextMessage) {
                    SmsGateway smsGateway = new SmsGateway();
                    TextMessage textMessage = (TextMessage) message;
                    smsGateway.messageProcessor(textMessage.getText());

                }
                consumer.close();
                session.close();
            } catch (JMSException e) {
                logger.info("########Getting JMSException ####" + e);
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (Exception e) {
                // TODO Auto-generated catch block
                logger.info("########Getting Exception ####" + e);
                e.printStackTrace();
            }
        }

    }

}
