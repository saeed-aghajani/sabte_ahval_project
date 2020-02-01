package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2020-01-30T11:48:09")
@StaticMetamodel(NationalCard.class)
public class NationalCard_ { 

    public static volatile SingularAttribute<NationalCard, Boolean> isReplica;
    public static volatile SingularAttribute<NationalCard, Boolean> isIssued;
    public static volatile SingularAttribute<NationalCard, String> firstName;
    public static volatile SingularAttribute<NationalCard, String> lastName;
    public static volatile SingularAttribute<NationalCard, String> fatherName;
    public static volatile SingularAttribute<NationalCard, Date> birthdate;
    public static volatile SingularAttribute<NationalCard, String> nid;
    public static volatile SingularAttribute<NationalCard, Date> expireDate;
    public static volatile SingularAttribute<NationalCard, Integer> id;
    public static volatile SingularAttribute<NationalCard, Date> issueDate;

}