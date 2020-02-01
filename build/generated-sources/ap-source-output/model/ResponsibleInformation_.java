package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Documents;

@Generated(value="EclipseLink-2.7.4.v20190115-rNA", date="2020-01-30T11:48:09")
@StaticMetamodel(ResponsibleInformation.class)
public class ResponsibleInformation_ { 

    public static volatile SingularAttribute<ResponsibleInformation, String> firstName;
    public static volatile SingularAttribute<ResponsibleInformation, String> lastName;
    public static volatile SingularAttribute<ResponsibleInformation, String> password;
    public static volatile SingularAttribute<ResponsibleInformation, String> nationalCode;
    public static volatile SingularAttribute<ResponsibleInformation, String> address;
    public static volatile SingularAttribute<ResponsibleInformation, String> phone;
    public static volatile SingularAttribute<ResponsibleInformation, Integer> id;
    public static volatile SingularAttribute<ResponsibleInformation, Boolean> isAdmin;
    public static volatile SingularAttribute<ResponsibleInformation, String> username;
    public static volatile ListAttribute<ResponsibleInformation, Documents> documentsList;

}