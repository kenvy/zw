package fierce.conf;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.GemFireCache;
import fierce.entity.PersonGemfire;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;
import org.springframework.data.gemfire.support.GemfireCacheManager;

import java.util.Properties;

/**
 * Created by zw on 2016/5/4
 * Email: yaoyaolingma@126.com
 */
@Configuration
@EnableCaching // cache
@EnableGemfireRepositories(
        basePackages = "fierce",
        includeFilters =
        @ComponentScan.Filter(
                type = FilterType.REGEX,
                pattern = "fierce.dao.PersonGemfireRepository")) // gemfire crud

public class GemfireConfiguration {

    @Bean
    Properties gemfireProperties() {
        Properties gemfireProperties = new Properties();
        gemfireProperties.setProperty("name", "DataGemFireApplication");
        gemfireProperties.setProperty("mcast-port", "0");
        gemfireProperties.setProperty("log-level", "config");
        return gemfireProperties;
    }

    @Bean
    CacheFactoryBean gemfireCache() {
        CacheFactoryBean gemfireCache = new CacheFactoryBean();
        gemfireCache.setClose(true);
        gemfireCache.setProperties(gemfireProperties());
        return gemfireCache;
    }

    @Bean
    LocalRegionFactoryBean<String, PersonGemfire> helloRegion(final GemFireCache cache) {
        LocalRegionFactoryBean<String, PersonGemfire> helloRegion = new LocalRegionFactoryBean<>();
        helloRegion.setCache(cache);
        helloRegion.setClose(false);
        helloRegion.setName("Quotes");
        helloRegion.setPersistent(false);
        return helloRegion;
    }

    @Bean
    GemfireCacheManager cacheManager(Cache gemfireCache) {
        GemfireCacheManager cacheManager = new GemfireCacheManager();
        cacheManager.setCache(gemfireCache);
        return cacheManager;
    }
}
