package com.smsgateway;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Gulam Mustafa
 */
public class SmsGateway {

    private static final Logger logger = LoggerFactory.getLogger(SmsGateway.class);

    public void messageProcessor(String messageContent)
            throws Exception {
        if (!messageContent.isEmpty()) {
            ExecutorService es = Executors.newFixedThreadPool(5);
            wirelessGateway(es, messageContent);
            es.shutdown();
        }
    }

    private void wirelessGateway(ExecutorService es, final String messageContent)
            throws Exception {
        es.submit(new Runnable() {
            public void run() {

                try {
                    System.out.println("--Start message Processing---");
                    JSONObject jsonFormatSMSProperites = (JSONObject) new JSONParser().parse(messageContent);
                    String rcvrMobileNumber = (String) jsonFormatSMSProperites.get("smsReceiverNumber");
                    String text = (String) jsonFormatSMSProperites.get("messageText");

                    //external smsgate Code her
                    System.out.println("MobileNumber ::" + rcvrMobileNumber);
                    System.out.println("messageBody ::" + text);
                    logger.error("MobileNumber ::" + rcvrMobileNumber);
                    logger.info("messageBody ::" + text);
                    System.out.println("-- Processing complete---");
                } catch (Exception e) {
                    logger.error("Error Occur while processing message  :{}", e);
                }

            }
        });
    }

}
