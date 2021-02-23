package entities.pk;

import entities.Order;
import entities.Product;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-23T15:05:50", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(OrderItemPK.class)
public class OrderItemPK_ { 

    public static volatile SingularAttribute<OrderItemPK, Product> product;
    public static volatile SingularAttribute<OrderItemPK, Order> order;

}