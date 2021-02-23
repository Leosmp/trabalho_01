package entities;

import entities.Client;
import entities.OrderItem;
import entities.Payment;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-23T15:05:50", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Integer> orderStatus;
    public static volatile SingularAttribute<Order, Client> client;
    public static volatile SingularAttribute<Order, Payment> payment;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SetAttribute<Order, OrderItem> items;
    public static volatile SingularAttribute<Order, String> moment;

}