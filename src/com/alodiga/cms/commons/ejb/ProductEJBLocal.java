package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.DisabledAccountException;
import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Local;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.CommerceCategory;
import com.cms.commons.models.LevelProduct;
import com.cms.commons.models.Product;
import com.cms.commons.models.ProductType;
import com.cms.commons.models.ProductUse;
import com.cms.commons.models.SegmentCommerce;
import com.cms.commons.models.SegmentMarketing;
import com.cms.commons.models.StorageMedio;
import java.util.List;

/**
 *
 * @author Yoan Leon
 */
@Local
public interface ProductEJBLocal extends DistributionGenericEJB {
    
    //Product
    public List< Product> getProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Product loadProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Product saveProduct(Product product) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ProductType
    public List< ProductType> getProductTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductType loadProductType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductType saveProductType(ProductType productType) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //LevelProduct
    public List< LevelProduct> getLevelProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public LevelProduct loadLevelProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public LevelProduct saveLevelProduct(LevelProduct levelProduct) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ProductUse
    public List<ProductUse> getProductUse(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductUse loadProductUse(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductUse saveProductUse(ProductUse productUse) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //StorageMedio
    public List<StorageMedio> getStorageMedio(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StorageMedio loadStorageMedio(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StorageMedio saveStorageMedio(StorageMedio storageMedio) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //SegmentMarketing
    public List<SegmentMarketing> getSegmentMarketing(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SegmentMarketing loadSegmentMarketing(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SegmentMarketing saveSegmentMarketing(SegmentMarketing segmentMarketing) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //SegmentCommerce
    public List<SegmentCommerce> getSegmentCommerce(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public SegmentCommerce loadSegmentCommerce(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public SegmentCommerce saveSegmentCommerce(SegmentCommerce segmentCommerce) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //CommerceCategory
    public List<CommerceCategory> getCommerceCategory(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public CommerceCategory loadCommerceCategory(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public CommerceCategory saveCommerceCategory(CommerceCategory commerceCategory) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<CommerceCategory> getCommerceCategoryBySegmentCommerce(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
}
