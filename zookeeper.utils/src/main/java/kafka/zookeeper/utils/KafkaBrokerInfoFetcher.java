package kafka.zookeeper.utils;
import org.apache.zookeeper.ZooKeeper;
import java.util.*;

// To get the list of brokers in the kafka cluster

public class KafkaBrokerInfoFetcher {

    public static void main(String[] args) throws Exception {
       // ZooKeeper zk = new ZooKeeper("localhost:2181", 10000, null);
    	 ZooKeeper zk = new ZooKeeper("slave1:2181,slave2:2181,master:2181", 10000, null);
        List<String> ids = zk.getChildren("/brokers/ids", false);
        for (String id : ids) {
            String brokerInfo = new String(zk.getData("/brokers/ids/" + id, false, null));
            System.out.println(id + ": " + brokerInfo);
        }
    }
}
