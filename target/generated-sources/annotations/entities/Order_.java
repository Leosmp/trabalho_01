package entities;

import entities.Client;
import entities.OrderItem;
import entities.Payment;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-25T18:27:49", comments="EclipseLink-2.7.8.v20201217-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-10T18:06:37", comments="EclipseLink-2.7.8.v20201217-rNA")
>>>>>>> a6f11ee5d04fb644a02cfd182c14a8f8b9f8984f
@StaticMetamodel(Order.class)
public class Order_ { 

    public static volatile SingularAttribute<Order, Integer> orderStatus;
    public static volatile SingularAttribute<Order, Client> client;
    public static volatile SingularAttribute<Order, Payment> payment;
    public static volatile SingularAttribute<Order, Long> id;
    public static volatile SetAttribute<Order, OrderItem> items;
    public static volatile SingularAttribute<Order, String> moment;

}