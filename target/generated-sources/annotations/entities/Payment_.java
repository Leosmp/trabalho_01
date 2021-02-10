package entities;

import entities.Order;
import java.time.Instant;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-10T00:26:41", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Long> id;
    public static volatile SingularAttribute<Payment, Instant> moment;
    public static volatile SingularAttribute<Payment, Order> order;

}