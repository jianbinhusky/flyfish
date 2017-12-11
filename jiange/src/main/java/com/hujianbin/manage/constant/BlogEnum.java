package com.hujianbin.manage.constant;

/**
 * Created by hujb4 on 2016/12/8.
 */
public enum BlogEnum implements JobyEnumValue {

    UNPUBISHED(0),

    PUBLISHED(1),

    ABORT(0),

    NORMAL(1),

    LIKE("like")

    ;
    /**<i>Generated model type code constant.</i>*/
    public final static String _TYPECODE = "NavigationStyleEnum";


    /** The code of this enum.*/
    private final Object code;

    /**
     * Creates a new enum value for this enum type.
     *
     * @param code the enum value code
     */
    BlogEnum(final Object code) {
        this.code = code;
    }


    /**
     * Gets the code of this enum value.
     *
     * @return code of value
     */
    @Override
    public Object getCode() {
        return this.code;
    }

    /**
     * Gets the type this enum value belongs to.
     *
     * @return code of type
     */
    @Override
    public String getType() {
        return getClass().getSimpleName();
    }
}
