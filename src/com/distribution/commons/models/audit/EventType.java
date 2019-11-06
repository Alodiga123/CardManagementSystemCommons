package com.cms.commons.models.audit;

public enum EventType {

    CREATE(1l),
    READ(2l),
    UPDATE(3l),
    DELETE(4l),
    WEB_SERVICE_CALL(5l);
    private Long value;

    private EventType(Long value) {
	this.value = value;
    }

    public Long getValue() {
	return value;
    }
}
