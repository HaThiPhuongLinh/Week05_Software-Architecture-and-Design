package Dynamic.Identity;

import jakarta.jms.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class SampleTextReceiver {

    public static void main(String[] args) throws NamingException, JMSException {
        SampleTextReceiver.receiveMsg();
    }

    static void receiveMsg() throws NamingException, JMSException {
        System.out.println("LISTENING FOR MESSAGE...");
        Properties settings = new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //create context
        Context ctx = new InitialContext(settings);
        //lookup JMS connection factory
        ConnectionFactory factory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
        //get connection using credential
        Connection connection = factory.createConnection("admin", "admin");
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination queue = session.createQueue("dynamicQueues/teo");
        MessageConsumer receiver = session.createConsumer(queue);
        receiver.setMessageListener(message -> {
            try {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("---receiver:" + text);
            } catch (JMSException e) {
                throw new RuntimeException(e);
            }
        });
    }

}
