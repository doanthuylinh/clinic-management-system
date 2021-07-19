/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hellocs.clinic_management_system.bean.MedicineEntity;
import hellocs.clinic_management_system.bean.ResultBean;
import hellocs.clinic_management_system.dao.MedicineDao;
import hellocs.clinic_management_system.service.MedicineService;
import hellocs.clinic_management_system.utils.ApiValidateException;
import hellocs.clinic_management_system.utils.DataUtils;
import hellocs.clinic_management_system.utils.MessageUtils;
import hellocs.clinic_management_system.utils.ValidateUtils;

/**
 * [OVERVIEW] Medicine Service Implementation.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
*/
@Service
@Transactional
public class MedicineServiceImpl implements MedicineService {

    @Autowired
    private MedicineDao medicineDao;
    /**
     * addMedicine
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    @Override
    public ResultBean addMedicine(String data) throws ApiValidateException {
        MedicineEntity medicine = DataUtils.getEntityByJsonString(data, MedicineEntity.class);
        
        ValidateUtils.validateAddMedicine(medicine);
        
        return new ResultBean(medicineDao.addMedicine(medicine), "201", MessageUtils.getMessage("MSG02", "medicine"));
    }

}
