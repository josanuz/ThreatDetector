package ac.cr.tec.tds.common;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class Util {


    public static class Tuple<T, K>{
        public T _t;
        public K _k;

        public Tuple(T _t, K _k) {
            this._t = _t;
            this._k = _k;
        }

        public static  <X,Y> Tuple<X,Y> from(X _x, Y _y){
            return new Tuple<>(_x, _y);
        }

        public void consume(BiConsumer<T,K> consumer){
            consumer.accept(_t, _k);
        }

        public <V> V map(BiFunction<T,K,V> consumer){
            return consumer.apply(_t, _k);
        }
    }

    public static class KeyValue<KeyType, ValueType>{

        public KeyType key;
        public ValueType value;

        public KeyValue(KeyType key, ValueType value) {
            this.key = key;
            this.value = value;
        }

        public static  <X,Y> KeyValue<X,Y> from(X _x, Y _y){
            return new KeyValue<>(_x, _y);
        }

        public void consume(BiConsumer<KeyType,ValueType> consumer){
            consumer.accept(key, value);
        }

        public <T> T map(BiFunction<KeyType,ValueType, T> consumer){
            return consumer.apply(key, value);
        }

    }

}