package com.krunch.topicsearch.cache.eventlogger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ehcache.event.CacheEvent;
import org.ehcache.event.CacheEventListener;

public class TopicsCacheEventLogger implements CacheEventListener<Object, Object> {

 Log log = LogFactory.getLog(getClass());

  @Override
  public void onEvent(
    CacheEvent<? extends Object, ? extends Object> cacheEvent) {
     log.info("CACHE_EVENT : "+ cacheEvent.getKey()+cacheEvent.getOldValue()+cacheEvent.getNewValue());
  }
}