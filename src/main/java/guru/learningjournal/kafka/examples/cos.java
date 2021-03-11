//package guru.learningjournal.kafka.examples;
//
//import org.apache.kafka.common.serialization.Serdes;
//import org.apache.kafka.streams.StreamsBuilder;
//import org.apache.kafka.streams.kstream.Materialized;
//import org.apache.kafka.streams.state.KeyValueStore;
//import org.apache.kafka.streams.state.QueryableStoreTypes;
//import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
//import org.graalvm.compiler.bytecode.Bytes;
//
//public class cos {
//    public void test(){
//        final StreamsBuilder builder = new StreamsBuilder();
//        GlobalKTable<String, Item> table = builder.globalTable("left-topic", Materialized.<String, Item, KeyValueStore<Bytes, byte[]>>as(
//                "global-store")
//                .withKeySerde(Serdes.String())
//                .withValueSerde(new ItemSerdes()) / value serde /
//        );
//        streamStart(builder);
//        ReadOnlyKeyValueStore view = streams.store("global-store", QueryableStoreTypes.keyValueStore());
//        KeyValueIterator<String, Item> lst = view.all();
//        while (lst.hasNext()){
//            System.out.println(lst.next());
//        }
//    }
//}
