package com.spring.carservice.dto;

/**
 * Data Transfer Object (DTO) — один из шаблонов проектирования, используется для передачи данных
 * между подсистемами приложения. Data Transfer Object
 * MechanicDto -воплощение этого шаблона для модели Mechanic
 */
public class MechanicDto {
    /**
     * id -Внутренний идентификационный номер сотрудника, работающего в сервисе
     */
    private Long id;
    /**
     * firstName -Имя потрудника
     */
    private String firstName;
    /**
     * lastName -Фамилия сотрудника
     */
    private String lastName;

    public MechanicDto(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public MechanicDto() {
    }

    @Override
    public String toString() {
        return "MechanicDto{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
