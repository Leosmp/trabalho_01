package entities;

import entities.Category;
import entities.OrderItem;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-25T18:27:48", comments="EclipseLink-2.7.8.v20201217-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-10T18:06:37", comments="EclipseLink-2.7.8.v20201217-rNA")
>>>>>>> a6f11ee5d04fb644a02cfd182c14a8f8b9f8984f
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