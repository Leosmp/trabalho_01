package entities;

import entities.Order;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2021-02-24T15:45:56", comments="EclipseLink-2.7.8.v20201217-rNA")
@StaticMetamodel(Client.class)
public class Client_ extends User_ {

    public static volatile ListAttribute<Client, Order> orders;

}