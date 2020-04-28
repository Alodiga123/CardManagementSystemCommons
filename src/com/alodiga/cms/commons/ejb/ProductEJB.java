package com.alodiga.cms.commons.ejb;

import com.alodiga.cms.commons.exception.EmptyListException;
import javax.ejb.Remote;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.genericEJB.DistributionGenericEJB;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.models.Channel;
import com.cms.commons.models.CommerceCategory;
import com.cms.commons.models.GeneralRate;
import com.cms.commons.models.LevelProduct;
import com.cms.commons.models.Product;
import com.cms.commons.models.ProductHasChannelHasTransaction;
import com.cms.commons.models.ProductHasCommerceCategory;
import com.cms.commons.models.ProductType;
import com.cms.commons.models.ProductUse;
import com.cms.commons.models.RateApplicationType;
import com.cms.commons.models.RateByProduct;
import com.cms.commons.models.SegmentCommerce;
import com.cms.commons.models.SegmentMarketing;
import com.cms.commons.models.StorageMedio;
import com.cms.commons.models.Transaction;
import com.cms.commons.models.RateByProgram;
import com.cms.commons.models.ApprovalGeneralRate;
import com.cms.commons.models.ApprovalProgramRate;
import com.cms.commons.models.StatusProduct;
import java.util.List;

/**
 *
 * @author Yoan Leon
 */
@Remote
public interface ProductEJB extends DistributionGenericEJB {

    //Product
    public List< Product> getProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Product loadProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Product saveProduct(Product product) throws RegisterNotFoundException, NullParameterException, GeneralException;    
    public List<Product> getProductByProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
        
    //ProductType
    public List< ProductType> getProductTypes(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductType loadProductType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductType saveProductType(ProductType productType) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //LevelProduct
    public List<LevelProduct> getLevelProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
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
    
    //ProductHasCommerceCategory
    public List<ProductHasCommerceCategory> getProductHasCommerceCategory(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductHasCommerceCategory loadProductHasCommerceCategory(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductHasCommerceCategory saveProductHasCommerceCategory(ProductHasCommerceCategory productHasCommerceCategory) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<ProductHasCommerceCategory> getCommerceCategoryByProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProductHasCommerceCategory> getProductHasCommerceCategoryBD(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;

    //ProductHasChannelHasTransaction
    public List<ProductHasChannelHasTransaction> getProductHasChannelHasTransaction(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<ProductHasChannelHasTransaction> getProductHasChannelHasTransactionByProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ProductHasChannelHasTransaction loadProductHasChannelHasTransaction(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ProductHasChannelHasTransaction saveProductHasChannelHasTransaction(ProductHasChannelHasTransaction productHasChannelHasTransaction) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //Transaction
    public List<Transaction> getTransaction(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Transaction loadTransaction(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Transaction saveTransaction(Transaction transaction) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //Channel
    public List<Channel> getChannel(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public Channel loadChannel(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public Channel saveChannel(Channel channel) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //GeneralRate
    public List<GeneralRate> getGeneralRate(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<GeneralRate> getGeneralRateByProductType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public GeneralRate loadGeneralRate(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public GeneralRate saveGeneralRate(GeneralRate generalRate) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //RateApplicationType
    public List<RateApplicationType> getRateApplicationType(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RateApplicationType loadRateApplicationType(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RateApplicationType saveRateApplicationType(RateApplicationType rateApplicationType) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //RateByProgram
    public List<RateByProgram> getRateByProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<RateByProgram> getRateByProgramByTransactionByChannel(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public List<RateByProgram> getRateByProgramByProgram(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RateByProgram loadRateByProgram(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RateByProgram saveRateByProgram(RateByProgram rateByProgram) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //RateByProduct
    public List<RateByProduct> getRateByProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public RateByProduct loadRateByProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public RateByProduct saveRateByProduct(RateByProduct rateByProduct) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public List<RateByProduct> getRateByProductByProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    
    //ApprovalGeneralRate
    public List<ApprovalGeneralRate> getApprovalGeneralRate(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ApprovalGeneralRate loadApprovalGeneralRate(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ApprovalGeneralRate saveApprovalGeneralRate(ApprovalGeneralRate approvalGeneralRate) throws RegisterNotFoundException, NullParameterException, GeneralException;
    
    //ApprovalProgramRate
    public List<ApprovalProgramRate> getApprovalProgramRate(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public ApprovalProgramRate loadApprovalProgramRate(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public ApprovalProgramRate saveApprovalProgramRate(ApprovalProgramRate approvalProgramRate) throws RegisterNotFoundException, NullParameterException, GeneralException;

    //StatusProduct
    public List<StatusProduct> getStatusProduct(EJBRequest request) throws EmptyListException, GeneralException, NullParameterException;
    public StatusProduct loadStatusProduct(EJBRequest request) throws RegisterNotFoundException, NullParameterException, GeneralException;
    public StatusProduct saveStatusProduct(StatusProduct statusProduct) throws RegisterNotFoundException, NullParameterException, GeneralException; 

}
