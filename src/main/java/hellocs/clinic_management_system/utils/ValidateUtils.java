/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.utils;

import hellocs.clinic_management_system.bean.MedicineEntity;

/**
 * [OVERVIEW] Validate Utilities.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
*/
public class ValidateUtils {

    /**
     * validateAddMedicine
     * @author: LinhDT
     * @param medicine
     * @throws ApiValidateException
     */
    public static void validateAddMedicine(MedicineEntity medicine) throws ApiValidateException {

        if (DataUtils.isNullOrEmpty(medicine.getMedicineName())) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.MEDICINE_NAME));
        }

        if (DataUtils.isNullOrEmpty(medicine.getQuantityAcquired())) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.QUANTITY_ACQUIRED));
        }

        if (DataUtils.isNullOrEmpty(medicine.getUnitValue())) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.UNIT));
        }

        if (DataUtils.isNullOrEmpty(medicine.getQuantityInStock())) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.QUANTITY_IN_STOCK));
        }

        if (medicine.getUnitValue() != 4) {
            if (DataUtils.isNullOrEmpty(medicine.getQuantityPerUnit())) {
                throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.QUANTITY_PER_UNIT));
            }
        } else {
            medicine.setQuantityPerUnit(1);
        }

        if (DataUtils.isNullOrEmpty(medicine.getAcquiredPricePerCount())) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.ACQUIRED_PRICE_PER_COUNT));
        }

        if (DataUtils.isNullOrEmpty(medicine.getSellPricePerCount())) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", ConstantColumn.SELL_PRICE_PER_COUNT));
        }
    }
}
