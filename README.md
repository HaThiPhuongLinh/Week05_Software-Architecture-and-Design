# Connascence Thinking
## Introduction
> This project explores the concept of connascence in software development and provides strategies for mitigating 
and managing different types of connascence, with a particular focus on the challenging aspect of connascence of identity using ActiveMQ.
## Connascence
“Two components are connascent if a change in one would require the other to be modified in order to maintain the overall correctness of the system."-MeilirPage-Jones
## Types of Connascence
![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/8c1c52fa-1666-4adf-9daf-84a0a4f5a33b)
## Properties of connascence
There are three identified properties of connascence:
1. **Strength**: The higher level of connascence, the higher the strength. Example, the strength of
connascence of Name is lower than the strength of connascence of Algorithm.
2. **Locality**: It describes how close the coupled components are. The higher connascence locality, the
better. Coupled methods that are in different modules are much worse than coupled methods within
same module.
3. **Degree**: It describes how many components are coupled. Example, if we change implementation of one
component, how many other components do we need to change.

`Connascence = Strength x Degree / Locality`

![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/07954a83-b66c-4f91-a724-e8c2773dae6a)
## Connascence of Identity
Connascence of identity appears when two or more components require to have a reference to the same instance
of an entity (object). The first example that comes in mind is a singleton, however with singleton we know by
fact that we are dealing with shared object by design. This fact is explicit and well understood. Singleton is
responsible for maintaining only one instance of its class. Therefore, when we reference a singleton this creates
static connascence very similar to referencing a variable by name. So Singleton is not a good example. 
In this project, we discuss how ActiveMQ can be utilized to address this type of connascence.

ActiveMQ and Connascence: ActiveMQ offers various security features and configurations that can help manage connascence of identity. For instance, the use of ClientId in the ActiveMQ connection factory class is crucial for logically identifying 
connections for the purposes of durable subscriptions.

![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/da98b2dd-e7cc-487a-8bc7-eda0ddd32533)

![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/35685835-77f0-4e60-9bf0-48ebfc3f71fd)

## Now we have two queues, one to send and one to receive

### 1. Queue sender
   ```js
   static void sendMsg(String message) throws NamingException, JMSException {
        Properties settings = new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //create context
        Context ctx = new InitialContext(settings);
        //lookup JMS connection factory
        ConnectionFactory factory = (ConnectionFactory)ctx.lookup("ConnectionFactory");
        //lookup destination. (If not exist-->ActiveMQ create once)
        Destination destination = (Destination) ctx.lookup("dynamicQueues/thanthidet");
        //get connection using credential
        Connection con = factory.createConnection("admin","admin");
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
        Message msg = session.createTextMessage(message);
        producer.send(msg);
        //shutdown connection
        session.close();
        con.close();
        System.out.println("Send message: " + message);
        System.out.println("Finished...");
    }
   ```
### 2. Queue receiver
   ```js
   static void receiveMsg() throws NamingException, JMSException {
        System.out.println("LISTENING FOR MESSAGE");
        Properties settings=new Properties();
        settings.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.activemq.jndi.ActiveMQInitialContextFactory");
        settings.setProperty(Context.PROVIDER_URL, "tcp://localhost:61616");
        //create context
        Context ctx = new InitialContext(settings);
        //lookup JMS connection factory
        ConnectionFactory factory=
                (ConnectionFactory)ctx.lookup("ConnectionFactory");
        //get connection using credential
        Connection connection = factory.createConnection("admin","admin");
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination= (Destination) ctx.lookup("dynamicQueues/dynamicQueues/teo");
        MessageConsumer receiver = session.createConsumer(queue);
        receiver.setMessageListener(message ->
                System.out.println("---receiver:" + message));
    }
   ```
Listening for message...

![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/75948533-f2db-42ca-bd08-0ee323e10c1d)

When a sender dispatches a message, the receiver is poised to accept it, provided both share a common destination queue. In this instance, the designated queue is "dynamicQueues/teo".

Receiver: `Destination queue = session.createQueue("dynamicQueues/teo");`

Sender:` Destination destination = (Destination) ctx.lookup("dynamicQueues/dynamicQueues/teo");`

![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/70901822-330e-40b2-96cb-7a1ce4e0484d)

#### Visualizing the Queue in ActiveMQ
Upon inspecting the ActiveMQ queue, we can glean detailed information about the queued messages

![image](https://github.com/HaThiPhuongLinh/Week05_Software-Architecture-and-Design/assets/109422010/a35f4f8e-01a4-45f4-ad11-befc8e732218)



