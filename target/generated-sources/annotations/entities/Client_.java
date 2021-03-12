package entities;

import entities.Order;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-25T18:27:48", comments="EclipseLink-2.7.8.v20201217-rNA")
=======
@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-03-10T18:06:37", comments="EclipseLink-2.7.8.v20201217-rNA")
>>>>>>> a6f11ee5d04fb644a02cfd182c14a8f8b9f8984f
@StaticMetamodel(Client.class)
public class Client_ extends User_ {

    public static volatile ListAttribute<Client, Order> orders;

}