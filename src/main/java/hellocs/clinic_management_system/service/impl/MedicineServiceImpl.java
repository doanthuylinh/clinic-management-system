/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hellocs.clinic_management_system.bean.MedicineEntity;
import hellocs.clinic_management_system.bean.ResultBean;
import hellocs.clinic_management_system.dao.MedicineDao;
import hellocs.clinic_management_system.service.MedicineService;
import hellocs.clinic_management_system.utils.ApiValidateException;
import hellocs.clinic_management_system.utils.ConstantColumn;
import hellocs.clinic_management_system.utils.DataUtils;
import hellocs.clinic_management_system.utils.MessageUtils;
import hellocs.clinic_management_system.utils.ValidateUtils;

/**
 * [OVERVIEW] Medicine Service Implementation.
 *
 * @author: LinhDT
 * @version: 1.3
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
 * 002       1.1       2021/07/20      LinhDT             getMedicineById, getListMedicine
 * 003       1.2       2021/07/22      LinhDT             updateMedicine
 * 004       1.3       2021/07/23      LinhDT             deleteMedicine
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

    /**
     * getMedicineById
     * @author: LinhDT
     * @param medicineId
     * @return
     * @throws ApiValidateException
     */
    @Override
    public ResultBean getMedicineById(Integer medicineId) throws ApiValidateException {
        MedicineEntity medicine = medicineDao.getMedicineEntityById(medicineId);
        if (Objects.isNull(medicine)) {
            return new ResultBean("ERR02", MessageUtils.getMessage("ERR02"));
        }
        return new ResultBean(medicine, "200", MessageUtils.getMessage("MSG01", new Object[] { "medicine by ID" }));
    }

    /**
     * getListMedicine
     * @author: LinhDT
     * @return
     * @throws ApiValidateException
     */
    @Override
    public ResultBean getListMedicine() throws ApiValidateException {
        List<MedicineEntity> listMedicine = medicineDao.getListMedicine();
        if (Objects.isNull(listMedicine)) {
            return new ResultBean("ERR02", MessageUtils.getMessage("ERR02"));
        }
        return new ResultBean(listMedicine, "200", MessageUtils.getMessage("MSG01", new Object[] { "list medicine" }));
    }

    /**
     * updateMedicine
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    @Override
    public ResultBean updateMedicine(String data) throws ApiValidateException {
        MedicineEntity medicineEntity = DataUtils.getEntityByJsonString(data, MedicineEntity.class);
        ValidateUtils.validateAddMedicine(medicineEntity);
        return new ResultBean(medicineDao.updateMedicine(medicineEntity), "200", MessageUtils.getMessage("MSG03", "medicine"));
    }

    /**
     * deleteMedicine
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    @Override
    public ResultBean deleteMedicine(String data) throws ApiValidateException {
        Integer medicineId = DataUtils.getAsIntegerByJsonString(data, ConstantColumn.MEDICINE_ID);
        medicineDao.deleteMedicine(medicineId);
        return new ResultBean("200", MessageUtils.getMessage("MSG04", "medicine"));
    }

}
