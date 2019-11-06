package com.cms.commons.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.genericEJB.DistributionEntityListerner;
import com.cms.commons.util.QueryConstants;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@EntityListeners(DistributionEntityListerner.class)
@Table(name = "account")
@NamedQueries({
    @NamedQuery(name = QueryConstants.VALIDATE_ACCOUNT,
    query = "SELECT a FROM Account a"),
   
})
public class Account extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;
    private String name;
    private String lastName;
    private String age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public Object getPk() {
        return getId();
    }

    @Override
    public String getTableName() throws TableNotFoundException {
        return super.getTableName(this.getClass());
    }
}
