package fierce.service.impl;

import fierce.entity.PersonBatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

/**
 * Created by zw on 2016/5/10
 * Email: yaoyaolingma@126.com
 */
public class PersonItemProcessor implements ItemProcessor<PersonBatch, PersonBatch> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public PersonBatch process(final PersonBatch person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();

        final PersonBatch transformedPerson = new PersonBatch(firstName, lastName);

        log.info("Converting (" + person + ") into (" + transformedPerson + ")");

        return transformedPerson;
    }

}
