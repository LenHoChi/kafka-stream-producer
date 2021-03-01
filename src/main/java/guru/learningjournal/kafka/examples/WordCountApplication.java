//package guru.learningjournal.kafka.examples;
//
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.common.utils.Bytes;
//import org.apache.kafka.streams.KafkaStreams;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.StreamsConfig;
//import org.apache.kafka.streams.Topology;
//import org.apache.kafka.streams.kstream.KStream;
//import org.apache.kafka.streams.kstream.KTable;
//import org.apache.kafka.streams.kstream.Materialized;
//import org.apache.kafka.streams.kstream.Produced;
//import org.apache.kafka.streams.state.KeyValueStore;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//
//import java.util.Arrays;
//import java.util.Properties;
//
//public class WordCountApplication {
//    private static final Logger logger = LogManager.getLogger();
//    private static final String topicName = "hello-producer";
//    public static void main(final String[] args) throws Exception {
//
////        Properties props = new Properties();
//////        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "wordcount-application");
//////        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//////        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
//////        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
////
////        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "HelloStreams");
////        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
////        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
////        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
////
////        StreamsBuilder builder = new StreamsBuilder();
////        KStream<String, String> textLines = builder.stream("hello-producer");
////        textLines.foreach((k, v)->System.out.println(""+k+"||||"+v));
////
////        //        KTable<String, Long> wordCounts = textLines
//////                .flatMapValues(textLine -> Arrays.asList(textLine.toLowerCase().split("\\W+")))
//////                .groupBy((key, word) -> word)
//////                .count(Materialized.<String, Long, KeyValueStore<Bytes, byte[]>>as("counts-store"));
//////        wordCounts.toStream().to("WordsWithCountsTopic", Produced.with(Serdes.String(), Serdes.Long()));
////        KafkaStreams streams = new KafkaStreams(builder.build(), props);
////        streams.start();
//
//        Properties props = new Properties();
//        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "HelloStreams");
//        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass());
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass());
//
//        StreamsBuilder builder = new StreamsBuilder();
//        KStream<Integer, String> kStream = builder.stream(topicName);
//
////        KTable<String, Long> table = kStream
////                .flatMapValues(line -> Arrays.asList(line.toLowerCase().split(" ")))
////                .groupBy((keyIgnored, word)->word)
////                .count();
////        table.toStream().to("hello-producer", Produced.with(Serdes.String(),Serdes.Long()));
//
//        kStream.foreach((k, v) -> System.out.println("Key = " + k + " Value = " + v));
//        //kStream.peek((k, v) -> System.out.println("Key = " + k + " Value = " + v));
//        Topology topology = builder.build();
//
//        KafkaStreams streams = new KafkaStreams(topology, props);
//
//        logger.info("Starting the stream");
//        streams.start();
//
//        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
//            logger.info("Stopping Stream");
//            streams.close();
//        }));
//    }
//
//}