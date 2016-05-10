package fierce.conf;

import fierce.entity.PersonBatch;
import fierce.service.impl.JobCompletionNotificationListener;
import fierce.service.impl.PersonItemProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * Created by zw on 2016/5/10
 * Email: yaoyaolingma@126.com
 */
@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;

    // tag::readerwriterprocessor[]
    @Bean
    public FlatFileItemReader<PersonBatch> reader() {
        FlatFileItemReader<PersonBatch> reader = new FlatFileItemReader<PersonBatch>();
        reader.setResource(new ClassPathResource("sample-data.csv"));
        reader.setLineMapper(new DefaultLineMapper<PersonBatch>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"firstName", "lastName"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<PersonBatch>() {{
                setTargetType(PersonBatch.class);
            }});
        }});
        return reader;
    }

    @Bean
    public PersonItemProcessor processor() {
        return new PersonItemProcessor();
    }

    @Bean
    public JdbcBatchItemWriter<PersonBatch> writer() {
        JdbcBatchItemWriter<PersonBatch> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO people (first_name, last_name) VALUES (:firstName, :lastName)");
        writer.setDataSource(dataSource);
        return writer;
    }
    // end::readerwriterprocessor[]

    // tag::listener[]

    @Bean
    public JobExecutionListener listener() {
        return new JobCompletionNotificationListener(jdbcTemplate);
    }

    // end::listener[]

    // tag::jobstep[]
    @Bean
    public Job importUserJob() {
        return jobBuilderFactory.get("importUserJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<PersonBatch, PersonBatch>chunk(10)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }
    // end::jobstep[]
}
