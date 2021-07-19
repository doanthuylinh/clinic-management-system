/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.utils;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * [OVERVIEW] DataUtils.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/19      LinhDT             Create new
*/
public class DataUtils {

    /**
     * isNullWithMemberNameByJson
     * @author: LinhDT
     * @param object
     * @param member
     * @return
     * @throws ApiValidateException
     */
    public static boolean isNullWithMemberNameByJson(JsonObject object, String member) throws ApiValidateException {
        if (!object.has(member) || object.has(member) && (object.get(member).isJsonNull() || object.get(member).getAsString().equals(""))) {
            return true;
        }
        return false;
    }

    /**
     * getAsIntegerByJson
     * @author: LinhDT
     * @param object
     * @param member
     * @return
     * @throws ApiValidateException
     */
    public static Integer getAsIntegerByJson(JsonObject object, String member) throws ApiValidateException {
        try {
            if (object.has(member)) {
                return object.get(member).getAsInt();
            }
        } catch (Exception e) {
            throw new ApiValidateException("ERR", "JSON " + member + " is invalid.");
        }
        return null;
    }

    /**
     * getAsStringByJson
     * @author: LinhDT
     * @param object
     * @param member
     * @return
     * @throws ApiValidateException
     */
    public static String getAsStringByJson(JsonObject object, String member) throws ApiValidateException {
        try {
            if (object.has(member)) {
                return object.get(member).getAsString();
            }
        } catch (Exception e) {
            throw new ApiValidateException("ERR", "JSON " + member + " is invalid.");
        }
        return null;
    }

    /**
     * getAsDoubleByJson
     * @author: LinhDT
     * @param object
     * @param member
     * @return
     * @throws ApiValidateException
     */
    public static Double getAsDoubleByJson(JsonObject object, String member) throws ApiValidateException {
        try {
            if (object.has(member)) {
                return object.get(member).getAsDouble();
            }
        } catch (Exception e) {
            throw new ApiValidateException("ERR", "JSON " + member + " is invalid.");
        }
        return null;
    }

    /**
     * getAsObjectByJson
     * @author: LinhDT
     * @param object
     * @param member
     * @return
     * @throws ApiValidateException
     */
    public static JsonObject getAsObjectByJson(JsonObject object, String member) throws ApiValidateException {
        try {
            if (object.has(member)) {
                return object.get(member).getAsJsonObject();
            }
        } catch (Exception e) {
            throw new ApiValidateException("ERR", "JSON " + member + " is invalid.");
        }
        return null;
    }

    /**
     * isNullOrEmpty
     * @author: LinhDT
     * @param data
     * @return
     */
    public static boolean isNullOrEmpty(String data) {
        if (data == null || data.trim().isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * isNullOrEmpty
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    public static boolean isNullOrEmpty(Integer data) throws ApiValidateException {
        if (data == null) {
            return true;
        }
        return false;
    }
    
    /**
     * isNullOrEmpty
     * @author: LinhDT
     * @param data
     * @return
     * @throws ApiValidateException
     */
    public static boolean isNullOrEmpty(Double data) throws ApiValidateException {
        if (data == null) {
            return true;
        }
        return false;
    }

    /**
     * isNullOrEmpty
     * @author: LinhDT
     * @param data
     * @return
     */
    public static boolean isNullOrEmpty(JsonElement data) {
        if (data == null) {
            return true;
        }
        return false;
    }

    /**
     * getEntityByJsonString
     * @author: LinhDT
     * @param <T>
     * @param data
     * @param typeoff
     * @return
     * @throws ApiValidateException
     */
    public static <T> T getEntityByJsonString(String data, Class<T> typeoff) throws ApiValidateException {
        if (DataUtils.isNullOrEmpty(data) == true) {
            throw new ApiValidateException("ERR01", MessageUtils.getMessage("ERR01", "Data"));
        }

        T entity = new Gson().fromJson(data, typeoff);

        return entity;
    }
}
