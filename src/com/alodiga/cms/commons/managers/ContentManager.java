package com.alodiga.cms.commons.managers;


import com.alodiga.cms.commons.exception.NullParameterException;

import com.cms.commons.util.EJBServiceLocator;
import com.cms.commons.util.EjbConstants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class ContentManager {

    private static ContentManager instance;
//    private Map<Long, List<Banner>> bannersByTypeId;
//    private List<BannerType> bannerTypes;
//    private List<Banner> banners;
//    private BannerEJB bannerEJB;

    public static synchronized ContentManager getInstance() throws Exception {
        if (instance == null) {
            instance = new ContentManager();
        }
        return instance;
    }

    public static void refresh() throws Exception {
        instance = new ContentManager();
    }

    private ContentManager() throws Exception {
//        banners = new ArrayList<Banner>();
//        bannerTypes = new ArrayList<BannerType>();
//        bannersByTypeId = new HashMap<Long, List<Banner>>();
//        bannerEJB = (BannerEJB) EJBServiceLocator.getInstance().get(EjbConstants.BANNER_EJB);
//        bannerTypes = bannerEJB.getBannerTypes();
//        for (BannerType bannerType : bannerTypes) {
//            try {
//                banners = bannerEJB.getBannersByType(bannerType.getId());
//                bannersByTypeId.put(bannerType.getId(), banners);
//            } catch (Exception ex) {
//                ex.printStackTrace();
//            }
//        }
    }

//    public List<Banner> getBannersByTypeId(Long bannerTypeId) throws NullParameterException{
//        if(bannerTypeId == null){
//            throw new NullParameterException("Parameter bannerTypeId cannot be null");
//        }
//        return bannersByTypeId.get(bannerTypeId);
//    }
}
