———————————————————————————————————————————————————————————————————————————————————————————————————————————
1-Which JMS API should I use when I develop a JMS client of activemq?
Current activemq version is 
<dependency>
  <groupId>org.apache.activemq</groupId>
  <artifactId>activemq-all</artifactId>
  <version>5.14.4</version>
</dependency>

Look the source code of activemq and find it depends on
      <dependency>
        <groupId>org.apache.geronimo.specs</groupId>
        <artifactId>geronimo-jms_1.1_spec</artifactId>
        <version>1.1.1</version>
      </dependency>
and there is a sub module
      <dependency>
        <groupId>org.apache.activemq</groupId>
        <artifactId>activemq-client</artifactId>
        <version>${project.version}</version>
      </dependency>
So every thing clear. If you use activemq-client you even don’t need to inherit geronimo-jms_1.1_spec.

Activemq supports JMS 1.1 specification, and it does not support JMS 2.0.
JMS 1.1 is called classic JMS API.
JMS 2.0 is called simplified JMS API.
———————————————————————————————————————————————————————————————————————————————————————————————————————————
2-All support protocols (http://activemq.apache.org/uri-protocols.html)

TCP - Client connect to broker - tcp://host:port









