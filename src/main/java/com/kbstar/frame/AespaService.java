package com.kbstar.frame;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AespaService<K, V> {
    /**
     * 등록 & 가입 진행
     * argument : object
     * return : null
     * **/
    @Transactional // mapper에 여러번 데이터가 입력될 때, 어느 한 곳이라도 실패하면  전체 Rollback.
    public void register (V v) throws Exception;
    @Transactional
    public void remove (K k) throws Exception;
    @Transactional
    public void modify (V v) throws Exception;
    @Transactional(readOnly = true)
    public V get (K k) throws Exception;
    @Transactional(readOnly = true)
    public List<V> get () throws Exception;
}
