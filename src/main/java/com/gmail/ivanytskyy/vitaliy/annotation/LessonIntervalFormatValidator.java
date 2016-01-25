package com.gmail.ivanytskyy.vitaliy.annotation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
public class LessonIntervalFormatValidator implements ConstraintValidator<LessonIntervalFormat, String>{
	@Override
	public void initialize(LessonIntervalFormat constraintAnnotation) {}
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() != 5){
			return false;
		}
		String[] inputData = value.split("[.]");
		if(inputData.length == 2){
			int[] inputDataAsNumber = new int[2];
			for(int i = 0; i < inputData.length; i++){
				try{
					inputDataAsNumber[i] = Integer.parseInt(inputData[i]);
				}catch(NumberFormatException nfe){
					return false;
				}
			}			
			int hour = inputDataAsNumber[0];
			//System.out.println("hour " + hour);
			int minutes = inputDataAsNumber[1];
			//System.out.println("minutes " + minutes);
			if(hour < 0 || hour > 24 || minutes < 0 || minutes > 59 || (hour == 24 && minutes > 0)){
				return false;
			}else{
				return true;
			}
		}else{
			return false;
		}
	}
}