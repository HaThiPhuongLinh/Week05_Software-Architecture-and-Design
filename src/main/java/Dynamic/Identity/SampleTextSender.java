package Dynamic.Identity;

import jakarta.jms.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class SampleTextSender {
    public static void main(String[] args) throws NamingException, JMSException {
        SampleTextSender.sendMsg("Welcome to ActiveMQ");
    }

    static void sendMsg(String message) throws NamingException, JMSException {
        Properties settings=new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //create context
        Context ctx=new InitialContext(settings);
        //lookup JMS connection factory
        ConnectionFactory factory=
                (ConnectionFactory)ctx.lookup("ConnectionFactory");
        //lookup destination. (If not exist-->ActiveMQ create once)
        Destination destination=
                (Destination) ctx.lookup("dynamicQueues/thanthidet");
        //get connection using credential
        Connection con=factory.createConnection("admin","admin");
        //connect to MOM
        con.start();
        //create session
        Session session=con.createSession(
                /*transaction*/false,
                /*ACK*/Session.AUTO_ACKNOWLEDGE
        );
        //create producer
        MessageProducer producer = session.createProducer(destination);
        //create text message
        Message msg=session.createTextMessage(message);
        producer.send(msg);
        //shutdown connection
        session.close();
        con.close();
        System.out.println("Finished...");
    }
}
