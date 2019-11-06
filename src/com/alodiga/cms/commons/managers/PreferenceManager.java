package com.alodiga.cms.commons.managers;
import com.cms.commons.genericEJB.EJBRequest;
import com.cms.commons.util.EJBServiceLocator;
import com.cms.commons.util.EjbConstants;
import com.cms.commons.util.QueryConstants;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("all")
public class PreferenceManager {

    private static PreferenceManager instance;
    private Map<Long, String> preferences = new HashMap<Long, String>();
//    private PreferencesEJB preferencesEJB;
//
//    public static synchronized PreferenceManager getInstance() throws Exception {
//        if (instance == null) {
//            instance = new PreferenceManager();
//        }
//        return instance;
//    }
//
//    public static void refresh() throws Exception {
//        instance = new PreferenceManager();
//    }
//
//    private PreferenceManager() throws Exception {
//
//        preferencesEJB = (PreferencesEJB) EJBServiceLocator.getInstance().get(EjbConstants.PREFERENCES_EJB);
//        EJBRequest request = new EJBRequest();
//        Map params = new HashMap<String, Object>();
//        params.put(QueryConstants.PARAM_ENTERPRISE_ID, Enterprise.ALODIGA_USA);
//        request.setParams(params);
//        try {
//            preferences = preferencesEJB.getLastPreferenceValues(request);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getPreferenceValueByPreferenceId(Long preferenceFielId) {
//        return preferences.get(preferenceFielId);
//    }
//
//    public Map<Long, String> getPreferences() {
//        return preferences;
//    }
}
