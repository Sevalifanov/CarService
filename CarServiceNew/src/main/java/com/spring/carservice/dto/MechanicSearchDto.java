package com.spring.carservice.dto;

/**
 * MechanicSearchDto -модель для поиска механиков
 */
public class MechanicSearchDto {

    /**
     * firstName -Имя потрудника
     */
    private String firstName;

    /**
     * lastName -Фамилия сотрудника
     */
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
