package com.transround.dev.localizationdemo;

public class Language {
	String name;
	long population;
	long smartPhoneUsers;
	long englishUsers;
	long localLanguageUsers;
	double smartPhonePenetration;

	public Language() {
		super();
	}

	public Language(String name, int population, int englishUsers,
			long localLanguageUsers, int smartPhonePenetration) {
		super();
		this.name = name;
		this.population = population;
		this.englishUsers = englishUsers;
		this.localLanguageUsers = localLanguageUsers;
		this.smartPhonePenetration = smartPhonePenetration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public long getSmartPhoneUsers() {
		return smartPhoneUsers;
	}

	public void setSmartPhoneUsers(long smartPhoneUsers) {
		this.smartPhoneUsers = smartPhoneUsers;
	}

	public long getEnglishUsers() {
		return englishUsers;
	}

	public void setEnglishUsers(long englishUsers) {
		this.englishUsers = englishUsers;
	}

	public long getLocalLanguageUsers() {
		return localLanguageUsers;
	}

	public void setLocalLanguageUsers(long localLanguageUsers) {
		this.localLanguageUsers = localLanguageUsers;
	}

	public double getSmartPhonePenetration() {
		return smartPhonePenetration;
	}

	public void setSmartPhonePenetration(double smartPhonePenetration) {
		this.smartPhonePenetration = smartPhonePenetration;
	}

	@Override
	public String toString() {

		return getName();
	}

}
