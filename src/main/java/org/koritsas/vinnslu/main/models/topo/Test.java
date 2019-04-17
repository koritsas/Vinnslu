package org.koritsas.vinnslu.main.models.topo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Test implements Serializable {

    @Id
    @GenericGenerator(
            name = "test_generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "test_seq"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "1")
            }

    )
    @GeneratedValue(generator = "test_generator")
    private Long id;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    private String field6;

    private String field7;
}
