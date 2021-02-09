package entities;

import entities.Category;
import entities.OrderItem;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-09T16:06:16", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> imgUrl;
    public static volatile SingularAttribute<Product, Double> price;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, String> description;
    public static volatile SingularAttribute<Product, Long> id;
    public static volatile SetAttribute<Product, Category> categories;
    public static volatile SetAttribute<Product, OrderItem> items;

}