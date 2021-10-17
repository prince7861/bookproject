package com.sampana.thirdassignment;

import com.sampana.Book;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.xstream.XStreamMarshaller;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableBatchProcessing
public class BatchXmlToDb {
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private DataSource dataSource;

    @Bean
    public BookProcessor processor(){
        return new BookProcessor();
    }
    @Bean
    public StaxEventItemReader<Book> reader() throws ClassNotFoundException {
        StaxEventItemReader<Book> reader=new StaxEventItemReader<Book>();
        reader.setResource(new ClassPathResource("Book.xml"));
        reader.setFragmentRootElementName("books");

        Map<String,String> aliasesMap= new HashMap<String,String>();
        aliasesMap.put("books","com.sampana.Book");
        XStreamMarshaller  marshaller=new XStreamMarshaller();
            marshaller.setAliases(aliasesMap);

        reader.setUnmarshaller(marshaller);
    return reader;
    }
    @Bean
    public JdbcBatchItemWriter<Book> writer()
    {
        JdbcBatchItemWriter<Book> writer= new JdbcBatchItemWriter<Book>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO books(bid,auther,btitle,category,isbn,no_of_pages,price,publisher,release_date,year) VALUES(?,?,?,?,?,?,?,?,?,?)");
        writer.setItemPreparedStatementSetter(new BookPreparedStatement());
        return writer;
    }

    @Bean
    public Step step1() throws ClassNotFoundException {
        return stepBuilderFactory.get("step1").<Book,Book>chunk(100).reader(reader()).processor(processor()).writer(writer()).build();
        }


    @Bean
    public Job exportBookJob() throws ClassNotFoundException {
        return jobBuilderFactory.get("importBookJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
    }
}
