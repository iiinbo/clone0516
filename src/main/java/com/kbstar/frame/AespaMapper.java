package com.kbstar.frame;

import java.util.List;
// 최상위 mapper. (하위 mapper들이 상속받는 곳)
public interface AespaMapper<K, V>{
        public void insert(V v) throws Exception;
        public void delete(K k) throws Exception;
        public void update(V v) throws Exception;
        public V select(K k) throws Exception;
        public List<V> selectall() throws Exception;
}
