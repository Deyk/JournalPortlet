package com.softwerke.journalportlet.util;

public enum ArticleStatus {

	CREATED(0), CONFIRMED(1), REFUSED(2), WAITING_TO_BE_CONFIRMED(3);

	private int value;

	ArticleStatus(final int value) {
		this.value = value;

	}

	public int getValue() {
		return this.value;
	}
}
