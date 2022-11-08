package com.qiangjiang.ironOldMan.model;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by jq on 2020-10-14
 */
public class BpmData {
    @JSONField(name="MAP_TYPE")
    private String map_type;
    @JSONField(name="FIELD_LENGTH")
    private String field_length;
    @JSONField(name="ISDISPLAY")
    private String isdisplay;
    @JSONField(name="VALIDATERULE")
    private String validaterule;
    @JSONField(name="rowid")
    private String rowid;
    @JSONField(name="FIELD_TYPE")
    private String field_type;
    @JSONField(name="VALIDATETYPE")
    private String validatetype;
    @JSONField(name="FIELD_DEFAULT")
    private String field_default;
    @JSONField(name="VALIDATETIP")
    private String validatetip;
    @JSONField(name="FIELD_TITLE")
    private String field_title;
    @JSONField(name="SET_VALIDATE")
    private String set_validate;
    @JSONField(name="FIELD_NAME")
    private String field_name;
    @JSONField(name="ISCOPY")
    private String iscopy;
    @JSONField(name="UUID")
    private String uuid;
    @JSONField(name="VALIDATEERR")
    private String validateerr;
    @JSONField(name="FIELD_NULLABLE")
    private String field_nullable;
    @JSONField(name="ISMODIFY")
    private String ismodify;
    @JSONField(name="DISPLAY_TYPE")
    private String display_type;
    private String db_field_type;

    public String getDb_field_type() {
        return db_field_type;
    }

    public void setDb_field_type(String db_field_type) {
        this.db_field_type = db_field_type;
    }

    public String getMap_type() {
        return map_type;
    }

    public void setMap_type(String map_type) {
        this.map_type = map_type;
    }

    public String getField_length() {
        return field_length;
    }

    public void setField_length(String field_length) {
        this.field_length = field_length;
    }

    public String getIsdisplay() {
        return isdisplay;
    }

    public void setIsdisplay(String isdisplay) {
        this.isdisplay = isdisplay;
    }

    public String getValidaterule() {
        return validaterule;
    }

    public void setValidaterule(String validaterule) {
        this.validaterule = validaterule;
    }

    public String getRowid() {
        return rowid;
    }

    public void setRowid(String rowid) {
        this.rowid = rowid;
    }

    public String getField_type() {
        return field_type;
    }

    public void setField_type(String field_type) {
        this.field_type = field_type;
    }

    public String getValidatetype() {
        return validatetype;
    }

    public void setValidatetype(String validatetype) {
        this.validatetype = validatetype;
    }

    public String getField_default() {
        return field_default;
    }

    public void setField_default(String field_default) {
        this.field_default = field_default;
    }

    public String getValidatetip() {
        return validatetip;
    }

    public void setValidatetip(String validatetip) {
        this.validatetip = validatetip;
    }

    public String getField_title() {
        return field_title;
    }

    public void setField_title(String field_title) {
        this.field_title = field_title;
    }

    public String getSet_validate() {
        return set_validate;
    }

    public void setSet_validate(String set_validate) {
        this.set_validate = set_validate;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    public String getIscopy() {
        return iscopy;
    }

    public void setIscopy(String iscopy) {
        this.iscopy = iscopy;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getValidateerr() {
        return validateerr;
    }

    public void setValidateerr(String validateerr) {
        this.validateerr = validateerr;
    }

    public String getField_nullable() {
        return field_nullable;
    }

    public void setField_nullable(String field_nullable) {
        this.field_nullable = field_nullable;
    }

    public String getIsmodify() {
        return ismodify;
    }

    public void setIsmodify(String ismodify) {
        this.ismodify = ismodify;
    }

    public String getDisplay_type() {
        return display_type;
    }

    public void setDisplay_type(String display_type) {
        this.display_type = display_type;
    }
}



