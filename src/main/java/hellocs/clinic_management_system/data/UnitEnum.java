/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.data;

/**
 * [OVERVIEW] Unit Enumeration.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
public enum UnitEnum {

    UNDEFINED(0), TEMP(1), CONTAINER(2), PACK(3), COUNT(4);

    private final Integer value;

    UnitEnum(Integer i) {
        value = i;
    }

    public Integer value() {
        return value;
    }

    public static UnitEnum parse(Integer i) {
        UnitEnum unit = UnitEnum.UNDEFINED;
        for (UnitEnum item : UnitEnum.values()) {
            if (item.value().equals(i)) {
                unit = item;
                break;
            }
        }

        return unit;
    }
}
