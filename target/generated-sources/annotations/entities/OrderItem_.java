package entities;

import entities.pk.OrderItemPK;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-06T23:31:07", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(OrderItem.class)
public class OrderItem_ { 

    public static volatile SingularAttribute<OrderItem, Integer> quantity;
    public static volatile SingularAttribute<OrderItem, Double> price;
    public static volatile SingularAttribute<OrderItem, OrderItemPK> id;

}