package com.question.services;

import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;
import org.springframework.stereotype.Component;

import jakarta.persistence.EntityManagerFactory;



@Component
public class HibernateCacheStatsLogger {

    private final Statistics statistics;

    public HibernateCacheStatsLogger(EntityManagerFactory entityManagerFactory) {
        this.statistics = entityManagerFactory.unwrap(SessionFactory.class).getStatistics();
        this.statistics.setStatisticsEnabled(true); 
    }

    public void logCacheStats() {
        System.out.println("Cache Enabled: " + statistics.isStatisticsEnabled());
        System.out.println("Cache Hit Count: " + statistics.getSecondLevelCacheHitCount());
        System.out.println("Cache Miss Count: " + statistics.getSecondLevelCacheMissCount());
        System.out.println("Cache Put Count: " + statistics.getSecondLevelCachePutCount());
    }
}

