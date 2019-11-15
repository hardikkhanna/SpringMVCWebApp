package hibernate.demo.controller;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentCourseValidator implements ConstraintValidator<StudentCourse, String> {

	private String theCourseCode;

	public void initialize(StudentCourse theCourseCode) {
		this.theCourseCode = theCourseCode.value();
	}

	public boolean isValid(String theCode, ConstraintValidatorContext validatorContext) {
		
		boolean result;
		if(theCourseCode != null){
			result = theCode.startsWith(theCourseCode);
		}else{
			result = true;
		}
		
		return result;
	}
}
