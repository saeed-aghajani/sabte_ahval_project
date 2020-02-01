package model;

import java.math.BigInteger;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.ResponsibleInformation;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2020-01-30T11:48:09")
@StaticMetamodel(Documents.class)
public class Documents_ { 

    public static volatile SingularAttribute<Documents, BigInteger> costs;
    public static volatile SingularAttribute<Documents, Date> logDate;
    public static volatile SingularAttribute<Documents, Character> discriminatorColumn;
    public static volatile SingularAttribute<Documents, String> description;
    public static volatile SingularAttribute<Documents, ResponsibleInformation> responsibleId;
    public static volatile SingularAttribute<Documents, Integer> id;
    public static volatile SingularAttribute<Documents, Integer> discriminatorColumnId;

}