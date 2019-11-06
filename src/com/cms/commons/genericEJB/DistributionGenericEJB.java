package com.cms.commons.genericEJB;

import javax.ejb.Remote;

//INTERFAZ DE METODOS NO NECESARIAMENTE REMOTOS
@Remote
public interface DistributionGenericEJB {

    void init();

    public boolean echo() throws Exception;
}
