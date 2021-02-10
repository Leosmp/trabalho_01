package entities;

import entities.Order;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-10T09:36:44", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, String> name;
    public static volatile ListAttribute<User, Order> orders;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SingularAttribute<User, String> email;

}