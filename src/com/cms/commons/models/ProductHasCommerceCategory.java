
package com.cms.commons.models;

import com.alodiga.cms.commons.exception.TableNotFoundException;
import com.cms.commons.genericEJB.AbstractDistributionEntity;
import com.cms.commons.util.QueryConstants;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jose
 */
@Entity
@Table(name = "productHasCommerceCategory")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasCommerceCategory.findAll", query = "SELECT p FROM ProductHasCommerceCategory p"),
    @NamedQuery(name = "ProductHasCommerceCategory.findById", query = "SELECT p FROM ProductHasCommerceCategory p WHERE p.id = :id"),
    @NamedQuery(name = QueryConstants.COMMERCE_CATEGORY_BY_PRODUCT, query = "SELECT p FROM ProductHasCommerceCategory p WHERE p.productId.id=:productId"),
    @NamedQuery(name = QueryConstants.COMMERCE_CATEGORY_FIND_BD, query = "SELECT p FROM ProductHasCommerceCategory p WHERE p.commerceCategoryId.id = :commerceCategoryId AND p.productId.id = :productId")})
public class ProductHasCommerceCategory extends AbstractDistributionEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "commerceCategoryId", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommerceCategory commerceCategoryId;
    @JoinColumn(name = "productId", referencedColumnName = "id")
    @OneToOne(optional = false)
    private Product productId;

    public ProductHasCommerceCategory() {
    }

    public ProductHasCommerceCategory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommerceCategory getCommerceCategoryId() {
        return commerceCategoryId;
    }

    public void setCommerceCategoryId(CommerceCategory commerceCategoryId) {
        this.commerceCategoryId = commerceCategoryId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductHasCommerceCategory)) {
            return false;
        }
        ProductHasCommerceCategory other = (ProductHasCommerceCategory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.cms.commons.models.ProductHasCommerceCategory[ id=" + id + " ]";
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
