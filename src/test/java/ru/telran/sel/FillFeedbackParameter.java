package ru.telran.sel;

public class FillFeedbackParameter {
	public String name;
	public String email;
	public String phone;
	public String text;

	public FillFeedbackParameter(String name, String email, String phone,
			String text) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.text = text;
	}
}