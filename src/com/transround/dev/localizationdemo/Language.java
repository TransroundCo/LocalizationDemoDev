package com.transround.dev.localizationdemo;

public class Language {
	String mLanguageCode;
	long mPopulation;
	long mSmartPhoneUsers;
	long mEnglishUsers;
	long mLocalLanguageUsers;
	double mSmartPhonePenetration;

	public Language() {
		super();
	}

	public Language(int population, int englishUsers, long localLanguageUsers,
			int smartPhonePenetration) {
		super();
		this.mPopulation = population;
		this.mEnglishUsers = englishUsers;
		this.mLocalLanguageUsers = localLanguageUsers;
		this.mSmartPhonePenetration = smartPhonePenetration;
	}

	public String getLanguageCode() {
		return mLanguageCode;
	}

	public void setLanguageCode(String languageCode) {
		this.mLanguageCode = languageCode;
	}

	public long getPopulation() {
		return mPopulation;
	}

	public void setPopulation(long population) {
		this.mPopulation = population;
	}

	public long getSmartPhoneUsers() {
		return mSmartPhoneUsers;
	}

	public void setSmartPhoneUsers(long smartPhoneUsers) {
		this.mSmartPhoneUsers = smartPhoneUsers;
	}

	public long getEnglishUsers() {
		return mEnglishUsers;
	}

	public void setEnglishUsers(long englishUsers) {
		this.mEnglishUsers = englishUsers;
	}

	public long getLocalLanguageUsers() {
		return mLocalLanguageUsers;
	}

	public void setLocalLanguageUsers(long localLanguageUsers) {
		this.mLocalLanguageUsers = localLanguageUsers;
	}

	public double getSmartPhonePenetration() {
		return mSmartPhonePenetration;
	}

	public void setSmartPhonePenetration(double smartPhonePenetration) {
		this.mSmartPhonePenetration = smartPhonePenetration;
	}

}
